package com.fang.day01.bean.Instanll.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("person")
public class Person {

	@Value("android开发工程师")
	private String price;

	@Value("android软件的开发测试")
	private String func;

	public void setFunc(String func) {
		this.func = func;
	}

	public String getFunc() {
		return func;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

}
