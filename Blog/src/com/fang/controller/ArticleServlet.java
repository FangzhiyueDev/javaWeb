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
import javax.servlet.http.HttpSession;

import com.fang.dbController.ArticleCommentDbController;
import com.fang.dbController.ArticleCommentOpration;
import com.fang.dbController.ArticleDbController;
import com.fang.dbController.ArticleOpration;
import com.fang.dbController.ReadRecordDbController;
import com.fang.dbController.ReadRecordOpration;
import com.fang.dbController.UserDbController;
import com.fang.dbController.UserOpration;
import com.fang.dbController.VideoDbController;
import com.fang.dbController.VideoOpration;
import com.fang.model.Article;
import com.fang.model.Error;
import com.fang.model.ReadRecords;
import com.fang.model.User;
import com.fang.model.ReuniteModel.ArticleClass;
import com.fang.model.ReuniteModel.ArticleCorrespondReadCount;
import com.fang.model.ReuniteModel.ArticleUser;
import com.fang.tool.DateTool;
import com.google.gson.Gson;

@WebServlet("/ArticleServlet")
public class ArticleServlet  extends HttpServlet{
	
	/**
	 * 默认获取最新的十行数据
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		Gson gson=new Gson();
		String count=req.getParameter("current");
		String classfy=req.getParameter("classfy");
		String articlePublishTime=req.getParameter("articlePublishTime");
		String size=req.getParameter("size");
		String opration=req.getParameter("opration");
		//10.100.19.220
		//查询最新的文章列表
		if(count!=null) {
			
			int countIn = 0;
			resp.setContentType("application/json;charset=utf-8");
			try {
				countIn=Integer.parseInt(count);
			} catch (Exception e) {
				PrintWriter pw=resp.getWriter();
				Error error=new Error("参数错误");
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
			}
//			List<Article> articles;
			List<ArticleUser> articleUsers;
			ArticleOpration vo=ArticleDbController.getInstance();
//			articles=(List<Article>) vo.queryNowArticle(countIn);
//			String jsonArticles=gson.toJson(articles);
			articleUsers=(List<ArticleUser>) vo.queryNowArticleAndUserInfo(countIn);
			PrintWriter pw=resp.getWriter();
			String jsonArticleUsers=gson.toJson(articleUsers);
			pw.print(jsonArticleUsers);
			return;
		}
		if(classfy!=null) {
			int classfyIn = 0;
			resp.setContentType("application/json;charset=utf-8");
			try {
				classfyIn=Integer.parseInt(classfy);
			} catch (Exception e) {
				PrintWriter pw=resp.getWriter();
				Error error=new Error("参数错误");
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
			}
			List<ArticleClass> articleClasses;
			ArticleOpration vo=ArticleDbController.getInstance();
			articleClasses=(List<ArticleClass>) vo.queryArticleByClass();
			String jsonArticles=gson.toJson(articleClasses);
			PrintWriter pw=resp.getWriter();
			pw.print(jsonArticles);
			return;
		}
		
		
		//下面是翻页信息的获取，只要获得两条数据
		if(size!=null) {
			if(articlePublishTime==null) {
				PrintWriter pw=resp.getWriter();
				Error error=new Error("参数错误");
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
			}
			int sizeInt = 0;
			resp.setContentType("application/json;charset=utf-8");
			try {
				sizeInt=Integer.parseInt(size);
			} catch (Exception e) {
				PrintWriter pw=resp.getWriter();
				Error error=new Error("参数错误");
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
			}
			
			List<Article> articleBefores=null;
			ArticleOpration vo=ArticleDbController.getInstance();
			articleBefores=(List<Article>) vo.queryArticleByTimeBefore(articlePublishTime,sizeInt);
			List<Article> articleAfter=(List<Article>) vo.queryArticleByTimeAfter(articlePublishTime, sizeInt);
			List<List<Article>> articles=new ArrayList<>();
			articles.add(articleBefores);
			articles.add(articleAfter);
			PrintWriter pw=resp.getWriter();
			String dataJson=gson.toJson(articles);
			pw.print(dataJson);
			return;
		}
		
		if(opration!=null) {
			if("detail".equals(opration)&&articlePublishTime!=null) {
				//获得详细内容
				resp.setContentType("text/html;charset=utf-8");
				ArticleOpration ao=ArticleDbController.getInstance();
				Article article=new Article();
				article.setArticlePublishTime(articlePublishTime);
				article=ao.queryArticleDetailInfo(article);
				//修改文章的浏览量，以及查询文章的浏览量,也就是添加一条阅读记录
				ReadRecordOpration rro=ReadRecordDbController.getInstance();
				HttpSession session=req.getSession();
				String userid=(String) session.getAttribute("userid");
				if(userid!=null) {
					 int useridInt=Integer.parseInt(userid);
					 //添加一条阅读记录
					rro.addReadRecord(new ReadRecords(-1, useridInt, articlePublishTime));
				}
				//查询文章的阅读量
				int readCount=rro.getSpecifiedArticleReadCount(article);
				//查询文章的作者的相关信息
				UserOpration userOpration=UserDbController.getInstance();
				String userName=userOpration.queryUserInfo(articlePublishTime);
				
				//下面是添加对应的属性
				req.setAttribute("authorName", userName);
				req.setAttribute("count", readCount);
				req.setAttribute("time", DateTool.formatDataAndTime(articlePublishTime));
				req.setAttribute("article",article);
				req.getRequestDispatcher("jsp/jsp/articleRead.jsp").forward(req, resp);
				return;
			}else if("addReadRecords".equals(opration)&&articlePublishTime!=null){
				//var addReadRecord = "http://localhost:8080/Blog/ArticleServlet?articlePublishTime="+currentArticlePublishTime+"&opration=addReadRecords";
				//添加一条阅读记录，同时返回最新的阅读数量
				HttpSession httpSession=req.getSession();
				String userid=(String) httpSession.getAttribute("userid");
				ReadRecordOpration rro=ReadRecordDbController.getInstance();
				if(userid!=null) {
					int useridInt=Integer.parseInt(userid);
					ReadRecords rr=new ReadRecords(-1, useridInt, articlePublishTime);
					boolean isSusessful=rro.addReadRecord(rr);
					if(!isSusessful) {
						System.out.println("添加用户出错，请检测数据库是否正常");
					}
				}
				//返回最新的阅读记录
				Article article=new Article();
				article.setArticlePublishTime(articlePublishTime);
				int readCount=rro.getSpecifiedArticleReadCount(article);
				ArticleCorrespondReadCount acrc=new ArticleCorrespondReadCount(readCount);
				resp.setContentType("application/json;charset=utf-8");
				PrintWriter pw=resp.getWriter();
				String jsonData=gson.toJson(acrc);
				pw.print(jsonData);
				return;
			}else {
				PrintWriter pw=resp.getWriter();
				Error error=new Error("参数错误");
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
			}
		}
		
		if(count==null||classfy==null||articlePublishTime==null) {
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter pw=resp.getWriter();
			Error error=new Error("参数错误");
			String paramError=gson.toJson(error);
			pw.print(paramError);
			return;
		}
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
