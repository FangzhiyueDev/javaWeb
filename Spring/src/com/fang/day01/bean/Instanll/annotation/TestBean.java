package com.fang.day01.bean.Instanll.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {

	@Test
	public void demo2() {
		// TODO Auto-generated method stub

		String xmlPathString = "com/fang/day01/bean/Instanll/annotation/bean.xml";

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPathString);

		UserService userService = (UserService) applicationContext.getBean("userServiceId");

		/**
		 * 我们将 getUser提到父级中依旧能够实现相应的调用
		 */
		String name = userService.getUser().getName();

		System.out.print(name);
		
		System.out.println(userService.getPerson().getFunc());
		

	}

}
