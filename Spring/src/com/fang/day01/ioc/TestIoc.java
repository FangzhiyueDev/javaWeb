package com.fang.day01.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {

	@Test
	public void demo() {
		// TODO Auto-generated method stub

		UserService userService = new UserServiceImpl();

		userService.addUser();

	}

	@Test
	public void demo1() {
		// TODO Auto-generated method stub

		String xmlPathString = "com/fang/day01/ioc/bean.xml";

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPathString);

		UserService userService = (UserService) applicationContext.getBean("userServiceId");

		userService.addUser();

	}

}
