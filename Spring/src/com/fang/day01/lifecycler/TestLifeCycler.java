package com.fang.day01.lifecycler;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifeCycler {

	@Test
	public void demo1() {
		// TODO Auto-generated method stub

		String xmlPathString = "com/fang/day01/lifecycler/bean.xml";

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPathString);

		UserService userService = (UserService) applicationContext.getBean("userServiceId");

		/**
		 * 
		 * 目标方法执行前后会调用初始化和销毁方法
		 * 
		 * 
		 * 
		 */
		userService.addUser();

		((AbstractApplicationContext) applicationContext).destroy();

	}

}
