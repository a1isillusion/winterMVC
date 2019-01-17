package HandlerAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HandlerMapping.HandlerMethod;
import HandlerMethodArgumentResolver.ArgumentResolver;
import HandlerMethodArgumentResolver.DefaultArgumentResolver;
import HandlerMethodReturnValueHandler.DefaultReturnValueHandler;
import HandlerMethodReturnValueHandler.ReturnValueHandler;
import ModelAndView.ModelAndView;
import lifecycle.InitializingBean;

public class DefaultHandlerAdapter implements HandlerAdapter,InitializingBean{
    List<ArgumentResolver> argumentResolvers;
    List<ReturnValueHandler> returnValueHandlers;
	@Override
	public void afterPropertiesSet() {
		System.out.println("handleradapter init");
		argumentResolvers=new ArrayList<>();
		returnValueHandlers=new ArrayList<>();
		argumentResolvers.add(new DefaultArgumentResolver());
		returnValueHandlers.add(new DefaultReturnValueHandler());
	}
    public ModelAndView handle(HttpServletRequest request,HttpServletResponse response,HandlerMethod handlerMethod) {
    	return new ModelAndView();
    }
}
