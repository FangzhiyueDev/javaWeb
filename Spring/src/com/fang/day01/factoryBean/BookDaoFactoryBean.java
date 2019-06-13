package com.fang.day01.factoryBean;

import org.springframework.beans.factory.FactoryBean;

public class BookDaoFactoryBean implements FactoryBean<BookDao> {

	@Override
	public BookDao getObject() throws Exception {
		// TODO Auto-generated method stub
		return new BookDaoImpl();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return BookDao.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
