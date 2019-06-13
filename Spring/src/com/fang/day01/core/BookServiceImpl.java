package com.fang.day01.core;

public class BookServiceImpl implements BookService {

	// 接口和setter方法

	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void addBook() {
		System.out.println("创建");
	}

}
