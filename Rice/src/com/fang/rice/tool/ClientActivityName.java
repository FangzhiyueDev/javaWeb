package com.fang.rice.tool;


/**
 * 客户端的Activity的映射
 * @author fang
 *
 */
public enum ClientActivityName {
	
	ApplyAccountActivity("ApplyAccountActivity"),
	BannerFlipperActivity("BannerFlipperActivity"),
	BroadbandServiceActivity("BroadbandServiceActivity"),
	CarryingNumberToNetworkActivity("CarryingNumberToNetworkActivity"),
	CommunicationGuidanceActivity("CommunicationGuidanceActivity"),
	EnterpriseServiceActivity("EnterpriseServiceActivity"),
	FixedLineServiceActivity("FixedLineServiceActivity"),
	FlowHandleActivity("FlowHandleActivity"),
	LiangHaoActivity("LiangHaoActivity"),
	LogisticsQueryActivity("LogisticsQueryActivity"),
	ProductSalePageActivity("ProductSalePageActivity"),
	PublishSecondHandPhoneActivity("PublishSecondHandPhoneActivity"),
	PurchasedBabyActivity("PurchasedBabyActivity"),
	QueryBillActivity("QueryBillActivity"),
	RecentDiscountActivity("RecentDiscountActivity"),
	RegisterVipActivity("RegisterVipActivity"),
	ServiceEvaluationActivity("ServiceEvaluationActivity"),
	SetmealChangeActivity("SetmealChangeActivity"),
	ActionHorizontalActivity("ActionHorizontalActivity"),
	PhoneDetainPageActivity("PhoneDetainPageActivity"),
	LiangHaoDetailPageActivity("LiangHaoDetailPageActivity"),
	CardDetailActivity("CardDetailActivity"),
	SelfDetailInfoActivity("SelfDetailInfoActivity"),
	SystemSettingActivity("SystemSettingActivity"),
	FlowInfoRecordActivity("FlowInfoRecordActivity"),
	TelephoneConsultationActivity("TelephoneConsultationActivity");
	
	public String activityName;
	
	private ClientActivityName(String activityName) {
		this.activityName=activityName;
	}
	
	
}
