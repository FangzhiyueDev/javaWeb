package com.fang.rice.dbController;

import java.util.List;

import com.fang.rice.controll.HandPhoneProductSalePageAction.HandPhoneFilterCondition;
import com.fang.rice.model.SecondHandPhone;

public interface SecondHandPhoneOpration {
	
	/**
	 * 获得二手手机的信息显示   
	 * @param handPhoneFilterCondition 
	 * @return
	 */
	List<SecondHandPhone> getHandPhoneList(HandPhoneFilterCondition handPhoneFilterCondition);

	/**
	 * 获得手机的详情界面的显示
	 * @param handPhoneId
	 * @return
	 */
	SecondHandPhone getHandPhoneDetailForId(int handPhoneId);
	

}
