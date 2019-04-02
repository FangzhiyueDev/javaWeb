package com.fang.mapping;

import java.util.List;

import com.fang.modelWrapper.MusicWrapper;

public interface MusicOprate {

	List<MusicWrapper> getMusicByClassId(String classfyName);
	
	
	MusicWrapper getMusicDetailInfo(int id);
	
}
