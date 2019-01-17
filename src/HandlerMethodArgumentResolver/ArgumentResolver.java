package HandlerMethodArgumentResolver;

import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

import ModelAndView.ModelAndView;

public interface ArgumentResolver {
public boolean supportsParameter(Parameter parameter);
public Object resolveArgument(Parameter parameter,String parameterName,HttpServletRequest request,ModelAndView mav);
}
