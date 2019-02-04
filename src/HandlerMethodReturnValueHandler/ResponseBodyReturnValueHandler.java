package HandlerMethodReturnValueHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import ModelAndView.ModelAndView;

public class ResponseBodyReturnValueHandler implements ReturnValueHandler {

	@Override
	public boolean supportsReturnValue(Class<?> returnType) {
		return false;
	}

	@Override
	public void handleReturnValue(Object returnValue, Class<?> returnType, HttpServletRequest request,
			HttpServletResponse response, ModelAndView mav) throws Exception {
		if (returnType.equals(String.class)) {
			response.getWriter().append(returnValue.toString());
		} else {
			response.getWriter().append(JSON.toJSONString(returnValue));
		}
	}

}
