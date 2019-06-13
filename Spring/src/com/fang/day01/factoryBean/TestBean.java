package com.fang.day01.factoryBean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {

	@Test
	public void demo1() {
		// TODO Auto-generated method stub

		String xmlPathString = "com/fang/day01/factoryBean/bean.xml";

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPathString);

		BookDao bookDao = (BookDao) applicationContext.getBean("bookDaoId");

		bookDao.addBook();
	}

}
