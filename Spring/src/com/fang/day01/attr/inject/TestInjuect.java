package com.fang.day01.attr.inject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInjuect {

	@Test
	public void demo1() {
		// TODO Auto-generated method stub

		String xmlPathString = "com/fang/day01/attr/inject/bean.xml";

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPathString);

		User user = (User) applicationContext.getBean("userId");

		System.out.println(user.getUsername());

		User user1 = (User) applicationContext.getBean("userId1");

		System.out.println(user1.getUsername());

		User user2 = (User) applicationContext.getBean("userId2");

		System.out.println(user2.getAge());

	}

}
