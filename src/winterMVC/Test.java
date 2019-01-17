package winterMVC;



import java.lang.reflect.Method;

import Factory.ApplicationContext;
import util.ReflectUtil;

public class Test {
public static void main(String[] args) throws Exception {
	System.out.println("11");
	ApplicationContext.init();
	String uri="ds/dsa1/1";
	System.out.println(uri.substring(uri.indexOf("/"), uri.length()));
	System.out.println(ApplicationContext.getBean("winterMVC.ScanTest"));
	ScanTest test=new ScanTest();
	
	Method method=test.getClass().getMethod("show",String.class,String.class);
	for(String i:ReflectUtil.getMethodParamNames(method))System.out.println(i);
	
}
}
