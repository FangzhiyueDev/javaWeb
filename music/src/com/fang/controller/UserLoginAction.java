package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fang.mapping.UserDbCenter;
import com.fang.model.StatusResponse;
import com.fang.model.User;
import com.google.gson.Gson;


/**
 * 用户额登录的实现
 * @author fang
 *
 */
@WebServlet("/UserLoginAction")
public class UserLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		String loginStatus=request.getParameter("loginStatus");
		
		if(user!=null&&password!=null) {
			
			loginCheck(request,response,user,password);
		}
		   
		if(loginStatus!=null) {
			getLoginStatus(request,response);
		}
		
		
		
	}


	private void getLoginStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		HttpSession session=request.getSession();
		String userName=(String) session.getAttribute("user");
		User user;
		if(userName!=null) {
			 user=new User(userName,null);
		}else {
			user=new User();
		}
		  PrintWriter pw=response.getWriter();
		  Gson gson=new Gson();
		  String jsonData=gson.toJson(user);
		  pw.print(jsonData);
		    return;
		
	}


	private void loginCheck(HttpServletRequest request, HttpServletResponse response, String user, String password) throws IOException {
	
	    UserDbCenter userDbCenter=new UserDbCenter();
	    boolean isSucessful=userDbCenter.loginCheck(user, password);
	    StatusResponse statusResponse;
	    if(isSucessful) {
	    	HttpSession  session=request.getSession();
	    	session.setAttribute("user",user); //代表已经登录
	    statusResponse=new StatusResponse(StatusResponse.response_sucessful);	
	    }else {
	      statusResponse=new StatusResponse(StatusResponse.response_error);
	    }
	    
	    PrintWriter pw=response.getWriter();
	    Gson gson=new Gson();
	    String jsonData=gson.toJson(statusResponse);
	    pw.print(jsonData);
	    return;
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
