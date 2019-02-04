package Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModelAndView.ModelAndView;

public interface Interceptor {
	public void preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception;

	public void postHandle(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView)
			throws Exception;

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception;
}
