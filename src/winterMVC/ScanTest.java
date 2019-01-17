package winterMVC;

import Annotation.RequestMapping;
import annotation.Component;

@Component
@RequestMapping(path="/test")
public class ScanTest {
public String i="≤‚ ‘11";
@RequestMapping(path="/show")
public void show(String a,String b) {
	System.out.println(a+b);
}
}
