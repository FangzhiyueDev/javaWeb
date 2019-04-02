package com.fang.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.dao.DbHelper;
import com.fang.model.VideoWatch;
import com.fang.model.ReuniteModel.ArticleCorrespondReadCount;
import com.fang.model.ReuniteModel.VideoCorrespondWatchCount;

public class VideoWatchDbController implements VideoWatchOpration {

	
   private VideoWatchDbController() {
		
	}
	
	/**
	 * 获得实例
	 * @return
	 */
	public  static VideoWatchOpration getInstance() {
		
		if(vwo==null) {
			vwo=new VideoWatchDbController();
		}
		return vwo;
	}
	
	private static VideoWatchOpration vwo;
	
	
	public static void main(String[] args) {
		List<VideoCorrespondWatchCount> watchCounts=VideoWatchDbController.getInstance().getVideoWatch(6);
		for(VideoCorrespondWatchCount count:watchCounts) {
			System.out.println(count.getCount());
			System.out.println(count.getVideoAddress());
		}
	}
	
	/**
	 * 获得文章的阅读数
	 */
	@Override
	public List<VideoCorrespondWatchCount> getVideoWatch(int size) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		/**
select articlePublishTime,count(articlePublishTime) 
from readRecords 
group by articlePublishTime
limit 6;
		 */
		List<VideoCorrespondWatchCount> watchCounts=new ArrayList<>();
		try {
			ps=connection.prepareStatement("select videoAddress,count(videoAddress)"
					+ " from videoWatch"
					+ " group by videoAddress"
					+ " order by count(videoAddress) desc"
					+ "	limit ?");
			ps.setInt(1, size);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String videoAddress=resultSet.getString(1);
				int count=resultSet.getInt(2);
				//文章名称为空
				watchCounts.add(new VideoCorrespondWatchCount(videoAddress,null, count));
			}
		}catch(Exception e) {
			e.printStackTrace();
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return watchCounts;
	}

	/**
	 * 
	 */
	@Override
	public int getVideoWatchCount(String videoAddress) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		int count=0;
		try {
			ps=connection.prepareStatement("select count(videoAddress) from videoWatch where videoAddress=?");
			ps.setString(1, videoAddress);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				count=resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return count;
	}

	/**
	 * 
	 */
	@Override
	public boolean addNowWatchRecord(VideoWatch videoWatch) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		boolean sucessful=true;
		try {
			ps=connection.prepareStatement("insert into videoWatch(userid,videoAddress,watchTime) values(?,?,?)");
			ps.setInt(1, videoWatch.getUserid());
			ps.setString(2, videoWatch.getVideoAddress());
			ps.setString(3, videoWatch.getWatchTime());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			sucessful=false;
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return sucessful;
	}

}
