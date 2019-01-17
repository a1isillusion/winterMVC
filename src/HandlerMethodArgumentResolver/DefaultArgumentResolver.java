package HandlerMethodArgumentResolver;

import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

import ModelAndView.ModelAndView;

public class DefaultArgumentResolver implements ArgumentResolver {

	@Override
	public boolean supportsParameter(Parameter parameter) {
		return true;
	}

	@Override
	public Object resolveArgument(Parameter parameter, String parameterName, HttpServletRequest request,
			ModelAndView mav) {
		
		return null;
	}

}
