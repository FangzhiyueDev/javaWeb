package com.fang.rice.dbController;

import java.util.List;

import com.fang.rice.controll.PhoneProductSalePageAction.PhoneFilterCondition;
import com.fang.rice.model.PhoneData;
import com.xiaofangfang.rice.model.Phone;

/**
 * 定义了手机的相关数据库操作的集合
 * @author fang
 *
 */
public interface PhoneOpration {

	List<Phone> getPhone(PhoneFilterCondition phoneFilterCondition);

	/**
	 * 获得手机的品牌类型
	 * @return
	 */
	List<String> getPhoneBrandType();
	
	
   /**
    * 获得Phone的详细的信息
    */
	PhoneData getPhoneDetailInfo(int phoneId);

List<String> getPhoneColor(int phoneId);

List<String> getStrangCapacity(int phoneId);

List<String> getSetmeal(int phoneId);
}

