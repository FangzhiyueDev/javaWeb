package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.dbController.UserDbController;
import com.fang.dbController.UserOpration;
import com.fang.model.Error;
import com.fang.model.User;
import com.google.gson.Gson;


@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	
	
	
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		Gson gson=new Gson();
		String opration=req.getParameter("opration");
		if(opration==null) {
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter pw=resp.getWriter();
			Error error=new Error("参数错误");
			String paramError=gson.toJson(error);
			pw.print(paramError);
			return;
		}
		
		//返回管理员的详细信息
		if("detail".equals(opration)) {
				UserOpration uo=UserDbController.getInstance();
				List<User> users=uo.queryManagerUserInfo(1);
				String jsonData=gson.toJson(users);
				resp.setContentType("application/json;charset=utf-8");
				PrintWriter pw=resp.getWriter();
				pw.print(jsonData);
				return;
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
	}
}
