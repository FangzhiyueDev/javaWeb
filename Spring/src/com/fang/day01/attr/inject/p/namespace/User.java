package com.fang.day01.attr.inject.p.namespace;

import java.util.List;

public class User {

	private Integer uid;

	private String username;

	private Integer age;

	private Person person;

	private String[] nike;

	private List<String> friends;

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public void setNike(String[] nike) {
		this.nike = nike;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Person getPerson() {
		return person;
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
