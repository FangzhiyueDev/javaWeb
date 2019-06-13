package com.fang.day01.core;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestApi {

	@Test
	public void demo1() {
		// TODO Auto-generated method stub

		String xmlPathString = "com/fang/day01/core/bean.xml";

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPathString);

		BookService bookServiceId = (BookService) applicationContext.getBean("bookServiceId");

		bookServiceId.addBook();

	}

	@Test
	public void demo2() {
		// TODO Auto-generated method stub

		String xmlPathString = "com/fang/day01/core/bean.xml";

		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(xmlPathString));

		BookService bookServiceId = (BookService) beanFactory.getBean("bookServiceId");

		bookServiceId.addBook();

	}

}
