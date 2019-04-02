package com.fang.rice.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.rice.controll.HandPhoneProductSalePageAction.HandPhoneFilterCondition;
import com.fang.rice.dbHelper.DbHelper;
import com.fang.rice.model.SecondHandPhone;
import com.fang.rice.model.Type;

/**
 * 二手手机的数据的数据库操作类
 * @author fang
 *
 */
public class SecondHandPhoneDbController implements SecondHandPhoneOpration{

	
	
	@Override
	public List<SecondHandPhone> getHandPhoneList(HandPhoneFilterCondition handPhoneFilterCondition) {
	    
		int cityId=handPhoneFilterCondition.getCityId();
		int page=handPhoneFilterCondition.getPage();
		int size=handPhoneFilterCondition.getSize();
		boolean priceSortAsc=handPhoneFilterCondition.isPriceSortAsc();
		String condition;
		if(priceSortAsc) {//如果是降序
			condition="order by price desc\n";
		}else {//反之升序
			condition="order by price asc\n";
		}
		
		String sql="select secondHandPhoneId, desctribute, price, User.nikeName, howManyNow, User.userImage,imageAddress1\n" + 
				"from secondHandPhone\n" + 
				"       join User on secondHandPhone.userid = User.telNumber\n" + 
				"where secondHandPhone.publishAddress = (select cityName from city where cityCode = ?)\n"
				+condition
				+"limit "+(page*size)+","+size;
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<SecondHandPhone> secondHandPhones=new ArrayList<>();
		try {
			ps=connection.prepareStatement(sql);
			ps.setInt(1, cityId);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				int secondHandPhoneId=resultSet.getInt(1);
				String destribute=resultSet.getString(2);
				int price=resultSet.getInt(3);
				String nikeName=resultSet.getString(4);
				String howManyNow=resultSet.getString(5);
				String userImage=resultSet.getString(6);
				String imageAddress1=resultSet.getString(7);
				List<String> imageAddresss=new ArrayList<>();
				imageAddresss.add(imageAddress1);
				secondHandPhones.add(new SecondHandPhone(secondHandPhoneId, destribute, price, nikeName, howManyNow, userImage,imageAddresss));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return secondHandPhones;
	}

	
	
	@Override
	public SecondHandPhone getHandPhoneDetailForId(int handPhoneId) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		SecondHandPhone secondHandPhone=null;
		try {
			ps=connection.prepareStatement("select nikeName, userImage, secondHandPhone.*\n" + 
					"from secondHandPhone\n" + 
					"       join User on secondHandPhone.userid = User.telNumber\n" + 
					"where secondHandPhoneId = ?");
		    ps.setInt(1, handPhoneId);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
			String nikeName=resultSet.getString(1);
			String userImage=resultSet.getString(2);
			int  secondHandPhoneId=resultSet.getInt(3);
			String userId=resultSet.getString(4);
			String destribute=resultSet.getString(5);
			int price=resultSet.getInt(6);
			String howManyNow=resultSet.getString(7);
			String publishAddress=resultSet.getString(8);
			String imageAddress1=resultSet.getString(9);
			String imageAddress2=resultSet.getString(10);
			String imageAddress3=resultSet.getString(11);
			String name=resultSet.getString(12);
			
			List<String> images=new ArrayList<>();
			images.add(imageAddress1);
			images.add(imageAddress2);
			images.add(imageAddress3);
			
			secondHandPhone=new SecondHandPhone(secondHandPhoneId, name, destribute, nikeName, userImage, publishAddress, images, price, howManyNow,userId);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return secondHandPhone;
	}
}

