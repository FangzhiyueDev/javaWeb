package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.dbController.LogDbController;
import com.fang.dbController.LogOpration;
import com.fang.model.Error;
import com.fang.model.Log;
import com.google.gson.Gson;

/**
 * Servlet implementation class LogcatServlet
 */
@WebServlet("/LogcatServlet")
public class LogcatServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		Gson gson=new Gson();
		String logcat=req.getParameter("logcat");
		if(logcat==null) {
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter pw=resp.getWriter();
			Error error=new Error("参数错误");
			String paramError=gson.toJson(error);
			pw.print(paramError);
			return;
		}else {
			//处理日志
			progressLogcat(req,resp,gson,logcat);
			
		}
	}

	/**
	 * 获得logcat的数据请求
	 * @param req
	 * @param resp
	 * @param gson
	 * @param logcat
	 * @throws IOException 
	 */
	private void progressLogcat(HttpServletRequest req, HttpServletResponse resp, Gson gson, String logcat) throws IOException {
		//查询最新的文章列表
					int size = 0;
					resp.setContentType("application/json;charset=utf-8");
					try {
						size=Integer.parseInt(logcat);
					} catch (Exception e) {
						PrintWriter pw=resp.getWriter();
						Error error=new Error("参数错误");
						String paramError=gson.toJson(error);
						pw.print(paramError);
						return;
					}
					//执行查询
					List<Log> logs;
					LogOpration lo=LogDbController.getInstance();
					logs=(List<Log>) lo.getLogcatBySize(4);
					String logsJson=gson.toJson(logs);
					PrintWriter pw=resp.getWriter();
					pw.print(logsJson);
					return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
