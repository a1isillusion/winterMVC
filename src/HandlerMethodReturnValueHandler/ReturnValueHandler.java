package HandlerMethodReturnValueHandler;

import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModelAndView.ModelAndView;

public interface ReturnValueHandler {
	public boolean supportsReturnValue(Class<?> returnType);
	public Object handleReturnValue(Object returnValue,Class<?> returnType,HttpServletRequest request,HttpServletResponse response,ModelAndView mav);
}
