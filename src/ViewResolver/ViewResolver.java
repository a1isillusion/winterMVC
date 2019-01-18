package ViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModelAndView.ModelAndView;

public interface ViewResolver {
public void route(HttpServletRequest request,HttpServletResponse response,ModelAndView mav) throws Exception;
}
