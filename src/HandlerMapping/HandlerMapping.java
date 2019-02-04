package HandlerMapping;

import javax.servlet.http.HttpServletRequest;

public interface HandlerMapping {
	public HandlerExecutionChain getHandler(HttpServletRequest request);
}
