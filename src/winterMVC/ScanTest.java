package winterMVC;

import Annotation.RequestMapping;
import Annotation.ResponseBody;
import ModelAndView.ModelAndView;
import annotation.Component;

@Component
@RequestMapping(path="/test")
public class ScanTest {
public String i="≤‚ ‘11";
public int z=1;
@RequestMapping(path="/show")
public String show(ModelAndView mav) {
	mav.setAttribute("love", "me");
	return "view.jsp";
}
}
