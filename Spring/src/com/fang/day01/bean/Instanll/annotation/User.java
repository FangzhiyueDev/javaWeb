package com.fang.day01.bean.Instanll.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")
public class User {

	@Value("小芳芳")
	private String name;

	@Value("23")
	private Integer age;

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

}
