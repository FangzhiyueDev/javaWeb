package com.fang.day03.web.install.annotation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fang.day01.bean.Instanll.annotation.UserService;

/**
 * 用户的controller
 * 
 * @author fang
 *
 */

public class UserController {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/getUser", method = { RequestMethod.GET })
	public String getUser() {

		List<String> users = new ArrayList<String>();
		users.add("添加");
		users.add("添加");
		users.add("添加");
		users.add("添加");

		// 调用 Service
		userService.addUser();
		return "index";
	}
}
