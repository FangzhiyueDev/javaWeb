package com.fang.rice.tool;


import com.xiaofangfang.rice.model.StatusResponseJson;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.ActionHorizontalScrollViewDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.BannerFlipperContainerDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.ConsumeToolbarDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.FunctionModeViewDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.LiangHaoDisplayViewDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.MyIndexInfoViewDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.MyMenuFunctionViewDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.PhoneDisplayViewDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.PhoneSaleViewDataResponse;
import com.xiaofangfang.rice.model.SingleViewModeDataResponse.SetmealViewDataResponse;
import com.xiaofangfang.rice.model.view_mode.ActionHorizontalScrollViewDataBean;
import com.xiaofangfang.rice.model.view_mode.BannerFlipContainerDataBean;
import com.xiaofangfang.rice.model.view_mode.ConsumeToolbarDataBean;
import com.xiaofangfang.rice.model.view_mode.FunctionModeViewDataBean;
import com.xiaofangfang.rice.model.view_mode.LiangHaoDisplayViewDataBean;
import com.xiaofangfang.rice.model.view_mode.MyIndexInfoViewDataBean;
import com.xiaofangfang.rice.model.view_mode.MyMenuFunctionListDataBean;
import com.xiaofangfang.rice.model.view_mode.PhoneDisplayViewDataBean;
import com.xiaofangfang.rice.model.view_mode.PhoneSaleViewDataBean;
import com.xiaofangfang.rice.model.view_mode.SetmealViewDataBean;

/**
 * 用于创建响应对象
 * @author fang
 *
 */
public class createResponseData {

	
	/**
	 * 创建活动滚动视图的界面
	 * @param actionHorizontalScrollViewDataBean
	 * @param additionLocationIndex
	 * @return
	 */
	public static ActionHorizontalScrollViewDataResponse createActionHorizontalScrollViewDataResponse(ActionHorizontalScrollViewDataBean actionHorizontalScrollViewDataBean
			,int additionLocationIndex) {
		StatusResponseJson statusResponseJson=new StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL);
		
