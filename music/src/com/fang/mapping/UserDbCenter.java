package com.fang.mapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.dao.DbHelper;
import com.fang.model.Album;
import com.fang.model.Singer;
import com.fang.modelWrapper.MusicWrapper;
public class UserDbCenter { 
	
	/**
	 * 用户登录检测
	 * @param user
	 * @param password
	 * @return
	 */
public boolean loginCheck(String user,String password) {
	
	   Connection connection =DbHelper.initDB();
	   PreparedStatement ps=null;
	   ResultSet resultSet=null;
	   int count = 0;
	   try {
		
		   ps=connection.prepareStatement("select count(*) from user where name=? and password=?");
		   ps.setString(1, user);
		   ps.setString(2, password);
		   resultSet=ps.executeQuery();
		   while(resultSet.next()) {
			   count=resultSet.getInt(1);
		   }
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		DbHelper.closeDb(connection, ps, resultSet);
	}
	return count==0?false:true;
   }

public List<MusicWrapper> getCollectionByUserName(String username) {

	   Connection connection =DbHelper.initDB();
	   PreparedStatement ps=null;
	   ResultSet resultSet=null;
	   List<MusicWrapper> musicWrappers=new ArrayList<>();
	   try {
		   
		   ps=connection.prepareStatement("\n" + 
		   		"select music.id,music.name, s.name, music.playTime, a.name,music.musicAddress\n" + 
		   		"from music\n" + 
		   		"       join singer s on music.singerId = s.Id\n" + 
		   		"       join album a on music.albumId = a.id\n" + 
		   		"where music.id in(select musicId from collection where userName = ?)");
		   
		   ps.setString(1, username);
		   resultSet=ps.executeQuery();
		   while(resultSet.next()) {
			   int id=resultSet.getInt(1);
			   String name=resultSet.getString(2);
			   String singerName=resultSet.getString(3);
			   String playTime=resultSet.getString(4);
			   String albumName=resultSet.getString(5);
			   String musicAddress=resultSet.getString(6);
			   musicWrappers.add(new MusicWrapper(id, singerName, playTime, name, null,albumName,musicAddress));
		   }
		  
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		DbHelper.closeDb(connection, ps, resultSet);
	}
	
	
	return musicWrappers;
}

/**
 * 获得推荐歌单
 * @return
 */
  public List<Album> getTuijianMusicMenu(String userName) {

	   Connection connection =DbHelper.initDB();
	   PreparedStatement ps=null;
	   ResultSet resultSet=null;
	   List<Album> albums=new ArrayList<>();
	   try {
		   ps=connection.prepareStatement("select *\n" + 
		   		"from album\n" + 
		   		"where id in(select albumId from music where id in(select musicId from collection where userName = ?))");
		   ps.setString(1, userName);
		   resultSet=ps.executeQuery();
		   while(resultSet.next()) {
			   int id=resultSet.getInt(1);
			   String name=resultSet.getString(2);
			   String image=resultSet.getString(3);
			   String author=resultSet.getString(4);
			   String type=resultSet.getString(5);
			   albums.add(new Album(id, name, image, author, type, 0));
		   }
		   
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
		DbHelper.closeDb(connection, ps, resultSet);
	  }
	return albums;
 }

  /**
   * 获得推荐列表
   * @return
   */
public List<MusicWrapper> getHotTuijianList(String userName) {

	   Connection connection =DbHelper.initDB();
	   PreparedStatement ps=null;
	   ResultSet resultSet=null;
	   List<MusicWrapper> musicWrappers=new ArrayList<>();
	   try {
		   ps=connection.prepareStatement("select music.id,music.name, s.name, music.playTime, a.name,music.musicAddress\n" + 
		   		"from music\n" + 
		   		"       join singer s on music.singerId = s.Id\n" + 
		   		"       join album a on music.albumId = a.id\n" + 
		   		"where albumId in(select albumId from music where id in(select musicId from collection where userName = ?))");
		   
		   ps.setString(1, userName);
		   resultSet=ps.executeQuery();
		   while(resultSet.next()) {
			   int id=resultSet.getInt(1);
			   String name=resultSet.getString(2);
			   String singerName=resultSet.getString(3);
			   String playTime=resultSet.getString(4);
			   String albumName=resultSet.getString(5);
			   String musicAddress=resultSet.getString(6);
			   musicWrappers.add(new MusicWrapper(id, singerName, playTime, name, null, albumName,musicAddress));
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
		DbHelper.closeDb(connection, ps, resultSet);
	  }
	return musicWrappers;
}

/**
 * 获得推荐歌手
 * @return
 */
public List<Singer> getTuijianSinger(String userName) {
	   Connection connection =DbHelper.initDB();
	   PreparedStatement ps=null;
	   ResultSet resultSet=null;
	   List<Singer> singers=new ArrayList<>();
	   try {
		   ps=connection.prepareStatement("select *\n" + 
		   		"from singer\n" + 
		   		"where id in(select singerId from music where id in(select musicId from collection where userName = ?))");
	   ps.setString(1, userName);
	   resultSet=ps.executeQuery();
	  
	   while(resultSet.next()) {
		   
		  int id=resultSet.getInt(1);
		  String name=resultSet.getString(2);
		  String destribute=resultSet.getString(3);
		  String image=resultSet.getString(4);
		  
		  singers.add(new Singer(id, name, destribute, image));  
	   }
	   
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
		DbHelper.closeDb(connection, ps, resultSet);
	  }
	return singers;

}








}
