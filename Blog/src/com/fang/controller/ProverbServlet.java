package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.print.DocFlavor.STRING;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fang.dbController.DbGeneric;
import com.fang.dbController.DbGenericController;
import com.fang.dbController.ProverbDbController;
import com.fang.model.Error;
import com.fang.model.Proverb;
import com.fang.tool.DateTool;
import com.google.gson.Gson;

/**
 * 
 * @author fang
 *
 */

@WebServlet(
		urlPatterns= {
				"/ProverbServlet"
		}
		)
public class ProverbServlet extends HttpServlet {
	
	
	/**
	 * 
	 * 这个是我们对每日一言的处理
	 * getAllProverb=1  //代表的是执行的是获得所有的数据 这里的1是一个标志位
	 * size=?;//代表的是执行的是分页效果，？代表的是返回数据的大小
	 * current=？;//代表的是获得当前的最新数据？代表的是返回的数据的长度
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    
	   	    req.setCharacterEncoding("utf-8");
	   	    resp.setContentType("application/json;charset=utf-8");
	   	    resp.setHeader("Access-Control-Allow-Origin", "*");
	 	    Gson gson=new Gson();
	 	    PrintWriter pw=resp.getWriter();
	 	    String proverbs=req.getParameter("getAllProverb");
			String  current=req.getParameter("current");
			String size=req.getParameter("size");
			
		/**
		 * 获得的是所有的数据
		 */
		if("1".equals(proverbs)) {
			//执行获得所有的数据
			List<Proverb> priverbList=(List<Proverb>) ProverbDbController.getInstance().queryAllProverb();
			 String proverbJson=gson.toJson(priverbList);
	       	    pw.print(proverbJson);  
			return;
		}
		
	    if (size!=null) {
	        float rate;
	        ProverbDbController pdc=null;
	        DbGeneric dbGeneric;
	        int count;
	        int startPage;
	        int size1;
			try {
				rate=((float)DateTool.getCurrentDayByMonth())/DateTool.getCurrentMonthCount();
				pdc=(ProverbDbController) ProverbDbController.getInstance();
				dbGeneric=DbGenericController.getInstance();
				count=dbGeneric.getResultCount(ProverbDbController.PROVERB_TABLE);
				startPage=(int) (rate*count);
				size1=Integer.parseInt(size);
				List<Proverb> proverbs2;
               proverbs2= (List<Proverb>) pdc.queryProverb(startPage, size1);
               String proverbJson=gson.toJson(proverbs2);
               pw.print(proverbJson);  
			}catch(Exception e) {
				e.printStackTrace();
				//在这里返回错误信息，返回的数据是一个json数据
				Error error=new Error("参数错误");
				String paramError=gson.toJson(error);
				pw.print(paramError);
			}
		} 
	    
	    /**
	     * 代表获得的是最新的数据
	     */
	    if(current!=null) {
	    		int currentNumber;
	    		ProverbDbController pdc;
	    		List<Proverb> proverbs2;
	    		try {
	    			currentNumber=Integer.parseInt(current);
	    			pdc=(ProverbDbController) ProverbDbController.getInstance();
	    			proverbs2=(List<Proverb>) pdc.queryNowProverb(currentNumber);
	    			 String proverbJson=gson.toJson(proverbs2);
	                 pw.print(proverbJson);  

				} catch (Exception e) {
					e.printStackTrace();
					Error error=new Error("参数错误");
					String paramError=gson.toJson(error);
					pw.print(paramError);
				}finally {
					
				}
	    }
	    
	    
	    /**
	     * 代表的是没有传递参数
	     */
	    if(size==null&&proverbs==null&&current==null) {
	    	Error error=new Error("参数错误");
			String paramError=gson.toJson(error);
			pw.print(paramError);
	    }
	    
	}
	
	/**
	 *这里的操作我们是用来实现对每日一言数据的上传
	 *该操作的执行权限是管理员才能执行这个操作
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
	}

}
