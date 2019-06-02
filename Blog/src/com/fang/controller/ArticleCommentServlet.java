package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookiePolicy;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fang.dbController.ArticleCommentDbController;
import com.fang.dbController.ArticleCommentOpration;
import com.fang.dbController.VideoCommentDbController;
import com.fang.dbController.VideoCommentOpration;
import com.fang.model.ArticleComment;
import com.fang.model.Error;
import com.fang.model.ResponseResult;
import com.fang.model.VideoComment;
import com.fang.model.ReuniteModel.UserCommentArticle;
import com.fang.setting.SystemSetting;
import com.fang.tool.DateTool;
import com.google.gson.Gson;

@WebServlet("/ArticleCommentServlet")
public class ArticleCommentServlet extends HttpServlet {
	
	
	/**
	 * 服务器返回结果码定义
	 */
	public static int[] responseCode= {1,2,3,4};
	public static String[] responseResult= {
			"响应成功","请求参数错误","用户未登录","服务器内部出错，请稍后再试"
	};
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json;charset=utf-8");
		Gson gson=new Gson();
		String time=req.getParameter("articlePublishTime");
		String size=req.getParameter("size");
		if(time==null||size==null) {
			PrintWriter pw=resp.getWriter();
			Error error=new Error("参数错误");
			String paramError=gson.toJson(error);
			pw.print(paramError);
			return;
		}else {
			//请求
			if(size!=null) {
				progressArticleComment(resp,req,gson,time,size);
			}
		}
	}
	
	/**
	 * 处理文章的评论相关的信息
	 * @param resp
	 * @param req
	 * @param gson
	 * @param time
	 * @throws IOException 
	 */
  private void progressArticleComment(HttpServletResponse resp, HttpServletRequest req, Gson gson, String time,String size) throws IOException {
	  if(time!=null) {
			int publishTime = 0;
			int sizeInt=0;
			resp.setContentType("application/json;charset=utf-8");
			try {
//				publishTime=Integer.parseInt(time);
				sizeInt=Integer.parseInt(size);
			} catch (Exception e) {
				PrintWriter pw=resp.getWriter();
				Error error=new Error("参数错误");
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
			}
			
			  ArticleCommentOpration aco=ArticleCommentDbController.getInstance();
			  ArticleComment ac=new ArticleComment();
			  ac.setArticlePublishTime(time);
			  List<UserCommentArticle> ucas=(List<UserCommentArticle>) aco.queryNowComment(sizeInt,ac);
			  String userCommentListJson=gson.toJson(ucas);
			  PrintWriter pWriter=resp.getWriter();
			  pWriter.print(userCommentListJson);
	    }
	}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
 	resp.setHeader("Access-Control-Allow-Origin", "*");
 	resp.setContentType("application/json;charset=utf-8");
	Gson gson=new Gson();
	String time=req.getParameter("articlePublishTime");
	String content=req.getParameter("content");
	if(time==null||content==null) {
		PrintWriter pw=resp.getWriter();
		Error error=new Error("参数错误");
		String paramError=gson.toJson(error);
		pw.print(paramError);
		return;
	}else {
		progressCommentSubmit(req,resp,gson,time,content);
	}
	
}

private void progressCommentSubmit(HttpServletRequest req, HttpServletResponse resp, Gson gson, String time,
		String content) throws IOException {
	
	//检测用户是否已经登录，没有的话，就去登录
	//下面是进行cookie的判断
			HttpSession httpSession=req.getSession();
			String userid = null;
			String commentTime;
	        if(httpSession==null) {
	        	PrintWriter pw=resp.getWriter();
				Error error=new ResponseResult(responseResult[2],responseCode[2]);
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
	        }
	        
	      //代表的是我们登录了这个网站
	       userid=(String) httpSession.getAttribute("userid");
	       
			if(userid==null) {
				//代表的是没有登录，直接跳转到登录界面
				PrintWriter pw=resp.getWriter();
				Error error=new ResponseResult(responseResult[2],responseCode[2]);
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
			}
			int useridInt=Integer.parseInt(userid);
			//下面是已经登录的处理流程
			commentTime=DateTool.getCurrentDateAndTime();
			ArticleCommentOpration aco=ArticleCommentDbController.getInstance();
			resp.setContentType("application/json;charset=utf-8");
			int index=aco.addArticleComment(new ArticleComment(useridInt, content, -1, time, commentTime));
			if(index==-1) {
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
}
