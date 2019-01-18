package winterMVC;

import Annotation.RequestMapping;
import Annotation.ResponseBody;
import annotation.Component;

@Component
@RequestMapping(path="/test")
public class ScanTest {
public String i="≤‚ ‘11";
@RequestMapping(path="/show")
@ResponseBody
public String show(Float a,Integer b) {
	System.out.println("show!"+a+b);
	return "show!"+a+b;
}
}
