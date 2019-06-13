package com.fang.mapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.dao.DbHelper;
import com.fang.model.Music;
import com.fang.modelWrapper.MusicWrapper;

public class MusicDbCenter implements MusicOprate {

	@Override
	public List<MusicWrapper> getMusicByClassId(String classfyName) {

		Connection connection = DbHelper.initDB();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<MusicWrapper> musicWrappers = new ArrayList<>();
		try {

			String sql1 = "select music.id id, s.name singerName, music.name musicName, music.playTime playTime,c.image,music.musicAddress\n"
					+ "from music\n" + "       join singer s on music.singerId = s.id\n"
					+ "       join classfy c on music.classfyId = c.id\n" + "\n" + "where c.name = ?";

//			String sql = "select  * from music where classfyId= (\n" + "  select id\n" + "  from classfy\n"
//					+ "  where name = ?" + ")";

			ps = connection.prepareStatement(sql1);

			ps.setString(1, classfyName);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String singerName = resultSet.getString(2);
				String musicNmae = resultSet.getString(3);
				String playTime = resultSet.getString(4);
				String image = resultSet.getString(5);
				String musicAddress = resultSet.getString(6);
				musicWrappers.add(new MusicWrapper(musicAddress, id, singerName, playTime, musicNmae, image));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}

		return musicWrappers;
	}

	/**
	 * 获得音乐的具体的详细信息
	 */
	@Override
	public MusicWrapper getMusicDetailInfo(int id) {

		Connection connection = DbHelper.initDB();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		MusicWrapper musicWrapper = null;
		try {
			ps = connection.prepareStatement("select music.*, s.name singerName\n" + "from music\n"
					+ "       join singer s on music.singerId = s.id\n" + "where s.id = ?");
			ps.setInt(1, id);
			ps.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString(2);
				int albumId = resultSet.getInt(3);
				String image = resultSet.getString(4);
				int singerId = resultSet.getInt(5);
				String playTime = resultSet.getString(6);
				int playCount = resultSet.getInt(7);
				int classfyId = resultSet.getInt(8);
				String singerName = resultSet.getString(9);
				musicWrapper = new MusicWrapper(id, singerName, playTime, name, image);
				musicWrapper.setMusic(new Music(id, name, albumId, image, singerId, playTime, playCount, classfyId));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return musicWrapper;
	}

}
