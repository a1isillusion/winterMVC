package HandlerMethodReturnValueHandler;

import javax.servlet.http.HttpServletRequest;

import ModelAndView.ModelAndView;

public class DefaultReturnValueHandler implements ReturnValueHandler {

	@Override
	public boolean supportsReturnValue(Class<?> returnType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object handleReturnValue(Object returnValue, Class<?> returnType, HttpServletRequest request,
			ModelAndView mav) {
		// TODO Auto-generated method stub
		return null;
	}



}
