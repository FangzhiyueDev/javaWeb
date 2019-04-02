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
import com.fang.rice.dbController.VipController;
import com.fang.rice.dbController.VipUserOpration;
import com.fang.rice.model.User;
import com.google.gson.Gson;
import com.xiaofangfang.rice.model.StatusResponseJson;

@WebServlet("/UserCenter")
public class UserCenter extends HttpServlet{
	
	
	/**
	 * 判断用户是否是vip或则已经访问过了
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		Gson gson=new Gson();
		String userId=req.getParameter("userId");
		//vip用户检测
		VipUserOpration vipO=new VipController();
		boolean isVip=vipO.isVIP(new User(userId));
		if(isVip) {
			PrintWriter printWriter=resp.getWriter();
			StatusResponseJson statusResponseJson=new StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL);
			String jsonData=gson.toJson(statusResponseJson);
			printWriter.print(jsonData);
			return;
		}else {
			UserOpration uo=new UserController();
			boolean status=uo.queryUserBrowserStatus(userId);
			if (status) {//已经浏览过了
				PrintWriter printWriter=resp.getWriter();
				StatusResponseJson statusResponseJson=new StatusResponseJson(StatusResponseJson.USER_HAS_BROWSER);
				String jsonData=gson.toJson(statusResponseJson);
				printWriter.print(jsonData);
				return;
		     }else {
		    	 boolean sucessful=uo.changeUserBrowserStatus(new User(userId));
					if(!sucessful) {
						System.out.println("修改用户的浏览状态失败");
					}
					PrintWriter printWriter=resp.getWriter();
					StatusResponseJson statusResponseJson=new StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL);
					String jsonData=gson.toJson(statusResponseJson);
					printWriter.print(jsonData);
					return;
		     }
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
}
