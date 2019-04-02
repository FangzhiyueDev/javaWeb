package com.fang.rice.controll;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.fang.rice.dbController.PhoneDbController;
import com.fang.rice.dbController.PhoneOpration;
import com.fang.rice.model.PhoneData;
import com.fang.rice.model.Setmeal;
import com.google.gson.Gson;
import com.xiaofangfang.rice.model.Phone;

/**
 * Servlet implementation class PhoneProductSalePageAction
 */
@WebServlet("/PhoneProductSalePageAction")
public class PhoneProductSalePageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("收到转发请求");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		Gson gson=new Gson();
		String sizeString=request.getParameter("size");
		int size;
		int page;
		boolean saleSortAsc;
		boolean priceSortAsc;
		String networkType;
		String cardType;
		int startPrice=-1;
		int endPrice=-1;
		String brand;
		if(sizeString!=null) {
		//这个的作用是用来请求具体的phone数据的
		 size=Integer.parseInt(sizeString);
		 page=Integer.parseInt(request.getParameter("page"));
		 saleSortAsc=new Boolean(request.getParameter("saleSortAsc"));
		 priceSortAsc=new Boolean(request.getParameter("priceSortAsc"));
		//下面是可选的，也就是不一定拥有的参数
		 networkType=request.getParameter("网络类型");//全网通 移动 联通  电信
		 cardType=request.getParameter("卡类型");// 双卡  单卡 
		 brand=request.getParameter("品牌");
			//加载手机的数据集合
			if(request.getParameter("startPrice")!=null) {
				 startPrice=Integer.parseInt(request.getParameter("startPrice"));	
			}
			if(request.getParameter("endPrice")!=null) {
				 endPrice=Integer.parseInt(request.getParameter("endPrice"));
			}
		
			PhoneFilterCondition pfc=new PhoneFilterCondition(size, page, priceSortAsc, saleSortAsc, networkType,brand,
					cardType, startPrice, endPrice);
			getPhoneList(request,response,gson,pfc);
			return;
		}
		
		String phoneBrandType=request.getParameter("BrandType");
		if(phoneBrandType!=null) {
			//代表加载的是手机的品牌类型
			getPhoneBrandType(request,response,gson);
			return;
		}
		
		String phoneIdStr=request.getParameter("phoneId");
		if(phoneIdStr!=null) {
			int phoneId=Integer.parseInt(phoneIdStr);
			getPhoneDetailInfo(request,response,gson,phoneId);
			return;
		}
		
		
	}
	
	
	/**
	 * 获得手机的详细信息的显示
	 * @param request
	 * @param response
	 * @param gson
	 * @param phoneId
	 * @throws IOException 
	 */
	private void getPhoneDetailInfo(HttpServletRequest request, HttpServletResponse response, Gson gson, int phoneId) throws IOException {
	
		PhoneOpration phoneOpration=new PhoneDbController();
		PhoneData phoneData=phoneOpration.getPhoneDetailInfo(phoneId);
		//查询手机套餐  手机颜色分类 手机存储容量
		List<String> colorClassfy=phoneOpration.getPhoneColor(phoneId);
		List<String> strangs=phoneOpration.getStrangCapacity(phoneId);
		List<String> setmeals=phoneOpration.getSetmeal(phoneId);
		phoneData.setColors(colorClassfy);
		phoneData.setSetmeals(setmeals);
		phoneData.setStrangCapacity(strangs);
		
	    String jsonData=gson.toJson(phoneData);
		PrintWriter pw=response.getWriter();
		pw.print(jsonData);
		return;
	}



	/**
	 * 获得手机的类型
	 * @param gson 
	 * @param response 
	 * @param request 
	 * @throws IOException 
	 */
	private void getPhoneBrandType(HttpServletRequest request, HttpServletResponse response, Gson gson) throws IOException {
		PhoneOpration phoneOpration=new PhoneDbController();
		List<String> strings=phoneOpration.getPhoneBrandType();
		String gsonData=gson.toJson(strings);
	       PrintWriter pw=response.getWriter();
	       pw.println(gsonData);
	       return;
	}



	public void getPhoneList(HttpServletRequest request, HttpServletResponse response, Gson gson,PhoneFilterCondition pfc) throws IOException {
	
		
		//调用底层实现查询数据
		PhoneOpration phoneOpration=new PhoneDbController();
		List<Phone> phoneList=phoneOpration.getPhone(pfc);
		String gsonData=gson.toJson(phoneList);
       PrintWriter pw=response.getWriter();
       pw.println(gsonData);
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	
	
	/**
	 * 
	 * @author fang
	 *手机过滤的条件的封装
	 */
	public static class PhoneFilterCondition{
		private int size;
		private int page;
		private boolean priceSortAsc;
		private boolean saleSortAsc;
		private String networkType;
		private String brand;
		private String cardType;
		private int startPrice;
		private int endPrice;
		public PhoneFilterCondition(int size, int page, boolean priceSortAsc, boolean saleSortAsc, String networkType,
				String brand,String cardType, int startPrice, int endPrice) {
			this.size = size;
			this.page = page;
			this.priceSortAsc = priceSortAsc;
			this.saleSortAsc = saleSortAsc;
			this.networkType = networkType;
			this.brand=brand;
			this.cardType = cardType;
			this.startPrice = startPrice;
			this.endPrice = endPrice;
		}
	
		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}



		public PhoneFilterCondition() {
		
		}
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
		public boolean isPriceSortAsc() {
			return priceSortAsc;
		}
		public void setPriceSortAsc(boolean priceSortAsc) {
			this.priceSortAsc = priceSortAsc;
		}
		public boolean isSaleSortAsc() {
			return saleSortAsc;
		}
		public void setSaleSortAsc(boolean saleSortAsc) {
			this.saleSortAsc = saleSortAsc;
		}
		public String getNetworkType() {
			return networkType;
		}
		public void setNetworkType(String networkType) {
			this.networkType = networkType;
		}
		public String getCardType() {
			return cardType;
		}
		public void setCardType(String cardType) {
			this.cardType = cardType;
		}
		public int getStartPrice() {
			return startPrice;
		}
		public void setStartPrice(int startPrice) {
			this.startPrice = startPrice;
		}
		public int getEndPrice() {
			return endPrice;
		}
		public void setEndPrice(int endPrice) {
			this.endPrice = endPrice;
		}
		
		
		
		
	}
	

}
