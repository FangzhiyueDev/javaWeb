package com.fang.rice.controll;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.rice.dbController.CardDbController;
import com.fang.rice.dbController.CardOpration;
import com.fang.rice.dbController.UserController;
import com.fang.rice.dbController.UserOpration;
import com.fang.rice.dbController.VipController;
import com.fang.rice.dbController.VipUserOpration;
import com.fang.rice.model.Card;
import com.fang.rice.model.CardResponse;
import com.fang.rice.model.User;
import com.fang.rice.server.DataBackAnalysis;
import com.google.gson.Gson;
import com.xiaofangfang.rice.model.StatusResponseJson;


/**
 * 该类是整个程序的核心类,用于提供最主要的服务
 * 该类通过请求的参数页面的名称,我们将请求转发给与之对应的servlet进行处理
 * 通过回传固定格式的json数据对页面进行动态的更新显示
 * 这个servlet的处理比较复杂,所以只处理这个请求,
 * @author fang
 *
 */
@WebServlet("/DataCenterAction")
public class DataCenterAction extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	 //final String url = NetRequest.APP_LAYOUT_SERVER_URL + "?callTimeCount=" + callTimeLength + "&flowTimeCount=" + flowTimeLength + "&userId=" + userId + "&city=" + currentSelectCity.getCityId();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		String callTimeCount=req.getParameter("callTimeCount");
		String flowTimeCount=req.getParameter("flowTimeCount");
		String userId=req.getParameter("userId");
		String cityId=req.getParameter("cityId");
		String sortMessageCount=req.getParameter("sortMessageCount");
		//vip用户检测
		VipUserOpration vipO=new VipController();
		boolean isVip=vipO.isVIP(new User(userId));
		if(isVip) {
			progressCenter(cityId,callTimeCount,flowTimeCount,sortMessageCount,req,resp);
			return;
		}
		//普通用户浏览状态检测
		 progressCommandUser(resp,req,userId,cityId,callTimeCount,flowTimeCount,sortMessageCount);
	}

	
	/**
	 * 实现真正的数据处理的流程
	 * @throws IOException 
	 */
	private void progressCenter(String cityId,String callTimeCount,
			String flowTimeCount,String sortMessageCount,HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		//将数据以及数据的分类进行返回
		//1.检索当前城市的套餐的所有数据
		int callTimeCountInt=Integer.parseInt(callTimeCount);
		int flowTimeCountInt=Integer.parseInt(flowTimeCount);
		int[] flowTimeRange;
		int[] callTimeRange;
		if(callTimeCountInt==0&&flowTimeCountInt!=0) {
			//处理流量用户
			flowTimeRange=DataBackAnalysis.flowTimeRange(flowTimeCountInt);
			progressFlowVipUserServer(cityId,req,resp,flowTimeRange);
			return;
		}
		
		if(callTimeCountInt!=0&&flowTimeCountInt==0) {
			//处理话费用户
			callTimeRange= DataBackAnalysis.callTimeRange(callTimeCountInt);
			progtessCallUserServer(cityId,req,resp,callTimeRange);
			return;
		}
		
		if(callTimeCountInt==0&&flowTimeCountInt==0) {
			//代表的是两个数剧都没有填写的用户,直接返回最原始的数剧
			progressNotFilterData(cityId,req,resp);
			return;
		}
		
		
		//处理流量和话费的用户
		callTimeRange= DataBackAnalysis.callTimeRange(callTimeCountInt);
		flowTimeRange=DataBackAnalysis.flowTimeRange(flowTimeCountInt);
		int messageCount=Integer.parseInt(sortMessageCount);
		progressVipServer(req,resp,callTimeRange,flowTimeRange,cityId,messageCount);
		return;
	}
    
	/**
	 * 处理未经赛选的数据
	 * @param cityId
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void progressNotFilterData(String cityId, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		CardOpration cardOpration=new CardDbController();
		String[] sort= {"desc","desc"};
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


	/**
	 * 普通用户的请求流程处理
	 * @param resp
	 * @param req
	 * @param userId
	 * @param sortMessageCount 
	 * @param flowTimeCount 
	 * @param callTimeCount 
	 * @param cityId 
	 * @throws IOException 
	 */
	private void progressCommandUser(HttpServletResponse resp, HttpServletRequest req, String userId, String cityId, String callTimeCount, String flowTimeCount, String sortMessageCount) throws IOException {
			//查询用户的浏览状态
		UserOpration uo=new UserController();
		boolean status=uo.queryUserBrowserStatus(userId);
		if (status) {//已经浏览过了
			PrintWriter printWriter=resp.getWriter();
			Gson gson=new Gson();
			CardResponse cardResponse=new CardResponse();
			cardResponse.setCards(new ArrayList<>());//空集合
			cardResponse.setStatusResponseJson(new StatusResponseJson(StatusResponseJson.USER_HAS_BROWSER));
			cardResponse.setTableName("card");
		    String jsonData=gson.toJson(cardResponse);
		   printWriter.print(jsonData);
		   return;
		}else {//反之修改浏览状态
			    //然后返回数据
			boolean sucessful=uo.changeUserBrowserStatus(new User(userId));
			if(!sucessful) {
				System.out.println("修改用户的浏览状态失败");
			}
             progressCenter(cityId, callTimeCount, flowTimeCount, sortMessageCount, req, resp);
             return;
		}
	}

	/**
	 * 处理电话用户
	 * @param cityId
	 * @param req
	 * @param resp
	 * @param callTimeRange
	 * @throws IOException 
	 */
	private void progtessCallUserServer(String cityId, HttpServletRequest req, HttpServletResponse resp,
			int[] callTimeRange) throws IOException {
		int cityIdInt=Integer.parseInt(cityId);
		CardOpration co=new CardDbController();
		String[] sort= {"desc","desc"};
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
	 * @throws IOException 
	 */
	private void progressFlowVipUserServer(String cityId, HttpServletRequest req, HttpServletResponse resp,
			int[] flowTimeRange) throws IOException {
		int cityIdInt=Integer.parseInt(cityId);
		CardOpration co=new CardDbController();
		String[] sort= {"desc","desc"};
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
	 * 处理vip用户的数据的返回
	 * @param resp 
	 * @param req 
	 * @param callTimeRange 通话分钟的边界
	 * @param flowTimeRange 流量使用小时的边界
	 * @param cityId
	 * @param provinceId
	 * @throws IOException 
	 */
	private void progressVipServer(HttpServletRequest req, HttpServletResponse resp, 
			int[] callTimeRange, int[] flowTimeRange, String cityId, int messageCount) throws IOException {
		int cityIdInt=Integer.parseInt(cityId);
		CardOpration co=new CardDbController();
		String[] sort= {"desc","desc"};
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
	

}
