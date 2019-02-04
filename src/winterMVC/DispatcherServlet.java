package winterMVC;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Factory.ApplicationContext;
import Factory.WinterFactory;
import HandlerAdapter.HandlerAdapter;
import HandlerMapping.HandlerExecutionChain;
import HandlerMapping.HandlerMapping;
import Interceptor.Interceptor;
import ModelAndView.ModelAndView;
import ViewResolver.ViewResolver;

/**
 * winterMVC��������
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private HandlerAdapter handlerAdapter;
	private ViewResolver viewResolver;

	public DispatcherServlet() {
		super();
	}

	public void init() throws ServletException {
		ApplicationContext.init();// ��ʼ��winter
		HashMap<String, Object> beans = WinterFactory.getSingletonBeans();
		for (String key : beans.keySet()) {
			Object bean = beans.get(key);
			if (bean instanceof HandlerMapping) {
				handlerMapping = (HandlerMapping) bean;
			}
			if (bean instanceof HandlerAdapter) {
				handlerAdapter = (HandlerAdapter) bean;
			}
			if (bean instanceof ViewResolver) {
				viewResolver = (ViewResolver) bean;
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doDispatch(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doDispatch(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HandlerExecutionChain chain = handlerMapping.getHandler(request);
		for (Interceptor interceptor : chain.interceptors) {// prehandle
			interceptor.preHandle(request, response, chain.handlerMethod);
		}
		ModelAndView mav = handlerAdapter.handle(request, response, chain.handlerMethod);
		for (Interceptor interceptor : chain.interceptors) {// posthandle
			interceptor.postHandle(request, response, mav);
		}
		if (mav.getNeedResolve()) {
			viewResolver.route(request, response, mav);
		}
		for (Interceptor interceptor : chain.interceptors) {// aftercompletion
			interceptor.afterCompletion(request, response, chain.handlerMethod, null);
		}
	}
}
