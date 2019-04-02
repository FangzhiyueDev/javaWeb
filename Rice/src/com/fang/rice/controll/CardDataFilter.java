package com.fang.rice.controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fang.rice.dbController.CardDbController;
import com.fang.rice.dbController.CardOpration;
import com.fang.rice.model.Card;
import com.fang.rice.model.CardResponse;
import com.fang.rice.model.FilterCondition;
import com.fang.rice.model.FilterType;
import com.fang.rice.server.DataBackAnalysis;
import com.google.gson.Gson;
import com.xiaofangfang.rice.model.StatusResponseJson;


/**
 * 对卡数据的过滤中心,通过该类实现对卡数据过滤的功能
 * @author fang
 *
 */
@WebServlet("/CardDataFilter")
public class CardDataFilter extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		String callTimeCount=req.getParameter("callTimeCount");
		String flowTimeCount=req.getParameter("flowTimeCount");
		String userId=req.getParameter("userId");
		String cityId=req.getParameter("cityId");
		String sortMessageCount=req.getParameter("sortMessageCount");
		String saleSortOrder=req.getParameter("saleSortOrder");
		String priceSortOrder=req.getParameter("priceSortPrice");
		String setmeal=req.getParameter("setmeal");
		String csccs=req.getParameter("csccs");
		String csccb=req.getParameter("csccb");
		String cscts=req.getParameter("cscts");
		String csctb=req.getParameter("csctb");
		String csfss=req.getParameter("csfss");
		String csfsb=req.getParameter("csfsb");
		
		int cityIdInt=Integer.parseInt(cityId);
		
		
		String[] sort= {saleSortOrder,priceSortOrder};
		
		
		//当callTimeCount==null时,或者flowTimeCount==null,sortMessageCount==null
		//代表的是普通数据的查找
		if (callTimeCount==null&&cityId!=null&&csccs==null&&cscts==null&&csfss==null&&setmeal==null) {
			
			progressCommandCardData(req,resp,userId,cityId,sort);
			return;
		}
		if(cityId!=null&&callTimeCount!=null) {
		//下面是处理用户的自定义请求数据
		progressConsumeCardData(req,resp,userId,cityId,flowTimeCount,callTimeCount,sort);
		return;
		}
		
		/**
		 * 排序的参数收集
		 */
		List<FilterType> fList=new ArrayList<>();
		if(csccs!=null){
		fList.add(new FilterType("cscc", new int[] {
				Integer.parseInt(csccs),
				Integer.parseInt(csccb)
		}));
		}
		
		if(cscts!=null) {
			fList.add(new FilterType("csct", new int[] {
					Integer.parseInt(cscts),
					Integer.parseInt(csctb)
			}));
		}
		
		if(csfss!=null) {
			fList.add(new FilterType("csfs", new int[] {
					Integer.parseInt(csfss),
					Integer.parseInt(csfsb)
			}));
		}
 		
		//下面进行处理非自定义筛选请求的
		if((fList!=null||setmeal!=null)&&callTimeCount==null) {
			FilterCondition filterCondition=new FilterCondition(cityIdInt, setmeal, fList);
			progressNotConsumeFilterCondition(filterCondition,sort,req,resp);
			return;
		}
		
		
		
	}
	
	/**
	 * 处理非自定义筛选请求的
	 * @param filterCondition
	 * @throws IOException 
	 */
	private void progressNotConsumeFilterCondition(FilterCondition filterCondition,String[] sort,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		//1.直接获取 cityId，根据flowUser进行判断式的执行sql语句，将flist的动态添加
		CardOpration co=new CardDbController();
	
		List<Card> cards=co.queryCardInfoByCityIdandFilterCondition(filterCondition, sort);
		CardResponse cardResponse=new CardResponse();
		cardResponse.setCards(cards);
		cardResponse.setStatusResponseJson(new StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL));
		cardResponse.setTableName("card");
		Gson gson=new Gson();
		String responseData=gson.toJson(cardResponse);
		PrintWriter printWriter=resp.getWriter();
		printWriter.print(responseData);
        return;
		
	}

	/**
	 * 处理自定义card的数据的请求
	 * @param req
	 * @param resp
	 * @param userId
	 * @param cityId
	 * @param flowTimeCount
	 * @param callTimeCount
	 * @param sort 
	 * @throws IOException 
	 */
	private void progressConsumeCardData(HttpServletRequest req, HttpServletResponse resp, String userId, String cityId,
			String flowTimeCount, String callTimeCount, String[] sort) throws IOException {
		//将数据以及数据的分类进行返回
		//1.检索当前城市的套餐的所有数据
		int callTimeCountInt=Integer.parseInt(callTimeCount);
		int flowTimeCountInt=Integer.parseInt(flowTimeCount);
		int[] flowTimeRange;
		int[] callTimeRange;
		if(callTimeCountInt==0&&flowTimeCountInt!=0) {
			//处理流量用户  //测试正常
			flowTimeRange=DataBackAnalysis.flowTimeRange(flowTimeCountInt);
			progressFlowUserServer(cityId,req,resp,flowTimeRange,sort);
			return;
		}
		
		if(callTimeCountInt!=0&&flowTimeCountInt==0) {
			//处理话费用户   //测试正常
			callTimeRange= DataBackAnalysis.callTimeRange(callTimeCountInt);
			progtessCallUserServer(cityId,req,resp,callTimeRange,sort);
			return;
		}
		
		if(callTimeCountInt==0&&flowTimeCountInt==0) {
			//代表的是两个数剧都没有填写的用户,直接返回最原始的数剧    //测试正常
			progressNotFilterData(cityId,req,resp,sort);
			return;
		}
		//处理流量和话费的用户.测试正常
		callTimeRange= DataBackAnalysis.callTimeRange(callTimeCountInt);
		flowTimeRange=DataBackAnalysis.flowTimeRange(flowTimeCountInt);
		int cityIdInt=Integer.parseInt(cityId);
		CardOpration co=new CardDbController();
		List<Card> cards=co.queryCardInfoByCityIdConsumeSort(cityIdInt,callTimeRange,flowTimeRange,sort);
		CardResponse cardResponse=new CardResponse();
		cardResponse.setCards(cards);
		cardResponse.setStatusResponseJson(new StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL));
		cardResponse.setTableName("card");
		Gson gson=new Gson();
		String responseData=gson.toJson(cardResponse);
		PrintWriter printWriter=resp.getWriter();
		printWriter.print(responseData);
        return;
	}

	/**
	 * 处用户的普通数据请求,只是查询全部数据,然后根据条件进行
	 * @param req
	 * @param resp
	 * @param userId
	 * @param cityId
	 * @param sort 
	 * @throws IOException 
	 */
	private void progressCommandCardData(HttpServletRequest req, HttpServletResponse resp, String userId,
			String cityId, String[] sort) throws IOException {
		progressNotFilterData(cityId,req,resp,sort);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
	}
	
	
	/**
	 * 处理电话用户
	 * @param cityId
	 * @param req
	 * @param resp
	 * @param callTimeRange
	 * @param sort 
	 * @throws IOException 
	 */
	private void progtessCallUserServer(String cityId, HttpServletRequest req, HttpServletResponse resp,
			int[] callTimeRange, String[] sort) throws IOException {
		int cityIdInt=Integer.parseInt(cityId);
		CardOpration co=new CardDbController();
//		String[] sort= {"desc","desc"};
		List<Card> cards=co.queryCardinfoByCityIdCallConsume(cityIdInt,callTimeRange,sort);
		CardResponse cardResponse=new CardResponse();
		cardResponse.setCards(cards);
		cardResponse.setStatusResponseJson(new StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL));
		cardResponse.setTableName("card");
		Gson gson=new Gson();
		String responseData=gson.toJson(cardResponse);
		PrintWriter printWriter=resp.getWriter();
		printWriter.print(responseData);
		return;
	}

	/**
	 * 处理纯流量用户;
	 * @param cityId
	 * @param req
	 * @param resp
	 * @param flowTimeRange
	 * @param sort 
	 * @throws IOException 
	 */
	private void progressFlowUserServer(String cityId, HttpServletRequest req, HttpServletResponse resp,
			int[] flowTimeRange, String[] sort) throws IOException {
		int cityIdInt=Integer.parseInt(cityId);
		CardOpration co=new CardDbController();
//		String[] sort= {"desc","desc"};
		List<Card> cards=co.queryCardInfoByCityIdFlowConsume(cityIdInt,flowTimeRange,sort);
		CardResponse cardResponse=new CardResponse();
		cardResponse.setCards(cards);
		cardResponse.setStatusResponseJson(new StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL));
		cardResponse.setTableName("card");
		Gson gson=new Gson();
		String responseData=gson.toJson(cardResponse);
		PrintWriter printWriter=resp.getWriter();
		printWriter.print(responseData);
		return;
	}
	
	
	
	/**
	 * 处理未经赛选的数据
	 * @param cityId
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void progressNotFilterData(String cityId, HttpServletRequest req, HttpServletResponse resp,String[] sort) throws IOException {
		CardOpration cardOpration=new CardDbController();
		//String[] sort= {"desc","desc"};
		int cityIdInt=Integer.parseInt(cityId);
		List<Card> cards=cardOpration.queryCardInfoByCityId(cityIdInt, sort);
		CardResponse cardResponse=new CardResponse();
		cardResponse.setCards(cards);
		cardResponse.setStatusResponseJson(new StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL));
		cardResponse.setTableName("card");
		Gson gson=new Gson();
		String responseData=gson.toJson(cardResponse);
		PrintWriter printWriter=resp.getWriter();
		printWriter.print(responseData);
		return;
	}



	
	
	
		
	
	
}
