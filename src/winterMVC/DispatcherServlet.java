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
import HandlerMapping.HandlerMapping;

/**
 * winterMVC核心类类
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping;
    private HandlerAdapter handlerAdapter;
    public DispatcherServlet() {
        super();
    }
    public void init() throws ServletException {
     ApplicationContext.init();//初始化winter
     HashMap<String, Object> beans=WinterFactory.getSingletonBeans();
		for(String key:beans.keySet()) {
			Object bean=beans.get(key);
			if(bean instanceof HandlerMapping) {
				System.out.println("mapping");
				handlerMapping=(HandlerMapping)bean;
			}
			if(bean instanceof HandlerAdapter) {
				System.out.println("adapter");
				handlerAdapter=(HandlerAdapter)bean;
			}
		}
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getRequestURI());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
