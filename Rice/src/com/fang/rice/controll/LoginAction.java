package com.fang.rice.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.rice.dbController.UserController;
import com.fang.rice.dbController.UserOpration;
import com.fang.rice.model.User;
import com.google.gson.Gson;
import com.xiaofangfang.rice.model.StatusResponseJson;


@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		String telNumber=req.getParameter("name");
		String password=req.getParameter("password");
		Gson gson=new Gson();
		UserOpration uo=new UserController();
		User user=new User(telNumber, "", password);
		System.out.print("用户密码"+password);
		
		boolean isSucessful=uo.verificationLogin(user);
		if (isSucessful) {//代表响应成功
			PrintWriter pw=resp.getWriter();
			StatusResponseJson sResponseJson=new StatusResponseJson(StatusResponseJson.LOGIN_SUCESSFUL);
			String jsonData=gson.toJson(sResponseJson);
			pw.print(jsonData);
			return;
		}else {
			//代表的是响应失败
			PrintWriter pw=resp.getWriter();
			StatusResponseJson sResponseJson=new StatusResponseJson(StatusResponseJson.LOGIN_ERROR);
			String jsonData=gson.toJson(sResponseJson);
			pw.print(jsonData);
			return;
		}

	}
	

}
