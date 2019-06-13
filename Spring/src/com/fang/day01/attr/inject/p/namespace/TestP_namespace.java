package com.fang.day01.attr.inject.p.namespace;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestP_namespace {

	@Test
	public void demo1() {
		// TODO Auto-generated method stub

		String xmlPathString = "com/fang/day01/attr/inject/p/namespace/bean.xml";

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPathString);

		User user = (User) applicationContext.getBean("userId");

		System.out.println(user.getPerson().getName());

	}

}
