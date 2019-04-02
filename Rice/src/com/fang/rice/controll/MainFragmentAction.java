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
import com.fang.rice.tool.ConsumeViewName;
import com.fang.rice.tool.IconMapping;
import com.fang.rice.tool.SystemParam;
import com.fang.rice.tool.TableNameMappingOpration;
import com.fang.rice.tool.createResponseData;
import com.google.gson.Gson;
import com.xiaofangfang.rice.model.Phone;
import com.xiaofangfang.rice.model.PhoneNumber;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.ActionHorizontalScrollViewDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.BannerFlipperContainerDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.ConsumeToolbarDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.DataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.FunctionModeViewDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.LiangHaoDisplayViewDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.MyIndexInfoViewDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.MyMenuFunctionViewDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.PhoneDisplayViewDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.PhoneSaleViewDataResponse;
import com.xiaofangfang.rice.model.serverBackResponseData.ViewModeResponseData;
import com.xiaofangfang.rice.model.view_mode.ActionHorizontalScrollViewDataBean;
import com.xiaofangfang.rice.model.view_mode.ActionHorizontalScrollViewDataBean.SingleData;
import com.xiaofangfang.rice.model.view_mode.BannerFlipContainerDataBean;
import com.xiaofangfang.rice.model.view_mode.ConsumeToolbarDataBean;
import com.xiaofangfang.rice.model.view_mode.LiangHaoDisplayViewDataBean;
import com.xiaofangfang.rice.model.view_mode.LiangHaoDisplayViewDataBean.LiangHaoType;
import com.xiaofangfang.rice.model.view_mode.MyMenuFunctionListDataBean;
import com.xiaofangfang.rice.model.view_mode.PhoneDisplayViewDataBean;

@WebServlet("/MainFragmentAction")
public class MainFragmentAction extends HttpServlet {

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
		singleDataList2.add(new MyMenuFunctionListDataBean.SingleData(IconMapping.getMenuFunctionListIconAddress(IconMapping.Icon_menuFunctionList.ic_lianghaozhongxin)+""
				, ClientActivityName.LiangHaoActivity.activityName, "靓号"));
		singleDataList2.add(new MyMenuFunctionListDataBean.SingleData(IconMapping.getMenuFunctionListIconAddress(IconMapping.Icon_menuFunctionList.ic_shouji)+""
				, ClientActivityName.ProductSalePageActivity.activityName, "二手手机",TableNameMappingOpration.ProductSalePageActivityTableNameMapping.secondHandPhone.tableName));
		singleDataList2.add(new MyMenuFunctionListDataBean.SingleData(IconMapping.getMenuFunctionListIconAddress(IconMapping.Icon_menuFunctionList.ic_liuliang)+""
				, ClientActivityName.FlowInfoRecordActivity.activityName, "流量摸底",TableNameMappingOpration.ProductSalePageActivityTableNameMapping.card.tableName));
		singleDataList2.add(new MyMenuFunctionListDataBean.SingleData(IconMapping.getMenuFunctionListIconAddress(IconMapping.Icon_menuFunctionList.ic_zhangdan)+""
				, ClientActivityName.QueryBillActivity.activityName, "查询账单"));
		MyMenuFunctionListDataBean myMenuFunctionListDataBean=new MyMenuFunctionListDataBean(singleDataList2);
		MyMenuFunctionViewDataResponse myMenuFunctionViewDataResponse=createResponseData.createMyMenuFunctionViewDataResponse(myMenuFunctionListDataBean, 1);
		
		
		/**
		 * 创建活动水平滚动视图的对象
		 */
		List<ActionHorizontalScrollViewDataBean.SingleData> singleDataList1=new ArrayList<>();
		singleDataList1.add(new SingleData(SystemParam.imageAddress+"banner1.jpg", ClientActivityName.ActionHorizontalActivity.activityName, "最新的优惠活动有哪些","最新优惠","最新优惠"));
		singleDataList1.add(new SingleData(SystemParam.imageAddress+"banner2.jpg", ClientActivityName.ActionHorizontalActivity.activityName, "最新的优惠活动有哪些","最新优惠","最新优惠"));
		singleDataList1.add(new SingleData(SystemParam.imageAddress+"banner3.jpg", ClientActivityName.ActionHorizontalActivity.activityName, "最新的优惠活动有哪些","最新优惠","最新优惠"));
		singleDataList1.add(new SingleData(SystemParam.imageAddress+"banner4.jpg", ClientActivityName.ActionHorizontalActivity.activityName, "最新的优惠活动有哪些","最新优惠","最新优惠"));
		singleDataList1.add(new SingleData(SystemParam.imageAddress+"banner5.jpg", ClientActivityName.ActionHorizontalActivity.activityName, "最新的优惠活动有哪些","最新优惠","最新优惠"));
		ActionHorizontalScrollViewDataBean actionHorizontalScrollViewDataBean=new ActionHorizontalScrollViewDataBean(singleDataList1);
		ActionHorizontalScrollViewDataResponse actionHorizontalScrollViewDataResponse=createResponseData.createActionHorizontalScrollViewDataResponse(actionHorizontalScrollViewDataBean, 2);
		
