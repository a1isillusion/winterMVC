package winterMVC;

import Factory.ApplicationContext;

public class Test {
public static void main(String[] args) {
	System.out.println("11");
	ApplicationContext.init();
	System.out.println(ApplicationContext.getBean("winterMVC.ScanTest"));
}
}
