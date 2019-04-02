package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fang.dbController.ArticleCommentDbController;
import com.fang.dbController.ArticleCommentOpration;
import com.fang.dbController.LeaveMessageDbController;
import com.fang.dbController.LeaveMessageOpration;
import com.fang.model.ArticleComment;
import com.fang.model.Error;
import com.fang.model.LeaveMessage;
import com.fang.model.ResponseResult;
import com.fang.model.ReuniteModel.LeaveMessageUser;
import com.fang.tool.DateTool;
import com.google.gson.Gson;

/**
 * 留言信息的查询
 * @author fang
 *
 */
@WebServlet("/LeaveMessageServlet")
public class LeaveMessageServlet extends HttpServlet {
	
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
		Gson gson=new Gson();
		String count=req.getParameter("message");
		if(count==null) {
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter pw=resp.getWriter();
			Error error=new Error("参数错误");
			String paramError=gson.toJson(error);
			pw.print(paramError);
			return;
		}else {
			progressLeaveMessage(req,resp,gson,count);
		}
	}
	
	/**
	 * 处理留言信息
	 * @param req
	 * @param resp
	 * @param gson
	 * @param count
	 * @throws IOException 
	 */
	private void progressLeaveMessage(HttpServletRequest req, HttpServletResponse resp, Gson gson, String count) throws IOException {
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
			LeaveMessageOpration lmo=LeaveMessageDbController.getInstance();
			List<LeaveMessageUser> leaveMessageUsers= 
					(List<LeaveMessageUser>) lmo.getLeaveMessageUserBySize(countIn);
			String leaveMessageJson=gson.toJson(leaveMessageUsers);
			PrintWriter pWriter=resp.getWriter();
			pWriter.println(leaveMessageJson);
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		Gson gson=new Gson();
		String content=req.getParameter("content");
		//处理新的留言信息
		if(content!=null) {
			progressNewLeaveMessage(gson,req,resp,content);
		}
	}
		/**
		 * 
		 * @param gson
		 * @param req
		 * @param resp
		 * @param content
		 * @throws IOException 
		 */
	private void progressNewLeaveMessage(Gson gson, HttpServletRequest req, HttpServletResponse resp, String content) throws IOException {
		HttpSession session=req.getSession();
		resp.setContentType("application/json;charset=utf-8");
		String userid = null;
		String commentTime;
		 if(session==null) {
	        	PrintWriter pw=resp.getWriter();
				Error error=new ResponseResult(responseResult[2],responseCode[2]);
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
	        }
		userid=(String) session.getAttribute("userid");
		if(userid==null) {//代表没有登录
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
		LeaveMessageOpration lmo=LeaveMessageDbController.getInstance();
		boolean isSucessful=lmo.addLeaveMessage(new LeaveMessage(useridInt, 0, commentTime, content));
		if(!isSucessful) {
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
