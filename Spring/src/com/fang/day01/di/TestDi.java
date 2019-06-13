package com.fang.day01.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDi {

	@Test
	public void demo1() {
		// TODO Auto-generated method stub

		String xmlPathString = "com/fang/day01/di/bean.xml";

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPathString);

		BookService bookServiceId = (BookService) applicationContext.getBean("bookServiceId");

		bookServiceId.addBook();

	}

}
