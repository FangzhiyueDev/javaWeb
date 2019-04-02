package com.fang.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.dao.DbHelper;
import com.fang.model.DayNote;

/**
 * DayNote的控制对象，实现对数据的填充
 * @author fang
 *
 */
public class DayNoteDbController implements DayNoteOpration {
	
private DayNoteDbController() {
		
	}
	
	public static DayNoteOpration getInstance() {
		if(dno==null) {
			dno=new DayNoteDbController();
		}
		return dno;
	}
	
	public static DayNoteOpration dno;

	/**
	 * 获得指定大小的DayNote的数据
	 * ,如果size传递-1，代表的是获得所有的数据，反之返回指定大小的数剧
	 */
	@Override
	public List<DayNote> getDayNoteBySize(int size) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<DayNote> dayNotes=new ArrayList<>();
		try {
			if(size==-1) {
			ps=connection.prepareStatement("select content,publishTime,authorid from dayNote");
			}else {
				ps=connection.prepareStatement("select content,publishTime,authorid from dayNote"
						+ " limit ?");
				ps.setInt(1, size);
			}
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String content=resultSet.getString(1);
				String publishTime=resultSet.getString(2);
				int authorid=resultSet.getInt(3);
				dayNotes.add(new DayNote(content, publishTime, authorid));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return dayNotes;
	}

	@Override
	public boolean delDayNoteByPublishTime(DayNote dayNote) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addDayNote(DayNote dayNote) {
		// TODO Auto-generated method stub
		return false;
	}
}
