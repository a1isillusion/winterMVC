package HandlerMapping;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import Annotation.RequestMapping;
import Factory.WinterFactory;
import lifecycle.InitializingBean;

public class DefaultHandlerMapping implements HandlerMapping,InitializingBean {
    Map<String, RequestMappingInfo> urlMaps;
    Map<RequestMappingInfo, HandlerMethod> handlerMethods;
	@Override
	public void afterPropertiesSet() {
		urlMaps=new HashMap<>();
		handlerMethods=new HashMap<>();
		HashMap<String, Object> beans=WinterFactory.getSingletonBeans();
		for(String key:beans.keySet()) {
			Object bean=beans.get(key);
			Class<?> clazz=bean.getClass();
			if(clazz.isAnnotationPresent(RequestMapping.class)) {
				RequestMappingInfo parentInfo=RequestMappingInfo.create(clazz.getAnnotation(RequestMapping.class));
				for(Method method:clazz.getMethods()) {
					if(method.isAnnotationPresent(RequestMapping.class)) {
						RequestMappingInfo info=RequestMappingInfo.create(method.getAnnotation(RequestMapping.class)).combine(parentInfo);
						HandlerMethod handlerMethod=HandlerMethod.create(bean, method);
						urlMaps.put(info.path, info);
						handlerMethods.put(info, handlerMethod);
					}
				}
			}
		}
	}
    public HandlerExecutionChain getHandler(HttpServletRequest request) {
    	return new HandlerExecutionChain();
    }
}
