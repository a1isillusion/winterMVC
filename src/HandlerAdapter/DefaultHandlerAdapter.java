package HandlerAdapter;

import java.util.ArrayList;
import java.util.List;

import HandlerMethodArgumentResolver.ArgumentResolver;
import HandlerMethodArgumentResolver.DefaultArgumentResolver;
import HandlerMethodReturnValueHandler.DefaultReturnValueHandler;
import HandlerMethodReturnValueHandler.ReturnValueHandler;
import lifecycle.InitializingBean;

public class DefaultHandlerAdapter implements HandlerAdapter,InitializingBean{
    List<ArgumentResolver> argumentResolvers;
    List<ReturnValueHandler> returnValueHandlers;
	@Override
	public void afterPropertiesSet() {
		System.out.println("handleradapter init");
		argumentResolvers=new ArrayList<>();
		returnValueHandlers=new ArrayList<>();
		argumentResolvers.add(new DefaultArgumentResolver());
		returnValueHandlers.add(new DefaultReturnValueHandler());
	}

}
