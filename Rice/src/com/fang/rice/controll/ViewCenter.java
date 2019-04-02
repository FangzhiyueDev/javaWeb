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

import com.fang.rice.delete.ViewDeleteResponse;
import com.fang.rice.insertResponse.ViewInsertResponse;
import com.fang.rice.insertResponse.ViewInsertResponse.ActionHorizonalScrollViewInsertResponse;
import com.fang.rice.insertResponse.ViewOprateCode;
import com.fang.rice.tool.ClientActivityName;
import com.fang.rice.tool.ConsumeViewName;
import com.fang.rice.updateResponse.UpdateLeavel;
import com.fang.rice.updateResponse.ViewUpdateResponse.BannerFlipperUpdateResponse;
import com.fang.viewdataBean.ActionHorizontalScrollViewDataBean;
import com.fang.viewdataBean.ActionHorizontalScrollViewDataBean.SingleData;
import com.fang.viewdataBean.BannerDataRespnse;
import com.fang.viewdataBean.BannerDataRespnse.SingleBannerDataResponse;
import com.fang.viewdataBean.DataResponse;
import com.google.gson.Gson;
import com.xiaofangfang.rice.model.Card;


@WebServlet("/ViewCenter")
public class ViewCenter extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		String fragmentName=req.getParameter("action");
		
		if(fragmentName.equals("Main_fragment")) {
			progressMainFragment(req,resp);
			return;
		}else if(fragmentName.equals("MySelf_fragment")) {
			progressMySelfFragment(req,resp);
			return;
		}else if(fragmentName.equals("Business_fragment")) {
			progressBusinessFragment(req,resp);
			return;
		}else if(fragmentName.equals("Phone_fragment")) {
			progressPhoneFragment(req,resp);
			return;
		}
		
	}
	
	
	
	private void progressPhoneFragment(HttpServletRequest req, HttpServletResponse resp) {
		
		
		
		
		
		
	}



	private void progressBusinessFragment(HttpServletRequest req, HttpServletResponse resp) {
		
	}



	private void progressMySelfFragment(HttpServletRequest req, HttpServletResponse resp) {
		
	}



	private void progressMainFragment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		
		List<SingleBannerDataResponse> singleBannerDataResponses=new ArrayList<>();
		
		singleBannerDataResponses.add(new SingleBannerDataResponse(-1, "/image/hand_phone.jpg", "二手机的市场", ClientActivityName.BannerFlipperActivity.activityName, null));
		singleBannerDataResponses.add(new SingleBannerDataResponse(-1, "/image/hand_phone.jpg", "二手机的市场", ClientActivityName.BannerFlipperActivity.activityName, null));
		singleBannerDataResponses.add(new SingleBannerDataResponse(-1, "/image/hand_phone.jpg", "二手机的市场", ClientActivityName.BannerFlipperActivity.activityName, null));
		singleBannerDataResponses.add(new SingleBannerDataResponse(-1, "/image/hand_phone.jpg", "二手机的市场", ClientActivityName.BannerFlipperActivity.activityName, null));
		singleBannerDataResponses.add(new SingleBannerDataResponse(-1, "/image/hand_phone.jpg", "二手机的市场", ClientActivityName.BannerFlipperActivity.activityName, null));
		
		
		BannerDataRespnse dataRespnse=new BannerDataRespnse(singleBannerDataResponses);
		
		BannerFlipperUpdateResponse bResponse=new BannerFlipperUpdateResponse(dataRespnse, 
				UpdateLeavel.updateImgAndText.getLeavle(), 0,ViewOprateCode.update.getOprateCode());
		
		ViewDeleteResponse viewDeleteResponse=new ViewDeleteResponse(3, ViewOprateCode.delete.getOprateCode());
		
		
		List<ActionHorizontalScrollViewDataBean.SingleData> singleDataList=new ArrayList<>();
			
		singleDataList.add(new SingleData("/image/phone1.jpg", ClientActivityName.ProductSalePageActivity.activityName, "最新的套餐", "套餐资费", Card.class.getSimpleName(), -1));
		singleDataList.add(new SingleData("/image/phone1.jpg", ClientActivityName.ProductSalePageActivity.activityName, "最新的套餐", "套餐资费", Card.class.getSimpleName(), -1));
		singleDataList.add(new SingleData("/image/phone1.jpg", ClientActivityName.ProductSalePageActivity.activityName, "最新的套餐", "套餐资费", Card.class.getSimpleName(), -1));
		singleDataList.add(new SingleData("/image/phone1.jpg", ClientActivityName.ProductSalePageActivity.activityName, "最新的套餐", "套餐资费", Card.class.getSimpleName(), -1));
		singleDataList.add(new SingleData("/image/phone1.jpg", ClientActivityName.ProductSalePageActivity.activityName, "最新的套餐", "套餐资费", Card.class.getSimpleName(), -1));
		
		ActionHorizontalScrollViewDataBean ahsvdb=new  ActionHorizontalScrollViewDataBean(singleDataList);
			
		ActionHorizonalScrollViewInsertResponse ahscvir=new ActionHorizonalScrollViewInsertResponse(4, ViewOprateCode.insert.getOprateCode(), 
				ahsvdb,ConsumeViewName.MY_ACTION_HORIZONTAL_SCROLL_VIEW.consumeViewName,UpdateLeavel.updateAll.getLeavle());
		
		List dataResponses=new ArrayList<>();
		
		dataResponses.add(bResponse);
		dataResponses.add(viewDeleteResponse);
		dataResponses.add(ahscvir);
		
		Gson gson=new Gson();
		String jsonData=gson.toJson(dataResponses);
		PrintWriter printWriter=resp.getWriter();
		printWriter.print(jsonData);
		
		
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doGet(req, resp);
		
	}
	
   
   
	
	
	
	

}
