package com.fang.rice.controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.interfaces.RSAKey;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ietf.jgss.Oid;
import org.omg.CORBA.portable.ValueBase;

import com.fang.rice.controll.ProductSalePageAction.ViewMap;
import com.fang.rice.dbController.CardDbController;
import com.fang.rice.dbController.CardOpration;
import com.fang.rice.dbController.LocationDbController;
import com.fang.rice.model.*;
import com.fang.rice.model.Province;
import com.fang.rice.server.DataBackAnalysis;
import com.fang.rice.tool.CardConsumptionAnalysisTool;
import com.google.gson.Gson;

/**
 * Servlet implementation class CardProductSalePageAction
 */
@WebServlet("/CardProductSalePageAction")
public class CardProductSalePageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	public static void main(String[] argc) {
		String value="100";
		String value1="100分钟-199分钟";
		boolean value3=isNumber(value);
	   System.out.println(value3);
	}
	

	public  int callTimeS=0;
	public  int flowCountS=0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		Gson gson=new Gson();
		
		String classe=request.getParameter("class");
		if(classe.equalsIgnoreCase(ViewMap.MAIN_FRAGMENT.name)) {
			String cityId=request.getParameter("city");
			progressNowCardData(cityId,request,response);
			return;
		}
		
		
		
		String sizeString=request.getParameter("size");
		int size;
		int cityId=Integer.parseInt(request.getParameter("cityId"));
		int page;
		boolean priceSortAsc;
		String setmealType;
		String flowCount;
		String callTime;
		int startPrice=-1;
		int endPrice=-1;
		String msCount;
		
       //为了解决我们在进行路来个筛选的过程中查找不到数据，所以定义了一个
		if(sizeString!=null) {
			size=Integer.parseInt(sizeString);
			 page=Integer.parseInt(request.getParameter("page"));
			 priceSortAsc=new Boolean(request.getParameter("priceSortAsc"));
			 
			 setmealType=request.getParameter("套餐类型");
			 flowCount=request.getParameter("上网流量");
			 callTime=request.getParameter("通话时长");
			 msCount=request.getParameter("短信");
			 
			 
				if(request.getParameter("startPrice")!=null) {
					 startPrice=Integer.parseInt(request.getParameter("startPrice"));	
				}
				if(request.getParameter("endPrice")!=null) {
					 endPrice=Integer.parseInt(request.getParameter("endPrice"));
				}
				int[] callTimeBrak = null;
				int[] flowCountBrak = null;
				if(callTime!=null) {
				if(isNumber(callTime)) {//如果输入的是一个确定的话，我们应该执行的操作是对套餐表里面的数据进行遍历，然后根据计算公式来实现对套餐的推送
						
					callTimeS=Integer.parseInt(callTime);
					
					//callTimeBrak=DataBackAnalysis.callTimeRange(Integer.parseInt(callTime));
				}else {
					//这里判断上限
					  callTimeBrak=getNumberIntForString(callTime,"以上");
				}
				//System.out.println("通话时长="+callTimeBrak[0]+"-"+callTimeBrak[1]);
				}
				
			    if(flowCount!=null) {
			    	if(isNumber(flowCount)) {
			    		
			    		flowCountS=Integer.parseInt(flowCount);
						//flowCountBrak=DataBackAnalysis.flowTimeRange(Integer.parseInt(flowCount));
					}else {
						 flowCountBrak=getNumberIntForString(flowCount,"以上");
					}
			    	//System.out.println("流量="+flowCountBrak[0]+"-"+flowCountBrak[1]);
			    }
		
	
				CardFilterCondition cardFilterCondition=new CardFilterCondition(size, page, cityId, priceSortAsc, setmealType, 
						flowCountBrak, callTimeBrak, startPrice, endPrice);
				int msCountI=0;
				if(msCount!=null) {
					msCountI=Integer.parseInt(msCount);
				}
				getCardDataList(request,response,gson,cardFilterCondition,msCountI);
						return;
		}
		
		String BrandType=request.getParameter("BrandType");
		if(BrandType!=null) {
			//代表加载的是手机的品牌类型
			getCardBrandType(request,response,gson,cityId);
			return;
		}
		
		String cardId=request.getParameter("cardId");
		if(cardId!=null) {
			getCardDetailInfo(request,response,gson,cardId);
			return;
		}
	}
	
	
	
	private void progressNowCardData(String cityId, HttpServletRequest request, HttpServletResponse response) {
		
		CardOpration cardOpration=new CardDbController();
		List<Card> cards=cardOpration.getCardList3(cityId);
		Gson gson=new  Gson();
		String valueString=gson.toJson(cards);
		try {
			response.getWriter().println(valueString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
		
	}



	/**
	 * 获得某张card的详细信息
	 * @param request
	 * @param response
	 * @param gson
	 * @param cardId
	 * @throws IOException 
	 */
	private void getCardDetailInfo(HttpServletRequest request, HttpServletResponse response, Gson gson, String cardId) throws IOException {
			CardOpration cardOpration=new CardDbController();
			Card card=cardOpration.getCardDetailInfo(Integer.parseInt(cardId));
			String jsonData=gson.toJson(card);
			PrintWriter pw=response.getWriter();
			pw.println(jsonData);
	}




	private static  boolean isNumber(String value) {
		char[] values=value.toCharArray();
		for(int i=0;i<values.length;i++) {
			if(values[i]<'0'||values[i]>'9') {
				return false;
			}
		}
		return true;
		
	}
	

	/**
	 * 获得的是card的数据的集合类型
	 * @param request
	 * @param response
	 * @param gson
	 * @param cardFilterCondition
	 * @throws IOException 
	 */
	private void getCardDataList(HttpServletRequest request, HttpServletResponse response, Gson gson,
			CardFilterCondition cardFilterCondition,int msCount) throws IOException {
	CardOpration cardOpration=new CardDbController();
	List<Card> cards=cardOpration.getCardList(cardFilterCondition);
	
	System.out.println(cardFilterCondition.getCallTime());
	//现在对数据进行二次排序
	if(callTimeS!=0) {
		//代表执行的是定制化的需求
			cards=CardConsumptionAnalysisTool.getCheapSetmeal(cards,callTimeS,flowCountS,msCount);	
	}
	String jsonData=gson.toJson(cards);
	PrintWriter pw=response.getWriter();
	pw.print(jsonData);
	return;
	}



/**
 * 获得的是card的套餐类型
 * @param request
 * @param response
 * @param gson
 * @param cityId 
 * @throws IOException 
 */
	private void getCardBrandType(HttpServletRequest request, HttpServletResponse response, Gson gson, int cityId) throws IOException {
		
		CardOpration cardOpration=new CardDbController();
		//通过市的id查找省的id获得套餐分类
		LocationDbController locationDbController=new LocationDbController();
		Province province=locationDbController.getProvinceForCityId(cityId);	
		List<String> classfyList=cardOpration.queryCardClassfyForList(province.getProvinceId());
		String jsonData=gson.toJson(classfyList);
		PrintWriter pw=response.getWriter();
		pw.print(jsonData);
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	/**
	 * 卡的条件的筛选
	 * @author fang
	 * int size;
		int page;
		boolean saleSortAsc;
		boolean priceSortAsc;
		String setmealType;
		String flowCount;
		String callTime;
		int startPrice=-1;
		int endPrice=-1;
	 *
	 */
	public static class CardFilterCondition{
		private int size;
		private int page;
		private int cityId;
		private boolean priceSortAsc;
		private String setmealType;
		private int[]  flowCount;
		private int[] callTime;
		private int startPrice;
		private int endPrice;
		
		public CardFilterCondition() {
			// TODO Auto-generated constructor stub
		}
		
		
		
		public CardFilterCondition(int size, int page, int cityId, boolean priceSortAsc, String setmealType,
				int[] flowCount, int[] callTime, int startPrice, int endPrice) {
			super();
			this.size = size;
			this.page = page;
			this.cityId = cityId;
			this.priceSortAsc = priceSortAsc;
			this.setmealType = setmealType;
			this.flowCount = flowCount;
			this.callTime = callTime;
			this.startPrice = startPrice;
			this.endPrice = endPrice;
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
		public String getSetmealType() {
			return setmealType;
		}
		public void setSetmealType(String setmealType) {
			this.setmealType = setmealType;
		}
		public int[] getFlowCount() {
			return flowCount;
		}
		public void setFlowCount(int[] flowCount) {
			this.flowCount = flowCount;
		}
		public int[] getCallTime() {
			return callTime;
		}
		public void setCallTime(int[] callTime) {
			this.callTime = callTime;
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
	
	
	
	private static int[] getNumberIntForString(String value,String key) {
		String[] rank=value.split("-");
		String numberString = "";
		int[]rankNumber=new int[2];
		if(rank.length==1) {
			char[] charArray=rank[0].toCharArray();
			 numberString= getNumberForString(charArray);
			 if(value.contains(key)) {//上
				 rankNumber[0]=Integer.parseInt(numberString);
				 rankNumber[1]=0;
			 }else {
			 rankNumber[0]=0;
			 rankNumber[1]=Integer.parseInt(numberString);
			 }
		}else {
			char[] charArray=rank[0].toCharArray();
			char[] charArray1=rank[1].toCharArray();
			rankNumber[0]=Integer.parseInt(getNumberForString(charArray));
			rankNumber[1]=Integer.parseInt(getNumberForString(charArray1));
		}	
		return rankNumber;
	}
	
	
	
	private static String getNumberForString(char[] charArray) {
		String numberString="";
		for(int i=0;i<charArray.length;i++) {
			if(charArray[i]>='0'&&charArray[i]<='9') {
				numberString+=charArray[i];
			}
		}
		return numberString;
	}
	
	
	

}
