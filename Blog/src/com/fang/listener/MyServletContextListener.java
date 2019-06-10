package com.fang.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

	/**
	 * 当应用程序吃初始化的时候调用
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub

		ServletContext sc = sce.getServletContext();
		String root = sc.getInitParameter("SERVER_ROOT");
		sc.setAttribute("SERVER_ROOT", root);

	}

	/**
	 * 当应用程序卸载的时候调用
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
