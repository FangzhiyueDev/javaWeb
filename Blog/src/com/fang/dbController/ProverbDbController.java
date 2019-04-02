package com.fang.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.omg.PortableServer.POA;

import com.fang.dao.DbHelper;
import com.fang.model.Proverb;

public class ProverbDbController implements ProverbOpration {
	
	
	public static final String PROVERB_TABLE="proverb";
	
	private  ProverbDbController() {
	
	}
	
	private static ProverbOpration po;
	
	public static ProverbOpration getInstance() {
		if(po==null) {
			po=new ProverbDbController();
		}
		return po;	
	}
	
	

	@Override
	public int addProverb(Proverb proverb) {
		
		
		
		return 0;
	}

	@Override
	public int delProverb(Proverb proverb) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delAllProverb() {
		
		
		
		return 0;
	}

	@Override
	public List<?> queryAllProverb() {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Proverb> proverbs = null;
		try {
			ps=connection.prepareStatement("select publishTime,content,authorid,proverbid from "+PROVERB_TABLE);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String publishTime=resultSet.getString(1);
				String content =resultSet.getString(2);
				int authorid=resultSet.getInt(3);
				int proverbid=resultSet.getInt(4);
				proverbs.add(new Proverb(publishTime, content, authorid, proverbid));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return proverbs;
	}

	/**
	 *@param startPage 开始的页面 使用当前天数/365* proverbCount 
	 *@param size 默认为2 ，代表的是返回的大小
	 */
	@Override
	public List<?> queryProverb(int startPage, int size) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Proverb> proverbs = new ArrayList<>();
		try {
			ps=connection.prepareStatement("select publishTime,content,authorid,proverbid from "+PROVERB_TABLE+""
					+ " limit "+startPage+","+size);
			resultSet=ps.executeQuery();
	        resultSet=ps.executeQuery();
	      while(resultSet.next()) {
	    		String publishTime=resultSet.getString(1);
				String content =resultSet.getString(2);
				int authorid=resultSet.getInt(3);
				int proverbid=resultSet.getInt(4);
				proverbs.add(new Proverb(publishTime, content, authorid, proverbid));
	      }
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return proverbs;
	}




	@Override
	public List<?> queryNowProverb(int size) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Proverb> proverbs = new ArrayList<>();
		int count = 0;
		try {
			ps= connection.prepareStatement("select publishTime,content,authorid,proverbid from proverb order by proverbid desc limit ?");
			ps.setInt(1, size);
			resultSet=ps.executeQuery();
			  while(resultSet.next()) {
		    		String publishTime=resultSet.getString(1);
					String content =resultSet.getString(2);
					int authorid=resultSet.getInt(3);
					int proverbid=resultSet.getInt(4);
					proverbs.add(new Proverb(publishTime, content, authorid, proverbid));
		      }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return proverbs;
	}
	
	

}
