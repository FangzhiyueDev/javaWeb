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



@WebServlet("/RegisterAction")
public class RegisterAction extends HttpServlet {
			
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		String telNumber=req.getParameter("name");
		Gson gson=new Gson();
			System.out.println(telNumber);
		String password=req.getParameter("password");
		System.out.println("password"+password);
		User user=new User(telNumber, "", password);
        addNewUser(req,resp,gson,user);
	}

	/**
	 * 添加一个新的用户
	 * @param req
	 * @param resp
	 * @param gson
	 * @param name
	 * @param password
	 * @throws IOException 
	 */
	private void addNewUser(HttpServletRequest req, HttpServletResponse resp, Gson gson,User user) throws IOException {
	    
		UserOpration uoOpration=new UserController();
		boolean isExist= uoOpration.isExistUser(user);
		if(isExist) {//返回响应码用户存在
			PrintWriter printWriter=resp.getWriter();
			String jsonString=gson.toJson(new StatusResponseJson(StatusResponseJson.EXIST));
			printWriter.print(jsonString);
			return;
		}
		
		//下面进行注册
		boolean isSucessful=uoOpration.addUser(user);
		if(isSucessful) {
			PrintWriter printWriter=resp.getWriter();
			String jsonString=gson.toJson(new StatusResponseJson(StatusResponseJson.SUCESSFUL));
			printWriter.print(jsonString);
			return;
		}else {
			PrintWriter printWriter=resp.getWriter();
			String jsonString=gson.toJson(new StatusResponseJson(StatusResponseJson.ERROR));
			printWriter.print(jsonString);
			return;
		}
		
	}

}
