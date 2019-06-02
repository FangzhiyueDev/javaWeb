package com.fang.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * 上下文的监听我们可以设置在上下文中 需要共享的变量等，例如 ContextPath
 * 
 * 也就是 只加载一次的变量，需要配置在这里 。同样也可以在里面配置对象，由于只加载一次，所以其实是单例的实现方案
 * 
 * @author fang
 *
 */
public class MyContextLisntener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		sce.getServletContext().removeAttribute(GlobalValue.CONTEXT_PATH);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute(GlobalValue.CONTEXT_PATH, sce.getServletContext().getContextPath());

		/**
		 * 可以设置session对应的cookie的存活时间
		 */
//		SessionCookieConfig scc = sce.getServletContext().getSessionCookieConfig();
//		scc.setName("jseesionId");
//		scc.setMaxAge(60 * 60);

	}

}
