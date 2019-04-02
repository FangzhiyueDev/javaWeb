package com.fang.rice.controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.rice.dbController.BillDbController;
import com.fang.rice.model.Bill;
import com.google.gson.Gson;


@WebServlet("/SubmitBill")
public class SubmitBill extends HttpServlet {
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			req.setCharacterEncoding("utf-8");
	    	resp.setContentType("application/json;charset=utf-8");
	    	
	    	System.out.print("接收到订单请求");
	    	
	    	String tel=req.getParameter("tel");
	    	String name=req.getParameter("name");
	    	String address=req.getParameter("address");
	    	String cardId=req.getParameter("cardId");
	    	
	    	Date date1=new Date();
	    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    	String date=sdf.format(date1);
	    	BillDbController billDbController=new BillDbController();
	    	
	    	boolean isSuccessful=billDbController.saveBill(new Bill(-1, tel, name, address, Integer.parseInt(cardId), date, false));
	    	
	    	String backDataString;
	    	if(isSuccessful) {
	    		backDataString="提交成功";
	    	}else {
	    		backDataString="提交失败";
			}
	    Gson gson=new  Gson();	
    	String jsonString=gson.toJson(backDataString);
    	PrintWriter pw=resp.getWriter();
    	pw.println(jsonString);
	    	
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		}
		
		
}
