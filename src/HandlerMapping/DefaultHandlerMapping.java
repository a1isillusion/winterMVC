package HandlerMapping;

import java.util.Map;

import lifecycle.InitializingBean;

public class DefaultHandlerMapping implements HandlerMapping,InitializingBean {
    Map<String, RequestMappingInfo> urlMaps;
    Map<RequestMappingInfo, HandlerMethod> handlerMethods;
	@Override
	public void afterPropertiesSet() {
		
		
	}

}
