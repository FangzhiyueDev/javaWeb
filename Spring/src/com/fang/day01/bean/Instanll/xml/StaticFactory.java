package com.fang.day01.bean.Instanll.xml;

public class StaticFactory {

	public static UserService getUserService() {
		return new UserServiceImpl();
	}

}
