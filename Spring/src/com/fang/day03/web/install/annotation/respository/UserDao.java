package com.fang.day03.web.install.annotation.respository;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	public void getUser() {

		System.out.println("获得用户的信息，通过dao层获得数据");
	}

}
