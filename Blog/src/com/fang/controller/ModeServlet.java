package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.fang.model.Error;
import com.fang.model.ModeBean;
import com.fang.model.ResponseResult;
import com.google.gson.Gson;


/**
 * 系统后台模块管理的处理类，用来实现动态的包含后台的模块数据
 * @author fang
 *
 */

@WebServlet("/ModeServlet")
public class ModeServlet extends HttpServlet {

	public static List<ModeBean> modeBeans;

	   @Override
		public void init() throws ServletException {
		   super.init();
		   	modeBeans=new ArrayList<>();
		   	List<String> function=new ArrayList<>();
		   	List<String> importUrl=new ArrayList<>();
		   	
		   	function.add("文章管理");
		   	function.add("发布新文章");
		   	importUrl.add("articleManagerBody.html");
		   	importUrl.add("publishNewArticle.html");
//		   	modeBeans.add(new ModeBean("文章管理", function),importUrl);
		   	function.clear();
		   	
		   	function.add("友链管理");
		   	function.add("添加友链");
//		   	modeBeans.add(new ModeBean("友链管理",function));
		   	function.clear();
		   	
		   	function.add("图片管理");
		   	function.add("添加图片");
//		   	modeBeans.add(new ModeBean("图片管理",function));
		   	function.clear();
		   	
		   	function.add("一言管理");
		   	function.add("添加一言");
//		   	modeBeans.add(new ModeBean("一言管理",function));
		   	function.clear();
		   	
		   	function.add("视频管理");
		   	function.add("添加视频");
//		   	modeBeans.add(new ModeBean("视频管理",function));
		   	function.clear();
		}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		Gson gson=new Gson();
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json;charset=utf-8");
		String mode=req.getParameter("modeName");
		System.out.println("按时发嘎嘎"+mode);
		if(mode==null) {
			PrintWriter pw=resp.getWriter();
			Error error=new Error("参数错误");
			String paramError=gson.toJson(error);
			pw.print(paramError);
			return;
		}
		if(mode!=null) {
			progressMode(gson,req,resp,mode);
		}
		
		
	}
	
	/**
	 * 处理后台模块数剧
	 * @param gson
	 * @param req
	 * @param resp
	 * @param mode
	 * @throws IOException 
	 */
	private void progressMode(Gson gson, HttpServletRequest req, HttpServletResponse resp, String mode) throws IOException {
		ModeBean modeBean = null;
		for(int i=0;i<modeBeans.size();i++) {
			if(mode.equals(modeBeans.get(i).getModeName())) {
			    modeBean=modeBeans.get(i);
			}
		}
		if(modeBean==null) {
			PrintWriter pw=resp.getWriter();
			Error error=new Error("参数错误");
			String paramError=gson.toJson(error);
			pw.print(paramError);
			return;
		}
		//成功匹配的时候，我们将数据存放到session中
		HttpSession httpSession=req.getSession();
		httpSession.setAttribute("mode", modeBean);
		PrintWriter pw=resp.getWriter();
		Error error=new ResponseResult("响应成功",1);
		String paramError=gson.toJson(error);
		pw.print(paramError);
		return;
	}
}
