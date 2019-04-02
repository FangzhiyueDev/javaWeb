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

import com.fang.rice.tool.ClientActivityName;
import com.fang.rice.tool.IconMapping;
import com.fang.rice.tool.SystemParam;
import com.fang.rice.tool.createResponseData;
import com.google.gson.Gson;
import com.xiaofangfang.rice.model.Card;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.BannerFlipperContainerDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.ConsumeToolbarDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.MyMenuFunctionViewDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.SetmealViewDataResponse;
import com.xiaofangfang.rice.model.serverBackResponseData.ViewModeResponseData;
import com.xiaofangfang.rice.model.view_mode.BannerFlipContainerDataBean;
import com.xiaofangfang.rice.model.view_mode.MyMenuFunctionListDataBean;
import com.xiaofangfang.rice.model.view_mode.SetmealViewDataBean;
import com.xiaofangfang.rice.model.view_mode.SetmealViewDataBean.CardType;

@WebServlet("/BusinessFragmentAction")
public class BusinessFragmentAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		
		String cityId=req.getParameter("cityId");	
		
		/**
		 * 创建toolbar		
		 */		
		ConsumeToolbarDataResponse consumeToolbarDataResponse=createResponseData.createConsumeToolbarDataResponse(null, 0);
		
		/**
		 * 创建banner
		 */
		List<BannerFlipContainerDataBean.SingleData> singleDataList=new ArrayList<>();
		singleDataList.add(new BannerFlipContainerDataBean.SingleData(SystemParam.imageAddress+"banner1.jpg", ClientActivityName.BannerFlipperActivity.activityName, "javaWeb程序设计", "程序设计"));
		singleDataList.add(new BannerFlipContainerDataBean.SingleData(SystemParam.imageAddress+"banner2.jpg", ClientActivityName.BannerFlipperActivity.activityName, "javaWeb程序设计", "程序设计"));
		singleDataList.add(new BannerFlipContainerDataBean.SingleData(SystemParam.imageAddress+"banner3.jpg", ClientActivityName.BannerFlipperActivity.activityName, "javaWeb程序设计", "程序设计"));
		singleDataList.add(new BannerFlipContainerDataBean.SingleData(SystemParam.imageAddress+"banner4.jpg", ClientActivityName.BannerFlipperActivity.activityName, "javaWeb程序设计", "程序设计"));
		singleDataList.add(new BannerFlipContainerDataBean.SingleData(SystemParam.imageAddress+"banner5.jpg", ClientActivityName.BannerFlipperActivity.activityName, "javaWeb程序设计", "程序设计"));
		BannerFlipContainerDataBean bannerFlipContainerDataBean=new BannerFlipContainerDataBean(singleDataList);
		BannerFlipperContainerDataResponse bannerFlipperContainerDataResponse=createResponseData.createBannerFlipperContainerDataResponse(bannerFlipContainerDataBean,0);
				
		
		/**
		 * 创建菜单List
		 */
	
		List<MyMenuFunctionListDataBean.SingleData> singleDataList2=new ArrayList<>();
		singleDataList2.add(new MyMenuFunctionListDataBean.SingleData(IconMapping.getMenuFunctionListIconAddress(IconMapping.Icon_menuFunctionList.ic_change_setmeal)+""
				, ClientActivityName.SetmealChangeActivity.activityName, "套餐变更"));
		singleDataList2.add(new MyMenuFunctionListDataBean.SingleData(IconMapping.getMenuFunctionListIconAddress(IconMapping.Icon_menuFunctionList.ic_shenqing)+""
				, ClientActivityName.ApplyAccountActivity.activityName, "申请账号"));
		singleDataList2.add(new MyMenuFunctionListDataBean.SingleData(IconMapping.getMenuFunctionListIconAddress(IconMapping.Icon_menuFunctionList.ic_kuandai)+""
				, ClientActivityName.BroadbandServiceActivity.activityName, "宽带业务"));
		singleDataList2.add(new MyMenuFunctionListDataBean.SingleData(IconMapping.getMenuFunctionListIconAddress(IconMapping.Icon_menuFunctionList.ic_guhua_server)+""
				, ClientActivityName.FixedLineServiceActivity.activityName, "固话业务"));
		MyMenuFunctionListDataBean myMenuFunctionListDataBean=new MyMenuFunctionListDataBean(singleDataList2);
		MyMenuFunctionViewDataResponse myMenuFunctionViewDataResponse=createResponseData.createMyMenuFunctionViewDataResponse(myMenuFunctionListDataBean, 1);
		
		/**
		 * 创建菜单List
		 */
	
		List<MyMenuFunctionListDataBean.SingleData> singleDataList3=new ArrayList<>();
		singleDataList3.add(new MyMenuFunctionListDataBean.SingleData(IconMapping.getMenuFunctionListIconAddress(IconMapping.Icon_menuFunctionList.ic_zhuan_net)+""
				, ClientActivityName.CarryingNumberToNetworkActivity.activityName, "携号转网"));
		singleDataList3.add(new MyMenuFunctionListDataBean.SingleData(IconMapping.getMenuFunctionListIconAddress(IconMapping.Icon_menuFunctionList.ic_pingjia)+""
				, ClientActivityName.ServiceEvaluationActivity.activityName, "服务评价"));
		singleDataList3.add(new MyMenuFunctionListDataBean.SingleData(IconMapping.getMenuFunctionListIconAddress(IconMapping.Icon_menuFunctionList.ic_tongxun)+""
				, ClientActivityName.CommunicationGuidanceActivity.activityName, "通讯指导"));
		singleDataList3.add(new MyMenuFunctionListDataBean.SingleData(IconMapping.getMenuFunctionListIconAddress(IconMapping.Icon_menuFunctionList.ic_youhui)+""
				, ClientActivityName.RecentDiscountActivity.activityName, "最近优惠"));
		MyMenuFunctionListDataBean myMenuFunctionListDataBean1=new MyMenuFunctionListDataBean(singleDataList3);
		MyMenuFunctionViewDataResponse myMenuFunctionViewDataResponse1=createResponseData.createMyMenuFunctionViewDataResponse(myMenuFunctionListDataBean1, 2);

		
	    List<CardType> cardTypeList=new ArrayList<>();
	    cardTypeList.add(new CardType(ClientActivityName.CardDetailActivity.activityName, "cardDetail",new Card(12,  "大网卡", 19, "送120元话费","专属app免流+100分钟通话")));
	    cardTypeList.add(new CardType(ClientActivityName.CardDetailActivity.activityName, "cardDetail",new Card(924,  "大网卡", 99, "每月返回20元话费","全国流量20G畅想+50分钟通话")));
		SetmealViewDataBean setmealViewDataBean=new SetmealViewDataBean("套餐卡","更多套餐", ClientActivityName.ProductSalePageActivity.activityName,
				SystemParam.imageAddress+"banner1.jpg", ClientActivityName.ProductSalePageActivity.activityName, cardTypeList,"card");
		SetmealViewDataResponse setmealViewDataResponse=createResponseData.createSetmealViewDataResponse(setmealViewDataBean,3);
		
		List viewRootChilds=new ArrayList<>();
		viewRootChilds.add(consumeToolbarDataResponse);
		List viewGroupChilds=new ArrayList<>();
		viewGroupChilds.add(bannerFlipperContainerDataResponse);
		viewGroupChilds.add(myMenuFunctionViewDataResponse);
		viewGroupChilds.add(myMenuFunctionViewDataResponse1);
		viewGroupChilds.add(setmealViewDataResponse);
		ViewModeResponseData viewModeResponseData=new ViewModeResponseData(viewRootChilds, viewGroupChilds);		
		Gson gson=new Gson();
		String jsonData=gson.toJson(viewModeResponseData);
		System.out.println("接受到请求");
		PrintWriter pw=resp.getWriter();
		pw.print(jsonData);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
