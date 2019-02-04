package winterMVC;

import java.lang.reflect.Method;

import Factory.ApplicationContext;
import util.ReflectUtil;

public class Test {
	public static void main(String[] args) throws Exception {
		System.out.println("11");
		ApplicationContext.init();
		String uri = "forward:/index";
		String type = null;
		String name = null;
		if (uri.contains(":/")) {
			String[] splitString = uri.split(":/");
			type = splitString[0];
			name = splitString[1];
		}
		System.out.println(type + name);
	}
}
