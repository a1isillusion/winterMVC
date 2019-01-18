package winterMVC;

import Annotation.RequestMapping;
import ModelAndView.ModelAndView;
import annotation.Component;

@Component
@RequestMapping(path="/test")
public class ScanTest {
public String i="≤‚ ‘11";
public int z=1;
@RequestMapping(path="/show")
public ModelAndView show() {
	ModelAndView mav=new ModelAndView();
	mav.setAttribute("love", "me");
	mav.setViewName("view.jsp");
	return mav;
}
}
