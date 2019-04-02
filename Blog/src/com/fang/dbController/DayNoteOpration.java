package com.fang.dbController;

import java.util.List;

import com.fang.model.DayNote;

/**
 * 日志操作的接口
 * @author fang
 *
 */
public interface DayNoteOpration {
	
	/**
	 * 获得数据
	 * @param size
	 * @return
	 */
	List<DayNote> getDayNoteBySize(int size);
	
	
	/**
	 * 删除部分的数据
	 */
	boolean delDayNoteByPublishTime(DayNote dayNote);
	
	/**
	 * 添加一条数剧
	 */
	boolean addDayNote(DayNote dayNote);
	
}
