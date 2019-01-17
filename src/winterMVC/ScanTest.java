package winterMVC;

import Annotation.RequestMapping;
import annotation.Component;

@Component
@RequestMapping(path="/test")
public class ScanTest {
public String i="≤‚ ‘11";
@RequestMapping(path="/show")
public void show(Float a,Integer b) {
	System.out.println("show!"+a+b);
}
}
