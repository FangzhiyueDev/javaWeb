package com.fang.day01.funcArea;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试的是bean的作用域
 * 
 * @author fang
 *
 */
public class TestFunArea {

	@Test
	public void demo() {
		// TODO Auto-generated method stub

		String xmlPathString = "com/fang/day01/funcArea/bean.xml";

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPathString);

		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		System.out.println(userService.hashCode());
		UserService userService1 = (UserService) applicationContext.getBean("userServiceId");
		System.out.println(userService1.hashCode());
	}

}
