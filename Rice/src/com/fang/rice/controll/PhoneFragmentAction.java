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
import com.fang.rice.tool.SystemParam;
import com.fang.rice.tool.TableNameMappingOpration;
import com.fang.rice.tool.createResponseData;
import com.google.gson.Gson;
import com.xiaofangfang.rice.model.Phone;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.BannerFlipperContainerDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.ConsumeToolbarDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.PhoneSaleViewDataResponse;
import com.xiaofangfang.rice.model.serverBackResponseData.ViewModeResponseData;
import com.xiaofangfang.rice.model.view_mode.BannerFlipContainerDataBean;
import com.xiaofangfang.rice.model.view_mode.PhoneSaleViewDataBean;
import com.xiaofangfang.rice.model.view_mode.PhoneSaleViewDataBean.PhoneSingleData;

@WebServlet("/PhoneFragmentAction")
public class PhoneFragmentAction extends HttpServlet {

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
		 * 创建phonesaleView
		 */
		
		List<List<PhoneSingleData>> phoneSingleDataList=new ArrayList<>();
		List<PhoneSingleData> phoneSingleDatas=new ArrayList<>();
		phoneSingleDatas.add(new PhoneSingleData(new Phone(1,SystemParam.imageAddress+"phone1.jpg", "荣耀8", "热卖", 1899,"千元霸屏"), 
				ClientActivityName.PhoneDetainPageActivity.activityName, TableNameMappingOpration.ProductSalePageActivityTableNameMapping.phone.tableName));
		phoneSingleDatas.add(new PhoneSingleData(new Phone(1,SystemParam.imageAddress+"phone1.jpg", "荣耀8", "热卖", 1899, "千元霸屏"), 
				ClientActivityName.PhoneDetainPageActivity.activityName, TableNameMappingOpration.ProductSalePageActivityTableNameMapping.phone.tableName));
		
		List<PhoneSingleData> phoneSingleDatas1=new ArrayList<>();
		phoneSingleDatas1.add(new PhoneSingleData(new Phone(1,SystemParam.imageAddress+"phone1.jpg", "荣耀8", "热卖", 1899, "千元霸屏"), 
				ClientActivityName.PhoneDetainPageActivity.activityName,  TableNameMappingOpration.ProductSalePageActivityTableNameMapping.phone.tableName));
		phoneSingleDatas1.add(new PhoneSingleData(new Phone(1,SystemParam.imageAddress+"phone1.jpg", "荣耀8", "热卖", 1899, "千元霸屏"), 
				ClientActivityName.PhoneDetainPageActivity.activityName, TableNameMappingOpration.ProductSalePageActivityTableNameMapping.phone.tableName));
		phoneSingleDataList.add(phoneSingleDatas);
		phoneSingleDataList.add(phoneSingleDatas1);
		
		PhoneSaleViewDataBean phoneSaleViewDataBean=new PhoneSaleViewDataBean("智能手机", "更多", ClientActivityName.ProductSalePageActivity.activityName,
				"phone", phoneSingleDataList);
				PhoneSaleViewDataResponse phoneSaleViewDataResponse=createResponseData.createPhoneSaleViewDataResponse(phoneSaleViewDataBean, 1);
		
				
				List viewRootChilds=new ArrayList<>();
				viewRootChilds.add(consumeToolbarDataResponse);
				List viewGroupChilds=new ArrayList<>();
				viewGroupChilds.add(bannerFlipperContainerDataResponse);
				viewGroupChilds.add(phoneSaleViewDataResponse);
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
