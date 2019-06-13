package com.fang.day01.bean.Instanll.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {

	@Test
	public void demo() {
		// TODO Auto-generated method stub

		UserService userService = new UserServiceImpl();

		userService.addUser();

	}

	@Test
	public void demo1() {
		// TODO Auto-generated method stub

		String xmlPathString = "com/fang/day01/bean/Instanll/xml/bean.xml";

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPathString);

		UserService userService = (UserService) applicationContext.getBean("userServiceId");

		userService.addUser();

	}

	@Test
	public void demo2() {
		// TODO Auto-generated method stub

		String xmlPathString = "com/fang/day01/bean/Instanll/xml/bean.xml";

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPathString);

		UserService userService = (UserService) applicationContext.getBean("userServiceId1");

		userService.addUser();

	}

	@Test
	public void demo3() {
		// TODO Auto-generated method stub

		String xmlPathString = "com/fang/day01/bean/Instanll/xml/bean.xml";

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPathString);

		UserService userService = (UserService) applicationContext.getBean("userServiceId2");

		userService.addUser();

	}

}
