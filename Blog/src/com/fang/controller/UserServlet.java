package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fang.dbController.UserDbController;
import com.fang.dbController.UserOpration;
import com.fang.model.Error;
import com.fang.model.ResponseResult;
import com.fang.model.User;
import com.fang.model.ReuniteModel.UserLoginStatus;
import com.fang.setting.SystemSetting;
import com.google.gson.Gson;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	
	
	
	
	/**
	 * 服务器返回结果码定义
	 */
	public static int[] responseCode= {1,2,3,4,5,6,7,8};
	public static String[] responseResult= {
			"登录成功","请求参数错误","用户或密码错误","用户未登录","该账号已经注册，请直接登录",
			"用户注册成功,","用户注册失败，请稍后再试","用户下线"
	};
	
	/**
	 * 在这里用于实现用户登录的请求,
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json;charset=utf-8");
		Gson gson=new Gson();
		//userid=34567&password=rwe&remember=true
		String userid=req.getParameter("userid");
		String password=req.getParameter("password");
		String nikeName=req.getParameter("nikeName");
		
		String name=req.getParameter("name");
		String hobby=req.getParameter("hobby");
		String likeMusic=req.getParameter("likeMusic");
		String motto=req.getParameter("motto");
		String occupation=req.getParameter("occupation");
		String qq=req.getParameter("qq");
		String likeSinger=req.getParameter("likeSinger");
		
		
/*
hobby	热爱代码，热爱技术
likeMusic	偏爱
likeSinger	陈奕迅
motto	别人都能做到的，为什么自己不行
name	方志月
occupation	学生
qq	1933315107 
		
 */

		if(userid==null&&password==null&&nikeName==null) {
			if(name==null&&hobby==null&&likeMusic==null&&motto==null&&occupation==null&&qq==null&&likeSinger==null) {
				PrintWriter pw=resp.getWriter();
				Error rr=new ResponseResult(responseResult[1],responseCode[1]);
				String paramError=gson.toJson(rr);
				pw.print(paramError);
				return;	
			}
		}
		
			//进行判断执行的操作
			if(userid!=null&&password!=null) {
				if(nikeName!=null) {
				 //执行的是注册的功能
					User user=new User();
					user.setUserid(Integer.parseInt(userid));
					user.setName(nikeName);
					user.setPassword(password);
					progressUserRegister(user,req,resp,gson);
					return;
				}
				//执行的是登录	
				progressUserValidate(userid,password,req,resp,gson);
				return;
			}
			//下面处理用户修改用户信息
			if(name!=null&&hobby!=null&&likeMusic!=null&&motto!=null&&occupation!=null&&qq!=null&&likeSinger!=null) {
				User user=new User(name, qq, occupation, hobby, likeSinger, likeMusic, motto, -1, "","", "");
				progressUserUpdateInfo(user,req,resp,gson);
			}
			
			
		}
	/**
	 * 处理用户数据的更新
	 * @param user
	 * @param req
	 * @param resp
	 * @param gson
	 * @throws IOException 
	 */
	private void progressUserUpdateInfo(User user, HttpServletRequest req, HttpServletResponse resp, Gson gson) throws IOException {
		//避免页面停留过久
		HttpSession httpSession=req.getSession();
		String userid = null;
		String commentTime;
        if(httpSession==null) {
        	PrintWriter pw=resp.getWriter();
			Error error=new ResponseResult(responseResult[3],responseCode[3]);
			String paramError=gson.toJson(error);
			pw.print(paramError);
			return;
        }
        
        userid=(String) httpSession.getAttribute("userid");
        if(userid==null) {
        	//代表的是没有登录，直接跳转到登录界面
			PrintWriter pw=resp.getWriter();
			Error error=new ResponseResult(responseResult[3],responseCode[3]);
			String paramError=gson.toJson(error);
			pw.print(paramError);
			return;
        }
        int useridInt=Integer.parseInt(userid);
        UserOpration userOpration=UserDbController.getInstance();
        user.setUserid(useridInt);
        boolean isSucessful=userOpration.updateUserInfoByUserid(user);
        if(isSucessful) {
        	PrintWriter pw=resp.getWriter();
			Error error=new ResponseResult(responseResult[3],responseCode[3]);
			String paramError=gson.toJson(error);
			pw.print(paramError);
			return;
        }
        
        PrintWriter pw=resp.getWriter();
		Error error=new ResponseResult(responseResult[0],responseCode[0]);
		String paramError=gson.toJson(error);
		pw.print(paramError);
		return;
        
	}

	/**
	 * 处理用户的注册
	 * @param user
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void progressUserRegister(User user, HttpServletRequest req, HttpServletResponse resp,Gson gson) throws IOException {
		UserOpration userOpration=UserDbController.getInstance();
		boolean isExist=userOpration.validateRegister(user);
		if(isExist) {
			//代表的已经存在，我们就返回已经注册
			PrintWriter pw=resp.getWriter();
			Error rr=new ResponseResult(responseResult[4],responseCode[4]);
			String paramError=gson.toJson(rr);
			pw.print(paramError);
		}else {//不存在，进行注册
			user.setPicture(SystemSetting.defaultUserHead);
			boolean sucessful=userOpration.registerUser(user);
			if(!sucessful) {
				PrintWriter pw=resp.getWriter();//用户注册成功,
				Error rr=new ResponseResult(responseResult[5],responseCode[5]);
				String paramError=gson.toJson(rr);
				pw.print(paramError);
				return;
			}else {
				PrintWriter pw=resp.getWriter();//用户注册失败，请稍后再试
				Error rr=new ResponseResult(responseResult[6],responseCode[6]);
				String paramError=gson.toJson(rr);
				pw.print(paramError);
				return;
			}
		}
		
	}

	/**
	 * 处理用户的登录状态
	 * @param status
	 * @param req
	 * @param resp
	 * @param gson
	 * @throws IOException
	 */
	private void progressUserStatus(String status, HttpServletRequest req, HttpServletResponse resp, Gson gson) throws IOException {
		int statusInt;
		try {
			statusInt=Integer.parseInt(status);
		//System.out.println("用户的状态="+statusInt);
		}catch(Exception e) {
			e.printStackTrace();
			PrintWriter pw=resp.getWriter();
			Error rr=new ResponseResult(responseResult[1],responseCode[1]);
			String paramError=gson.toJson(rr);
			pw.print(paramError);
			return;
		}
		
		String userid=null;
		HttpSession httpSession=req.getSession();
		if(httpSession==null) {
			PrintWriter pw=resp.getWriter();
			Error rr=new ResponseResult(responseResult[3],responseCode[3]);
			String paramError=gson.toJson(rr);
			pw.print(paramError);
			return;
		}
		
		//代表的是我们登录了这个网站
		userid=(String) httpSession.getAttribute("userid");
		
		UserLoginStatus userLoginStatus;
		User user;
		UserOpration userOpration;
		if(userid!=null) {
		userOpration=UserDbController.getInstance();
		user=new User();
		user.setUserid(Integer.parseInt(userid));
			//代表了已经登录了这个网站
		user=userOpration.queryUserInfo(user);
		userLoginStatus=new UserLoginStatus(new ResponseResult(responseResult[0],responseCode[0]),user);
		String userLoginStatusJson=gson.toJson(userLoginStatus);
		PrintWriter pw=resp.getWriter();
		pw.print(userLoginStatusJson);
		return;
		}else {
			//没有登录
			userLoginStatus=new UserLoginStatus(new ResponseResult(responseResult[3],responseCode[3]),new User());
			String userLoginStatusJson=gson.toJson(userLoginStatus);
			PrintWriter pw=resp.getWriter();
			pw.print(userLoginStatusJson);
			return;
		}
	}


	private void progressUserValidate(String userid,String password,HttpServletRequest req,
			HttpServletResponse resp,Gson gson) throws IOException {
		int useridInt;
		try {
		useridInt=Integer.parseInt(userid);
		System.out.println("用户的id="+useridInt);
		}catch(Exception e) {
			e.printStackTrace();
			PrintWriter pw=resp.getWriter();
			Error rr=new ResponseResult(responseResult[1],responseCode[1]);
			String paramError=gson.toJson(rr);
			pw.print(paramError);
			return;
		}
		
		UserOpration uo=UserDbController.getInstance();

		boolean isexist=uo.validateLogin(new User(useridInt,password));
		if(isexist==false) {
			//不存在
			PrintWriter pw=resp.getWriter();
			Error rr=new ResponseResult(responseResult[2],responseCode[2]);
			String paramError=gson.toJson(rr);
			pw.print(paramError);
			return;
		}
			String remember=req.getParameter("remember");
			//存在，写入数据到cookie
			//用户名的cookie
			Cookie cookie=new Cookie("userid",userid);
			//设置cookie维持时间
			cookie.setMaxAge(SystemSetting.COOKIE_HOID);
			resp.addCookie(cookie);
			if("true".equals(remember)) {
				Cookie cookie2=new Cookie("password", password);
				resp.addCookie(cookie2);
			}
			
			//开始设置整个站点的session会话维持
			HttpSession httpSession=req.getSession();
			httpSession.setAttribute("userid", userid);
			
			PrintWriter pw=resp.getWriter();
			Error rr=new ResponseResult(responseResult[0],responseCode[0]);
			String paramError=gson.toJson(rr);
			pw.print(paramError);
			return;
	}


	/**
	 * 在这里用户获得用户的相关信息
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json;charset=utf-8");
		Gson gson=new Gson();
		String status=req.getParameter("status");
		String opration=req.getParameter("opration");
		String cancellation=req.getParameter("cancellation");
		if(status==null&&cancellation==null&&opration==null) {
			PrintWriter pw=resp.getWriter();
			Error rr=new ResponseResult(responseResult[1],responseCode[1]);
			String paramError=gson.toJson(rr);
			pw.print(paramError);
			return;
		}else {
			//处理用户登录的状态
			if(status!=null) {
				progressUserStatus(status,req,resp,gson);
				return;
			}
			//处理用户下线的功能
			if(cancellation!=null) {
				progressUserCancellation(cancellation,req,resp,gson);
				return;
			}
			
			if(opration!=null) {
				progressUserCenter(req,resp,gson,opration);
				return;
			}
			
		}
	}

			
	private void progressUserCenter(HttpServletRequest req, HttpServletResponse resp, Gson gson, String opration) {
	
		
	}
	/**
	 * 处理用户的下线的功能
	 * @param cancellation
	 * @param req
	 * @param resp
	 * @param gson
	 * @throws IOException 
	 */
	private void progressUserCancellation(String cancellation, HttpServletRequest req, HttpServletResponse resp,
			Gson gson) throws IOException {
		//下面执行的是下线的功能
			if("true".equals(cancellation)) {
				//代表执行的就是下线的功能，销毁当前的session
				HttpSession httpSession=req.getSession();
				httpSession.setAttribute("userid", "");
				httpSession.invalidate();
				PrintWriter pw=resp.getWriter();
				Error rr=new ResponseResult(responseResult[7],responseCode[7]);
				String paramError=gson.toJson(rr);
				pw.print(paramError);
				return;
			}else {
				//代表的是参数错误
				PrintWriter pw=resp.getWriter();
				Error rr=new ResponseResult(responseResult[1],responseCode[1]);
				String paramError=gson.toJson(rr);
				pw.print(paramError);
				return;
			}
			
	}

}
