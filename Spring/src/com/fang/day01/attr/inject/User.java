package com.fang.day01.attr.inject;

public class User {

	private Integer uid;

	private String username;

	private Integer age;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, Integer age) {
		this.username = username;
		this.age = age;
	}

	public User(Integer uid, String username) {
		this.uid = uid;
		this.username = username;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

}
