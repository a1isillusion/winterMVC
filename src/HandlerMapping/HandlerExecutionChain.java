package HandlerMapping;

import java.util.ArrayList;
import java.util.List;

import Interceptor.Interceptor;

public class HandlerExecutionChain {
public HandlerMethod handlerMethod;
public List<Interceptor> interceptors=new ArrayList<>();
public HandlerMethod getHandlerMethod() {
	return handlerMethod;
}
public void setHandlerMethod(HandlerMethod handlerMethod) {
	this.handlerMethod = handlerMethod;
}
public List<Interceptor> getInterceptors() {
	return interceptors;
}
public void setInterceptor(Interceptor interceptor) {
	interceptors.add(interceptor);
}

}
