package HandlerMethodReturnValueHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModelAndView.ModelAndView;

public class DefaultReturnValueHandler implements ReturnValueHandler {

	@Override
	public boolean supportsReturnValue(Class<?> returnType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object handleReturnValue(Object returnValue, Class<?> returnType, HttpServletRequest request,
			HttpServletResponse response, ModelAndView mav) {
		// TODO Auto-generated method stub
		return null;
	}



}
