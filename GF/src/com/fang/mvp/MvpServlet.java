package com.fang.mvp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



@WebServlet("/MvpServlet")
public class MvpServlet  extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		
		String user=req.getParameter("user");
		String password=req.getParameter("password");
		
		
		Gson gson=new Gson();
		String jsonDataString=gson.toJson(new User(user, password));
		
		
		resp.getWriter().print(jsonDataString);
	
		return;
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	
	
	class User{
		
		private String user;
		private String password;
		
		public User() {
			// TODO Auto-generated constructor stub
		}
		
		
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public User(String user, String password) {
			super();
			this.user = user;
			this.password = password;
		}
		
		
		
		
	}
	
	
	
	
	
	
	

}
