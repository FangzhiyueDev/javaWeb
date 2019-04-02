package com.fang.rice.controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.rice.dbController.SecondHandPhoneDbController;
import com.fang.rice.dbController.SecondHandPhoneOpration;
import com.fang.rice.model.SecondHandPhone;
import com.google.gson.Gson;



@WebServlet("/HandPhoneProductSalePageAction")
public class HandPhoneProductSalePageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * cityId=147&priceSortAsc=true&tableName=secondHandPhone&page=0&size=10
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		Gson gson=new Gson();
		String sizeString=request.getParameter("size");
		String pageString=request.getParameter("page");
		String priceSortAscString=request.getParameter("priceSortAsc");
		String cityIdString=request.getParameter("cityId");
		if(sizeString!=null) {
			
			int size=Integer.parseInt(sizeString);
			boolean priceSortAsc=new Boolean(priceSortAscString);
			int cityId=Integer.parseInt(cityIdString);
			int page=Integer.parseInt(pageString);
		   HandPhoneFilterCondition handPhoneFilterCondition=new HandPhoneFilterCondition(size, page, cityId, priceSortAsc);
			getPhoneListData(request,response,gson,handPhoneFilterCondition);
			return;
		}
		
		
		//加载手机的详细信息
		String secondHandPhoneIdStr=request.getParameter("handPhoneId");
		if(secondHandPhoneIdStr!=null) {
			getHandPhoneDetailInfo(request,response,gson,secondHandPhoneIdStr);
		}
		
	}
	
	
	
	public void getHandPhoneDetailInfo(HttpServletRequest request,HttpServletResponse response,Gson gson,String handPhoneIdStr) throws IOException {
		
		SecondHandPhoneOpration shpo=new SecondHandPhoneDbController();
		int handPhoneId=Integer.parseInt(handPhoneIdStr);
		SecondHandPhone secondHandPhone=shpo.getHandPhoneDetailForId(handPhoneId);
		  String jsonData=gson.toJson(secondHandPhone);
		  PrintWriter pw=response.getWriter();
		  pw.print(jsonData);
		  return;	
	}
	
	
	
	
	

    /**
     * 获得手机的相关信息
     * @param request
     * @param response
     * @param gson
     * @param handPhoneFilterCondition
     * @throws IOException 
     */
	private void getPhoneListData(HttpServletRequest request, HttpServletResponse response, Gson gson,
			HandPhoneFilterCondition handPhoneFilterCondition) throws IOException {
	     
		SecondHandPhoneOpration shpo=new SecondHandPhoneDbController();
		  List<SecondHandPhone> secondHandPhones=shpo.getHandPhoneList(handPhoneFilterCondition);
		  
		  String jsonData=gson.toJson(secondHandPhones);
		  PrintWriter pw=response.getWriter();
		  pw.print(jsonData);
		  return;	
	}







	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	public static class HandPhoneFilterCondition{
		
		private int size;
		private int page;
		private int cityId;
		
		public HandPhoneFilterCondition() {
		
		}
		
		public HandPhoneFilterCondition(int size, int page, int cityId, boolean priceSortAsc) {
			super();
			this.size = size;
			this.page = page;
			this.cityId = cityId;
			this.priceSortAsc = priceSortAsc;
		}

		//价格降序
		private boolean priceSortAsc;
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			this.page = page;
		}
		public int getCityId() {
			return cityId;
		}
		public void setCityId(int cityId) {
			this.cityId = cityId;
		}
		public boolean isPriceSortAsc() {
			return priceSortAsc;
		}
		public void setPriceSortAsc(boolean priceSortAsc) {
			this.priceSortAsc = priceSortAsc;
		}
		
		
		
		
	}
	

}
