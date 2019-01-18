package ViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModelAndView.ModelAndView;

public class DefaultViewResolver implements ViewResolver{
public String prefix;
public String suffix;
@Override
public void route(HttpServletRequest request,HttpServletResponse response,ModelAndView mav) throws Exception {
	if(mav.getViewType().equals("forward")) {
		String viewName=mav.getViewName();
		if(viewName.charAt(0)!='/') {
			viewName="/"+viewName;
		}
		request.getRequestDispatcher(viewName).forward(request, response);
	}else if (mav.getViewType().equals("redirect")) {
		response.setContentType("text/html; charset=UTF-8");
        response.sendRedirect(mav.getViewName());
	}
}
}
