package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.model.DayNote;
import com.fang.dbController.DayNoteDbController;
import com.fang.dbController.DayNoteOpration;
import com.fang.model.Error;
import com.google.gson.Gson;


@WebServlet("/DayNoteServlet")
public class DayNoteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		Gson gson=new Gson();
		String count=req.getParameter("current");
		if (count==null) {
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter pw=resp.getWriter();
			Error error=new Error("参数错误");
			String paramError=gson.toJson(error);
			pw.print(paramError);
			return;
		}
			
			//代表执行的是获得最新的数据
		if(count!=null) {
			int sizeInt = 0;
			resp.setContentType("application/json;charset=utf-8");
			try {
				sizeInt=Integer.parseInt(count);
			} catch (Exception e) {
				PrintWriter pw=resp.getWriter();
				Error error=new Error("参数错误");
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
			}
			DayNoteOpration dno=DayNoteDbController.getInstance();
			List<DayNote> dayNotes=dno.getDayNoteBySize(-1);
			String gsonData=gson.toJson(dayNotes);
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter pw=resp.getWriter();
			pw.print(gsonData);
			return;
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
	
	
	
	
}
