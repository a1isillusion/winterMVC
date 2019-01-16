package winterMVC;

import Factory.ApplicationContext;

public class Test {
public static void main(String[] args) {
	System.out.println("11");
	ApplicationContext.init();
	String uri="ds/dsa1/1";
	System.out.println(uri.substring(uri.indexOf("/"), uri.length()));
	System.out.println(ApplicationContext.getBean("winterMVC.ScanTest"));
}
}