		ActionHorizontalScrollViewDataResponse actionHorizontalScrollViewDataResponse=new ActionHorizontalScrollViewDataResponse(statusResponseJson,
				ConsumeViewName.MY_ACTION_HORIZONTAL_SCROLL_VIEW.consumeViewName, SystemParam.VIEW_GROUP, actionHorizontalScrollViewDataBean, additionLocationIndex);
		return actionHorizontalScrollViewDataResponse;
	}
	
	public static BannerFlipperContainerDataResponse createBannerFlipperContainerDataResponse(BannerFlipContainerDataBean bannerFlipContainerDataBean,
			int additionLocationIndex) {
		StatusResponseJson statusResponseJson=new StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL);
		BannerFlipperContainerDataResponse bannerFlipperContainerDataResponse=new BannerFlipperContainerDataResponse(statusResponseJson,
				ConsumeViewName.BANNER_FLIP_CONTAINER.consumeViewName, SystemParam.VIEW_GROUP, bannerFlipContainerDataBean, additionLocationIndex);
		return bannerFlipperContainerDataResponse; 
	}
	
	public static ConsumeToolbarDataResponse createConsumeToolbarDataResponse(ConsumeToolbarDataBean consumeToolbarDataBean,int additionLocationIndex) {
		StatusResponseJson statusResponseJson=new  StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL);
		ConsumeToolbarDataResponse consumeToolbarDataResponse=new ConsumeToolbarDataResponse(statusResponseJson,
				ConsumeViewName.CONSUME_TOOLBAR.consumeViewName,SystemParam.VIEW_ROOT, consumeToolbarDataBean, additionLocationIndex);
		return consumeToolbarDataResponse;
	}
	
	public static FunctionModeViewDataResponse createFunctionModeViewDataResponse(FunctionModeViewDataBean functionModeViewDataBean,int additionLocationIndex) {
		StatusResponseJson statusResponseJson=new  StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL);
		FunctionModeViewDataResponse functionModeViewDataResponse=new FunctionModeViewDataResponse(statusResponseJson,
				ConsumeViewName.FUNCTION_MODE.consumeViewName,SystemParam.VIEW_GROUP, functionModeViewDataBean,  additionLocationIndex);	
		return functionModeViewDataResponse;
	}
	
	public static LiangHaoDisplayViewDataResponse createLiangHaoDisplayViewDataResponse(LiangHaoDisplayViewDataBean liangHaoDisplayViewDataBean,
			int additionLocationIndex) {
		StatusResponseJson statusResponseJson=new StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL);
		LiangHaoDisplayViewDataResponse liangHaoDisplayViewDataResponse=new LiangHaoDisplayViewDataResponse(statusResponseJson,
				ConsumeViewName.LIANG_HAO_DISPLAY_VIEW.consumeViewName, SystemParam.VIEW_GROUP, liangHaoDisplayViewDataBean, additionLocationIndex);
		return liangHaoDisplayViewDataResponse;
	}
	
	public static MyIndexInfoViewDataResponse createMyIndexInfoViewDataResponse(MyIndexInfoViewDataBean myIndexInfoViewDataBean,int additionLocationIndex) {
		StatusResponseJson statusResponseJson=new StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL);
		MyIndexInfoViewDataResponse myIndexInfoViewDataResponse=new MyIndexInfoViewDataResponse(statusResponseJson,
				ConsumeViewName.MY_INDEX_INFO_VIEW.consumeViewName, SystemParam.VIEW_GROUP, myIndexInfoViewDataBean, additionLocationIndex);
		return myIndexInfoViewDataResponse;
	}
	
	public static MyMenuFunctionViewDataResponse createMyMenuFunctionViewDataResponse(MyMenuFunctionListDataBean myMenuFunctionListDataBean,int additionLocationIndex) {
		StatusResponseJson statusResponseJson=new StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL);
		MyMenuFunctionViewDataResponse myMenuFunctionViewDataResponse=new MyMenuFunctionViewDataResponse(statusResponseJson,
				ConsumeViewName.MY_MENU_FUNCTION_LIST.consumeViewName, SystemParam.VIEW_GROUP, additionLocationIndex, myMenuFunctionListDataBean);
		return myMenuFunctionViewDataResponse;
	}
	
	public static PhoneDisplayViewDataResponse createPhoneDisplayViewDataResponse(PhoneDisplayViewDataBean phoneDisplayViewDataBean,int additionLocationIndex) {
		StatusResponseJson statusResponseJson=new StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL);
		PhoneDisplayViewDataResponse phoneDisplayViewDataResponse=new PhoneDisplayViewDataResponse(statusResponseJson,
				ConsumeViewName.PHONE_DISPLAY_VIEW.consumeViewName, SystemParam.VIEW_GROUP, phoneDisplayViewDataBean, additionLocationIndex);
		return phoneDisplayViewDataResponse;
	}
	
	public static PhoneSaleViewDataResponse createPhoneSaleViewDataResponse(PhoneSaleViewDataBean phoneSaleViewDataBean,int additionLocationIndex) {
		StatusResponseJson statusResponseJson=new StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL);
		PhoneSaleViewDataResponse phoneSaleViewDataResponse=new PhoneSaleViewDataResponse(statusResponseJson, 
				ConsumeViewName.PHONE_SALE_VIEW.consumeViewName, SystemParam.VIEW_GROUP, phoneSaleViewDataBean, additionLocationIndex);
		return phoneSaleViewDataResponse;
	}
	
	public static SetmealViewDataResponse createSetmealViewDataResponse(SetmealViewDataBean setmealViewDataBean,int additionLocationIndex) {
		StatusResponseJson statusResponseJson=new StatusResponseJson(StatusResponseJson.DATA_RESPONSE_SUCESSFUL);
		SetmealViewDataResponse setmealViewDataResponse=new SetmealViewDataResponse(statusResponseJson,
				ConsumeViewName.SETMEAL_VIEW.consumeViewName, SystemParam.VIEW_GROUP,additionLocationIndex, setmealViewDataBean);
		return setmealViewDataResponse;
	}
	
	
	
	
	
}

