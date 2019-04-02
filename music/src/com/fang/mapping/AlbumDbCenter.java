package com.fang.mapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.dao.DbHelper;
import com.fang.model.Album;
import com.fang.modelWrapper.MusicMenu;

public class AlbumDbCenter implements AlbumOprate {

	@Override
	public List<Album> getAllAlbumList() {
		
		   Connection connection =DbHelper.initDB();
		   PreparedStatement ps=null;
		   ResultSet resultSet=null;
		   List<Album> albums=new ArrayList<>();
		   try {
			   
			   ps=connection.prepareStatement("select *\n" + 
			   		"from album");
			   
			   resultSet=ps.executeQuery();
			   while(resultSet.next()) {
				   
				  int id=resultSet.getInt(1);
				  String name=resultSet.getString(2);
				  String image=resultSet.getString(3);
				  String author=resultSet.getString(4);
				  String type=resultSet.getString(5);
				  int playCount=resultSet.getInt(6);
				  
				  albums.add(new Album(id, name, image, author, type, playCount));  
				   
			   }

		   }catch (Exception e) {
			e.printStackTrace();
		}
		   
		return albums;
	}

}
