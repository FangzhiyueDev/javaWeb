package com.fang.day01.bean.Instanll.xml;

public class InstanceFactory {

	public UserService createService() {

		return new UserServiceImpl();
	}

}
