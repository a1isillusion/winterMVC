package HandlerMapping;

import Annotation.RequestMapping;

public class RequestMappingInfo {
	public String path;

	public RequestMappingInfo combine(RequestMappingInfo parentInfo) {
		if (path.charAt(0) != '/') {
			path = "/" + path;
		}
		if (parentInfo.path.charAt(0) != '/') {
			parentInfo.path = "/" + parentInfo.path;
		}
		path = parentInfo.path + path;
		return this;
	}

	public static RequestMappingInfo create(RequestMapping requestMapping) {
		RequestMappingInfo info = new RequestMappingInfo();
		info.path = requestMapping.path();
		return info;
	}
}
