package com.fang.rice.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.rice.dbHelper.DbHelper;
import com.fang.rice.model.Bill;
import com.fang.rice.model.Card;

public class BillDbController {
	
	
	public boolean saveBill(Bill bill) {
		
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Card> cards=new ArrayList<Card>();
		connection=DbHelper.initDB();
		boolean isSuccess=true;
		try {
			ps=connection.prepareStatement("insert into bill(tel, name, address, cardId, date)\n" + 
					"values (?, ?, ?, ?, ?)");
			ps.setString(1, bill.getTel());
			ps.setString(2, bill.getName());
			ps.setString(3, bill.getAddress());
			ps.setInt(4, bill.getCardId());
			ps.setString(5, bill.getDate());
		    isSuccess=ps.executeUpdate()==-1?false:true;
			
		} catch (Exception e) {
			isSuccess=false;
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return isSuccess;
	}

}
