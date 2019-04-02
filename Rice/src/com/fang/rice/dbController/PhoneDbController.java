package com.fang.rice.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.rice.controll.PhoneProductSalePageAction.PhoneFilterCondition;
import com.fang.rice.dbHelper.DbHelper;
import com.fang.rice.model.PhoneData;
import com.xiaofangfang.rice.model.Phone;

/**
 * 手机的具体的查询数据的类，属于持久层的数据
 * @author fang
 *
 */
public class PhoneDbController implements PhoneOpration {

	/**
	 * 这个方法查询的数据是用于显示listVIew进行显示的view，
	 * 粗略图iamge   phoneDestribute(手机的saleTtile)   networkType cardType  systemOprate action price
	 * 
	 */
	@Override
	public List<Phone> getPhone(PhoneFilterCondition phoneFilterCondition) {
		
		String cardType=phoneFilterCondition.getCardType();
		String brand=phoneFilterCondition.getBrand();
		int startPrice=phoneFilterCondition.getStartPrice();
		int endPrice=phoneFilterCondition.getEndPrice();
		
		
		int size=phoneFilterCondition.getSize();
		int page=phoneFilterCondition.getPage();
		String networkType=phoneFilterCondition.getNetworkType();
		boolean isPriceSortAsc=phoneFilterCondition.isPriceSortAsc();
		boolean isSaleSortAsc=phoneFilterCondition.isSaleSortAsc();
		
		List<String> sortList=new ArrayList<>();
		StringBuilder sort=new StringBuilder();
		if(isPriceSortAsc) {
			sortList.add("price desc");
		}else {
			sortList.add("price asc");
		}
		if(isSaleSortAsc) {//如果是降序
			sortList.add("saleCount desc");
		}else {//反之不是降序
			sortList.add("saleCount asc");
		}
		
		for(int i=0;i<sortList.size();i++) {
			if(i==sortList.size()-1) {
				sort.append(sortList.get(i));
			}else {
				sort.append(sortList.get(i)).append(",");
			}
		}
		
		StringBuilder stringBuilder=new StringBuilder();
		List<String> strings=new ArrayList<>();
		if(brand!=null) {
			strings.add("brand='"+brand+"'");
		}
		if(startPrice!=-1) {
			strings.add("price >"+startPrice);
		}
		if(endPrice!=-1) {
			strings.add("price <"+endPrice);
		}
		if(cardType!=null) {
			strings.add("cardType='"+cardType+"'");
		}
		if(networkType!=null) {
			strings.add("networkType='"+networkType+"'");
		}
		if(strings.size()>0) {
			stringBuilder.append("where ");
		}
		for(int i=0;i<strings.size();i++) {
			if(i==strings.size()-1) {
				stringBuilder.append(strings.get(i));
			}else {
				stringBuilder.append(strings.get(i)).append(" and ");
			}
		}
	
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Phone> phones=new ArrayList<>();
		try {
			String condition="select phoneId,roughIMageAddress,salePhoneTitle,networkType,cardType,systemOprate,action,price\n" + 
				"from phone "
		            +stringBuilder
					+" order by "+sort
					+" limit "+(page*size)+","+size;
					System.out.println("url= "+condition);
			ps=connection.prepareStatement(condition);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				int phoneId=resultSet.getInt(1);
				String roughImageAddress=resultSet.getString(2);
			    String salePhoneTitle=resultSet.getString(3);
			    String networkType1=resultSet.getString(4);
			    String cardType1=resultSet.getString(5);
			    String systemOprate=resultSet.getString(6);
			    String action=resultSet.getString(7);
			    int price=resultSet.getInt(8);
			    phones.add(new Phone(phoneId,roughImageAddress, salePhoneTitle, networkType1, cardType1, systemOprate, action,price));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return phones;
	}

	@Override
	public List<String> getPhoneBrandType() {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<String> phoneBrandType=new ArrayList<>();
		try {
			String condition="select  brand from phone group by brand";
			ps=connection.prepareStatement(condition);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String brand=resultSet.getString(1);
		      phoneBrandType.add(brand);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return phoneBrandType;
	}

	/**
	 * 获得手机的详细信息
	 */
	@Override
	public PhoneData getPhoneDetailInfo(int phoneId) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<String> images=new ArrayList<>();
		
		PhoneData data=null;
		Phone phone = null;
		try {
			ps=connection.prepareStatement("select phone.*,\n" + 
					"       phoneDetailImage.image1,\n" + 
					"       phoneDetailImage.image2,\n" + 
					"       phoneDetailImage.image3,\n" + 
					"       phoneDetailImage.image4,\n" + 
					"       phoneDetailImage.image5,\n" + 
					"       phoneDetailImage.image6,\n" + 
					"       phoneDetailImage.image7,\n" + 
					"       phoneDetailImage.image8,\n" + 
					"       phoneDetailImage.image9,\n" + 
					"       phoneDetailImage.image10\n" + 
					"\n" + 
					"from phone\n" + 
					"       left join phoneDetailImage on phone.phoneId = phoneDetailImage.phoneId\n" + 
					"where phone.phoneId = ?\n" + 
					"");
			ps.setInt(1, phoneId);
			resultSet=ps.executeQuery();
			       while(resultSet.next()) {
			        int cityCode =resultSet.getInt(2);
					String name =resultSet.getString(3);
					String brand =resultSet.getString(4);
					int price =resultSet.getInt(5);
					String salePhoneTitle =resultSet.getString(6);
					String action =resultSet.getString(7);
					String networkType =resultSet.getString(8);
					String cardType =resultSet.getString(9);
					String roughIMageAddress=resultSet.getString(10);
					String image1Address =resultSet.getString(11);
					String image2Address=resultSet.getString(12);
					String image3Address=resultSet.getString(13);
					String image4Address=resultSet.getString(14);
					String image5Address=resultSet.getString(15);
					String screenDimension=resultSet.getString(16);
					String powerCapacity=resultSet.getString(17);
					String tnickness=resultSet.getString(18);
					int saleCount=resultSet.getInt(19);
					String discount=resultSet.getString(20);
					String systemOprate=resultSet.getString(21);
					images.add(image1Address);
					images.add(image2Address);
					images.add(image3Address);
					images.add(image4Address);
					images.add(image5Address);
					phone=new Phone(phoneId, cityCode, name, brand, price, salePhoneTitle, action, networkType,
							cardType, images, screenDimension, powerCapacity, tnickness, saleCount, discount, systemOprate);
				
					List<String> phoneDetailImageAddress=new ArrayList<>();
					
					for(int i=22;i<=31;i++) {
						String detailImage=resultSet.getString(i);
						phoneDetailImageAddress.add(detailImage);
					}
					
					data=new PhoneData(phone, null, null, null, phoneDetailImageAddress);
					
			       }
					
					
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		
		return data;
	}

	@Override
	public List<String> getPhoneColor(int phoneId) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<String> colors=new ArrayList<>();
		try {
			ps=connection.prepareStatement("select color\n" + 
					"from phoneColor\n" + 
					"where phoneId = ?");
			ps.setInt(1, phoneId);
			resultSet=ps.executeQuery();
		while(resultSet.next()) {
			String color=resultSet.getString(1);
		   colors.add(color);
		  }
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return colors;
	}

	@Override
	public List<String> getStrangCapacity(int phoneId) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<String> strangeCapacity=new ArrayList<>();
		try {
			ps=connection.prepareStatement("select describute\n" + 
					"from phoneStrangCapacity\n" + 
					"where phoneId = ?");
			ps.setInt(1, phoneId);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String describute=resultSet.getString(1);
				strangeCapacity.add(describute);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return strangeCapacity;
	}

	@Override
	public List<String> getSetmeal(int phoneId) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<String> setmeals=new ArrayList<>();
		try {
			ps=connection.prepareStatement("select setmealName\n" + 
					"from phoneSetmeal\n" + 
					"where phoneId = ?");
			ps.setInt(1, phoneId);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String setmeal=resultSet.getString(1);
				setmeals.add(setmeal);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return setmeals;
	}

}
