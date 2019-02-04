package HandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HandlerMapping.HandlerMethod;
import ModelAndView.ModelAndView;

public interface HandlerAdapter {
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, HandlerMethod handlerMethod)
			throws Exception;
}
