package com.fang.day02.aop.jdk;

public class MyAspect {

	public void before() {
		System.out.println("鸡首");
	}

	public void after() {
		System.out.println("牛后");
	}
}