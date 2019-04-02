package com.fang.rice.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.rice.dbController.FeedBackDbController;
import com.fang.rice.model.FeedBack;
import com.google.gson.Gson;
import com.mysql.jdbc.StringUtils;

/**
 * 处理的是建议的反馈
 *
 * @author fang
 */

@WebServlet("/AddvanceBack")
public class AddvanceBackServlet extends HttpServlet {
	
	
	private  	FeedBackDbController feedBackDbController;
	
	@Override
		public void init() throws ServletException {
		
		feedBackDbController=new FeedBackDbController();
		
		}
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	req.setCharacterEncoding("utf-8");
    	resp.setContentType("application/json;charset=utf-8");
    	
    	String user=req.getParameter("user");
    	String content=req.getParameter("content");
    
    	String backDataString;
    	
    	Gson gson=new  Gson();
    	
    	
    	if(feedBackDbController.insert(new FeedBack(user, content))) {
    		backDataString="提交成功";

    	}else {
			backDataString="提交失败";
		}
    	String jsonString=gson.toJson(backDataString);;	
    	PrintWriter pw=resp.getWriter();
    	pw.println(jsonString);
    
    }

}