		/**
		 * 创建手机专区
		 */
	
		
		List<PhoneDisplayViewDataBean.SingleData> singleDatas=new ArrayList<>();
		List<Phone> phones=new ArrayList<>();
		phones.add(new Phone(1,SystemParam.imageAddress+"phone1,jpg", "华为P20", "预存50得100", 3088f, "抖音畅想力量卡"));
		phones.add(new Phone(1,SystemParam.imageAddress+"phone1,jpg", "oppo R17", "预存50得100", 2056f, "抖音畅想力量卡"));
		phones.add(new Phone(1,SystemParam.imageAddress+"phone1,jpg", "Oppo R17", "预存50得100",2056f, "抖音畅想力量卡"));
		singleDatas.add(new PhoneDisplayViewDataBean.SingleData(phones.get(0), ClientActivityName.PhoneDetainPageActivity.activityName, TableNameMappingOpration.ProductSalePageActivityTableNameMapping.phone.tableName));
		singleDatas.add(new PhoneDisplayViewDataBean.SingleData(phones.get(1), ClientActivityName.PhoneDetainPageActivity.activityName,  TableNameMappingOpration.ProductSalePageActivityTableNameMapping.phone.tableName));
		singleDatas.add(new PhoneDisplayViewDataBean.SingleData(phones.get(2), ClientActivityName.PhoneDetainPageActivity.activityName,  TableNameMappingOpration.ProductSalePageActivityTableNameMapping.phone.tableName));
		PhoneDisplayViewDataBean phoneDisplayViewDataBean=new PhoneDisplayViewDataBean("手机专区","手机频道",
				ClientActivityName.ProductSalePageActivity.activityName, singleDatas,TableNameMappingOpration.ProductSalePageActivityTableNameMapping.phone.tableName);
		PhoneDisplayViewDataResponse phoneDisplayViewDataResponse=createResponseData.createPhoneDisplayViewDataResponse(phoneDisplayViewDataBean, 3);
		
		
		/**
		 * 靓号的界面显示
		 */
	     List<LiangHaoType> liangHaoTypes=new  ArrayList<>(); 
	     List<PhoneNumber> phoneNumbers=new ArrayList<>();
	     phoneNumbers.add(new PhoneNumber("17715474567", "南京",ClientActivityName.LiangHaoDetailPageActivity.activityName,"LiangHaoDetail"));
	     phoneNumbers.add(new PhoneNumber("17715474567", "南京",ClientActivityName.LiangHaoDetailPageActivity.activityName,"LiangHaoDetail"));
	     phoneNumbers.add(new PhoneNumber("17715474567", "南京",ClientActivityName.LiangHaoDetailPageActivity.activityName,"LiangHaoDetail"));
	     
	     liangHaoTypes.add(new LiangHaoType("精选靓号", phoneNumbers, "LiangHaoDetail", ClientActivityName.LiangHaoDetailPageActivity.activityName));
	     
	     List<PhoneNumber> phoneNumbers1=new ArrayList<>();
	     phoneNumbers1.add(new PhoneNumber("17715474567", "南京",ClientActivityName.LiangHaoDetailPageActivity.activityName,"LiangHaoDetail"));
	     phoneNumbers1.add(new PhoneNumber("17715474567", "南京",ClientActivityName.LiangHaoDetailPageActivity.activityName,"LiangHaoDetail"));
	     
	     liangHaoTypes.add(new LiangHaoType("情侣号", phoneNumbers1, "LiangHaoDetail", ClientActivityName.LiangHaoDetailPageActivity.activityName));
	     
	     
	     List<PhoneNumber> phoneNumbers2=new ArrayList<>();
	     phoneNumbers2.add(new PhoneNumber("17715474567", "南京",ClientActivityName.LiangHaoDetailPageActivity.activityName,"LiangHaoDetail"));
	     phoneNumbers2.add(new PhoneNumber("17715474567", "南京",ClientActivityName.LiangHaoDetailPageActivity.activityName,"LiangHaoDetail"));
	     
	     liangHaoTypes.add(new LiangHaoType("吉祥号", phoneNumbers, "LiangHaoDetail", ClientActivityName.LiangHaoDetailPageActivity.activityName));
	     

		LiangHaoDisplayViewDataBean liangHaoDisplayViewDataBean=new LiangHaoDisplayViewDataBean("靓号专区", "更多",
				ClientActivityName.LiangHaoActivity.activityName, liangHaoTypes, "LiangHao");
		
		LiangHaoDisplayViewDataResponse liangHaoDisplayViewDataResponse=createResponseData.createLiangHaoDisplayViewDataResponse(liangHaoDisplayViewDataBean, 4);
		
		
		List viewRootChilds=new ArrayList<>();
		viewRootChilds.add(consumeToolbarDataResponse);
		List viewGroupChilds=new ArrayList<>();
		viewGroupChilds.add(bannerFlipperContainerDataResponse);
		viewGroupChilds.add(myMenuFunctionViewDataResponse);
		viewGroupChilds.add(actionHorizontalScrollViewDataResponse);
		viewGroupChilds.add(phoneDisplayViewDataResponse);
		viewGroupChilds.add(liangHaoDisplayViewDataResponse);
		ViewModeResponseData viewModeResponseData=new ViewModeResponseData(viewRootChilds, viewGroupChilds);		
		Gson gson=new Gson();
		String jsonData=gson.toJson(viewModeResponseData);
		System.out.println("接受到请求");
		PrintWriter pw=resp.getWriter();
		pw.print(jsonData);
		
	}
	
	private void testObjMapping(String jsonData) {
	
		Gson gson=new Gson();
        ViewModeResponseData viewModeResponseData=gson.fromJson(jsonData, ViewModeResponseData.class);
       
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
