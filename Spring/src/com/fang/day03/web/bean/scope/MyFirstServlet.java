package com.fang.day03.web.bean.scope;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

@WebServlet("/MyFirstServlet")
public class MyFirstServlet extends HttpServlet {

	private ApplicationContext applicationContext;

	@Override
	public void init() throws ServletException {

		applicationContext = (ApplicationContext) getServletContext()
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * 在这里面测试bean的scope的属性
		 * 
		 */

		UserService userService = (UserService) applicationContext.getBean("userServiceId");

		System.out.println(userService.hashCode());

		System.out.println("................................");
		UserService userServiceId1 = (UserService) applicationContext.getBean("userServiceId1");

		System.out.println(userServiceId1.hashCode());

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
