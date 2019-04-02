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
import com.fang.rice.tool.IconMapping.Icon_IndexInfo;
import com.fang.rice.tool.IconMapping.Icon_functionMode;
import com.google.gson.Gson;
import com.fang.rice.tool.SystemParam;
import com.fang.rice.tool.createResponseData;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.FunctionModeViewDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.MyIndexInfoViewDataResponse;
import com.xiaofangfang.rice.model.serverBackResponseData.ViewModeResponseData;
import com.xiaofangfang.rice.model.view_mode.FunctionModeViewDataBean;
import com.xiaofangfang.rice.model.view_mode.FunctionModeViewDataBean.SingleData;
import com.xiaofangfang.rice.model.view_mode.MyIndexInfoViewDataBean;
import com.xiaofangfang.rice.model.view_mode.MyIndexInfoViewDataBean.InnerCommandButtonOpration;
import com.xiaofangfang.rice.model.view_mode.MyIndexInfoViewDataBean.InnerImageButtonOpration;

@WebServlet("/MySelfFragmentAction")
public class MySelfFragmentAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		String cityId=req.getParameter("cityId");	
	
		List<InnerImageButtonOpration> innerImageButtonOprations=new ArrayList<>();
		innerImageButtonOprations.add(new InnerImageButtonOpration(SystemParam.imageAddress+"rice.jpg",
				ClientActivityName.SelfDetailInfoActivity.activityName, "selfDetail"));
		
		int imageAddress=IconMapping.getIndexInfoIconAddress(Icon_IndexInfo.ic_setting);
		innerImageButtonOprations.add(new InnerImageButtonOpration(imageAddress+"", ClientActivityName.SystemSettingActivity.activityName, "SystemSettng"));
		
	
		List<InnerCommandButtonOpration> innerCommandButtonOprations=new ArrayList<>();
		innerCommandButtonOprations.add(new InnerCommandButtonOpration(IconMapping.getIndexInfoIconAddress(Icon_IndexInfo.ic_logistics)+"", 
				ClientActivityName.LogisticsQueryActivity.activityName, "物流查询", "logistics"));
		innerCommandButtonOprations.add(new InnerCommandButtonOpration(IconMapping.getIndexInfoIconAddress(Icon_IndexInfo.ic_shop_car)+"", 
				ClientActivityName.PurchasedBabyActivity.activityName, "已购宝贝", "purchasedBaby"));
		
		MyIndexInfoViewDataBean myIndexInfoViewDataBean=new MyIndexInfoViewDataBean(innerImageButtonOprations, "", innerCommandButtonOprations);
		
		MyIndexInfoViewDataResponse myIndexInfoViewDataResponse=createResponseData.createMyIndexInfoViewDataResponse(myIndexInfoViewDataBean, 0);
		
		List<SingleData> singleDatas=new ArrayList<>();
		
		singleDatas.add(new SingleData(IconMapping.getFunctionModeIconAddress(Icon_functionMode.ic_register_vip)+"",
				ClientActivityName.RegisterVipActivity.activityName, "注册会员", "RigsterVIP"));
		singleDatas.add(new SingleData(IconMapping.getFunctionModeIconAddress(Icon_functionMode.ic_dianhuazixun_big)+"",
				ClientActivityName.TelephoneConsultationActivity.activityName, "电话咨询", "TelephoneConsultation"));
		singleDatas.add(new SingleData(IconMapping.getFunctionModeIconAddress(Icon_functionMode.ic_qiyefuwu_big)+"",
				ClientActivityName.EnterpriseServiceActivity.activityName, "企业服务", "EnterpriseService"));
		singleDatas.add(new SingleData(IconMapping.getFunctionModeIconAddress(Icon_functionMode.ic_publish_phone)+"",
				ClientActivityName.PublishSecondHandPhoneActivity.activityName, "发布二手机", "PublishSecondPage"));

		FunctionModeViewDataBean functionModeViewDataBean=new FunctionModeViewDataBean("常用快捷", singleDatas);
		
		FunctionModeViewDataResponse functionModeViewDataResponse=createResponseData.createFunctionModeViewDataResponse(functionModeViewDataBean, 1);
		
		List viewRootChilds=new ArrayList<>();
		List viewGroupChilds=new ArrayList<>();
		viewGroupChilds.add(myIndexInfoViewDataResponse);
		viewGroupChilds.add(functionModeViewDataResponse);
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
