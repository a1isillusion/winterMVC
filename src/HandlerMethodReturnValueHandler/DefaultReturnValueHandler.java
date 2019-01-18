package HandlerMethodReturnValueHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModelAndView.ModelAndView;

public class DefaultReturnValueHandler implements ReturnValueHandler {

	@Override
	public boolean supportsReturnValue(Class<?> returnType) {
		return true;
	}

	@Override
	public void handleReturnValue(Object returnValue, Class<?> returnType, HttpServletRequest request,
			HttpServletResponse response, ModelAndView mav) throws Exception {
        if(returnType.equals(String.class)) {
        	if(returnValue.toString().contains(":/")) {
        		String[] splitString=returnValue.toString().split(":/");
        		mav.setViewType(splitString[0]);
        		mav.setViewName(splitString[1]);
        	}else {
				mav.setViewName((String)returnValue);
			}        	
        }
	}

}
