package winterMVC;



import java.lang.reflect.Method;

import Factory.ApplicationContext;
import HandlerMapping.DefaultHandlerMapping;
import HandlerMapping.HandlerMapping;
import ViewResolver.DefaultViewResolver;
import util.ReflectUtil;

public class Test {
public static void main(String[] args) throws Exception {
	System.out.println("11");
	ApplicationContext.init();
	String uri="ds/dsa1/1";
	System.out.println(uri.substring(uri.indexOf("/"), uri.length()));
	DefaultHandlerMapping z=(DefaultHandlerMapping)ApplicationContext.getBean("handlerMapping");
	System.out.println(z.toString());
	
}
}
