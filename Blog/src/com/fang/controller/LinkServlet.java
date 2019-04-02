package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.dbController.LinkDbController;
import com.fang.dbController.LinkOpration;
import com.fang.model.Error;
import com.fang.model.Link;
import com.google.gson.Gson;


/**
 * 
 * @author fang
 *
 */
@WebServlet("/LinkServlet")
public class LinkServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		Gson gson=new Gson();
		String link=req.getParameter("link");
		if(link==null){
			PrintWriter pw=resp.getWriter();
			Error error=new Error("参数错误");
			String paramError=gson.toJson(error);
			pw.print(paramError);
			return;
		}else {
			//处理获得链接
			progressLink(link,req,resp,gson);
		}
	
	}
	
	/**
	 * 用来获得链接数据
	 * @param link
	 * @param req
	 * @param resp
	 * @param gson
	 * @throws IOException 
	 */
	private void progressLink(String link, HttpServletRequest req, HttpServletResponse resp, Gson gson) throws IOException {
		//查询最新的文章列表
				if(link!=null) {
					int countIn = 0;
					resp.setContentType("application/json;charset=utf-8");
					try {
						countIn=Integer.parseInt(link);
					} catch (Exception e) {
						PrintWriter pw=resp.getWriter();
						Error error=new Error("参数错误");
						String paramError=gson.toJson(error);
						pw.print(paramError);
						return;
					}
					LinkOpration lo;
					List<Link> links=new ArrayList<>();
					lo=LinkDbController.GetInstance();
					links=(List<Link>) lo.getListBySize(countIn);
					String linksJson=gson.toJson(links);
					PrintWriter pw=resp.getWriter();
					pw.print(linksJson);
					return;
				}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}
	
		
}
