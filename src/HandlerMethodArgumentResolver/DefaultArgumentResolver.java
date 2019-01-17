package HandlerMethodArgumentResolver;

import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ModelAndView.Model;
import ModelAndView.ModelAndView;

public class DefaultArgumentResolver implements ArgumentResolver {

	@Override
	public boolean supportsParameter(Parameter parameter) {
		return true;
	}

	@Override
	public Object resolveArgument(Parameter parameter, String parameterName, HttpServletRequest request,
			HttpServletResponse response,ModelAndView mav) {
		//web类
		if(parameter.getType().equals(HttpServletRequest.class)) {
			return request;
		}
		if(parameter.getType().equals(HttpServletResponse.class)) {
			return response;
		}
		if(parameter.getType().equals(HttpSession.class)) {
			return request.getSession();
		}
		if(parameter.getType().equals(Model.class)) {
			return mav.model;
		}
		if(parameter.getType().equals(ModelAndView.class)) {
			return mav;
		}
		
		//基本类型
		if(parameter.getType().equals(String.class)) {
			return request.getParameter(parameterName);
		}
		if(parameter.getType().equals(float.class)) {
			return new Float(request.getParameter(parameterName)).floatValue();
		}
		if(parameter.getType().equals(Float.class)) {
			return new Float(request.getParameter(parameterName));
		}
		if(parameter.getType().equals(double.class)) {
			return new Double(request.getParameter(parameterName)).doubleValue();
		}
		if(parameter.getType().equals(Double.class)) {
			return new Double(request.getParameter(parameterName));
		}
		if(parameter.getType().equals(int.class)) {
			return new Integer(request.getParameter(parameterName)).intValue();
		}
		if(parameter.getType().equals(Integer.class)) {
			return new Integer(request.getParameter(parameterName));
		}
		if(parameter.getType().equals(char.class)) {
			return request.getParameter(parameterName).charAt(0);
		}
		if(parameter.getType().equals(Character.class)) {
			return new Character(request.getParameter(parameterName).charAt(0));
		}
		if(parameter.getType().equals(boolean.class)) {
			return new Boolean(request.getParameter(parameterName)).booleanValue();
		}
		if(parameter.getType().equals(Boolean.class)) {
			return new Boolean(request.getParameter(parameterName));
		}
		if(parameter.getType().equals(long.class)) {
			return new Long(request.getParameter(parameterName)).longValue();
		}
		if(parameter.getType().equals(Long.class)) {
			return new Long(request.getParameter(parameterName));
		}	
		if(parameter.getType().equals(short.class)) {
			return new Short(request.getParameter(parameterName)).shortValue();
		}
		if(parameter.getType().equals(Short.class)) {
			return new Short(request.getParameter(parameterName));
		}
		if(parameter.getType().equals(byte.class)) {
			return new Byte(request.getParameter(parameterName)).byteValue();
		}
		if(parameter.getType().equals(Byte.class)) {
			return new Byte(request.getParameter(parameterName));
		}
		
		//其他类
		return null;
	}

}
