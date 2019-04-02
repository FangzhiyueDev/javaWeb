package com.fang.rice.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fang.rice.dbHelper.DbHelper;
import com.fang.rice.model.City;
import com.fang.rice.model.Province;

/**
 * 城市的数据处理与控制
 * @author fang
 *
 */
public class LocationDbController {
		
	public boolean insertProvince(Province province) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
	    boolean isSucessful = true;
		try {
			ps=connection.prepareStatement("insert into province(provinceCode,privinceName) values(?,?)");
			ps.setInt(1, province.getProvinceId());
			ps.setString(2, province.getName());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			isSucessful=false;
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return isSucessful;
	}
	
	
	public boolean insertCityInfo(City city) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
	    boolean isSucessful = true;
		try {
			ps=connection.prepareStatement("insert into city(cityCode,provinceCode,cityName) values(?,?,?)");
			ps.setInt(1, city.getCityId());
			ps.setInt(2, city.getProvinceId());
			ps.setString(3, city.getName());
			ps.executeUpdate();
		}catch(Exception e) {
			isSucessful=false;
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return isSucessful;
	}
	
	
     public Province getProvinceForCityId(int cityId) {
    		Connection connection;
    		PreparedStatement ps = null;
    		ResultSet resultSet = null;
    		connection=DbHelper.initDB();
    	    Province province=new Province();
    		try {
    			
    			ps=connection.prepareStatement(
    					"select provinceCode from city where  cityCode=?");
    			ps.setInt(1,cityId);
    			resultSet=ps.executeQuery();
    			while(resultSet.next()) {
    				 int provinceId=resultSet.getInt(1);
    				province.setProvinceId(provinceId);
    			}
    			
    		}catch (Exception e) {
			e.printStackTrace();
			}finally {
				DbHelper.closeDb(connection, ps, resultSet);
			}
		return province; 
    }
	
	
	
	
	
	
	
	
}
