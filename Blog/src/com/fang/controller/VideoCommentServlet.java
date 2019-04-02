package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fang.dbController.ArticleDbController;
import com.fang.dbController.ArticleOpration;
import com.fang.dbController.UserDbController;
import com.fang.dbController.UserOpration;
import com.fang.dbController.VideoCommentDbController;
import com.fang.dbController.VideoCommentOpration;
import com.fang.dbController.VideoOpration;
import com.fang.model.Article;
import com.fang.model.Error;
import com.fang.model.ResponseResult;
import com.fang.model.User;
import com.fang.model.VideoComment;
import com.fang.model.ReuniteModel.User_VideoComment;
import com.fang.setting.SystemSetting;
import com.fang.tool.DateTool;
import com.google.gson.Gson;

/***
 * 视频评论处理的servlet
 * @author fang
 *
 */

@WebServlet("/VideoCommentServlet")
public class VideoCommentServlet extends HttpServlet {
	
	
	
	/**
	 * 服务器返回结果码定义
	 */
	public static int[] responseCode= {1,2,3};
	public static String[] responseResult= {
			"响应成功","请求参数错误","用户未登录"
	};
	
     
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		Gson gson=new Gson();
		String videoCommentS=req.getParameter("videoComment");
		
		//代表的是查询最新几条数据
		if(videoCommentS!=null) {
			int countIn = 0;
			resp.setContentType("application/json;charset=utf-8");
			String videoAddressS=req.getParameter("videoAddress");
			VideoComment vc=new VideoComment();
			UserOpration uo;
			videoAddressS=videoAddressS.replace(' ', '+');
			vc.setVideoAddress(videoAddressS);
			VideoCommentOpration vco;
			try {
				countIn=Integer.parseInt(videoCommentS);
			} catch (Exception e) {
				PrintWriter pw=resp.getWriter();
				Error error=new Error("参数错误");
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
			}
			List<VideoComment> videoComments;
			vco=VideoCommentDbController.getInstance();
			uo=UserDbController.getInstance();
			List<User_VideoComment> user_VideoComments=new ArrayList<>();
			videoComments=(List<VideoComment>) vco.queryPageVideoComment(0, countIn, vc);
			for(VideoComment videoComment:videoComments) {
			  int userid=videoComment.getUserid();
			  User user=new User();
			  user.setUserid(userid);
			  user=uo.queryUserInfo(user);
			  user_VideoComments.add(new User_VideoComment(user, videoComment));
			}
			String jsonArticles=gson.toJson(user_VideoComments);
			PrintWriter pw=resp.getWriter();
			pw.print(jsonArticles);
		}
		
		if(videoCommentS==null) {
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
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json;charset=utf-8");
		Gson gson=new Gson();
		String videoAddressS=req.getParameter("videoAddress");
		String content=req.getParameter("content");
//		System.out.println(videoAddressS);
		
		if(videoAddressS==null||content==null) {
			PrintWriter pw=resp.getWriter();
			Error rr=new ResponseResult(responseResult[1],responseCode[1]);
			String paramError=gson.toJson(rr);
			pw.print(paramError);
			return;
		}
	
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
		VideoCommentOpration vco=VideoCommentDbController.getInstance();
		resp.setContentType("application/json;charset=utf-8");
		videoAddressS=videoAddressS.replace(" ", "+");
		System.out.println(new VideoComment(-1,useridInt, videoAddressS, content, commentTime));
		vco.addNowVideoCommnet(new VideoComment(-1,useridInt, videoAddressS, content, commentTime));
		PrintWriter pw=resp.getWriter();
		Error error=new ResponseResult(responseResult[0],responseCode[0]);
		String paramError=gson.toJson(error);
		pw.print(paramError);
		return;
		}
	
	
}
