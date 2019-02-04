package HandlerAdapter;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Annotation.ResponseBody;
import HandlerMapping.HandlerMethod;
import HandlerMethodArgumentResolver.ArgumentResolver;
import HandlerMethodArgumentResolver.DefaultArgumentResolver;
import HandlerMethodReturnValueHandler.DefaultReturnValueHandler;
import HandlerMethodReturnValueHandler.ResponseBodyReturnValueHandler;
import HandlerMethodReturnValueHandler.ReturnValueHandler;
import ModelAndView.ModelAndView;
import lifecycle.InitializingBean;
import util.ReflectUtil;

public class DefaultHandlerAdapter implements HandlerAdapter, InitializingBean {
	public List<ArgumentResolver> argumentResolvers;
	public List<ReturnValueHandler> returnValueHandlers;

	@Override
	public void afterPropertiesSet() {
		argumentResolvers = new ArrayList<>();
		returnValueHandlers = new ArrayList<>();
		argumentResolvers.add(new DefaultArgumentResolver());

		returnValueHandlers.add(new ResponseBodyReturnValueHandler());
		returnValueHandlers.add(new DefaultReturnValueHandler());
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, HandlerMethod handlerMethod)
			throws Exception {
		return invokeHandlerMethod(request, response, handlerMethod);
	}

	public ModelAndView invokeHandlerMethod(HttpServletRequest request, HttpServletResponse response,
			HandlerMethod handlerMethod) throws Exception {
		Parameter[] parameters = handlerMethod.method.getParameters();
		Class<?> returnType = handlerMethod.method.getReturnType();
		String[] parametersName = ReflectUtil.getMethodParamNames(handlerMethod.method);
		Object[] params = new Object[parameters.length];
		ModelAndView mav = new ModelAndView();
		for (int i = 0; i < parameters.length; i++) {
			ArgumentResolver argumentResolver = selectArgumentResolver(parameters[i]);
			params[i] = argumentResolver.resolveArgument(parameters[i], parametersName[i], request, response, mav);
		}
		Method method = handlerMethod.method;
		Object returnValue = method.invoke(handlerMethod.bean, params);
		if (returnValue != null) {
			ReturnValueHandler returnValueHandler = selectReturnValueHandler(returnType, method, mav);
			returnValueHandler.handleReturnValue(returnValue, returnType, request, response, mav);
		}
		return mav;

	}

	public ArgumentResolver selectArgumentResolver(Parameter parameter) {
		for (ArgumentResolver argumentResolver : argumentResolvers) {
			if (argumentResolver.supportsParameter(parameter)) {
				return argumentResolver;
			}
		}
		return null;
	}

	public ReturnValueHandler selectReturnValueHandler(Class<?> returnType, Method method, ModelAndView mav) {
		if (method.isAnnotationPresent(ResponseBody.class)) {
			mav.setNeedResolve(false);
			return returnValueHandlers.get(0);
		}
		for (ReturnValueHandler returnValueHandler : returnValueHandlers) {
			if (returnValueHandler.supportsReturnValue(returnType)) {
				return returnValueHandler;
			}
		}
		return null;
	}
}
