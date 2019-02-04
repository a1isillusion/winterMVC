package HandlerMapping;

import java.lang.reflect.Method;

public class HandlerMethod {
	public Object bean;
	public Method method;

	public static HandlerMethod create(Object bean, Method method) {
		HandlerMethod handlerMethod = new HandlerMethod();
		handlerMethod.bean = bean;
		handlerMethod.method = method;
		return handlerMethod;
	}
}
