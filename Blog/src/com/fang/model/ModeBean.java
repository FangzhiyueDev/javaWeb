package com.fang.model;

import java.util.List;

//public static final String[] MODEL= {"文章管理","友链管理","图片管理","一言管理","视频管理"};
public class ModeBean {

	/**
	 * 
	ARTICLE_MANAGE("文章管理",new String[] {"文章管理","发布新文章"}),

	FRIENDLY_MANAGE("友链管理",new String[] {"友链管理","添加友链"}),

	PICTURE_MANAGE("图片管理",new String[] {"图片管理","添加图片"}),

	PROVERB_MANAGE("一言管理",new String[] {"一言管理","添加一言"}),

	VIDEO_MANAGE("视频管理",new String[] {"视频管理","上传视频"});
	 * @param modeName
	 * @param functions
	 */

	public ModeBean() {
		// TODO Auto-generated constructor stub
	}



	public ModeBean(String modeName, List<String> functions, List<String> importUrl) {
		super();
		this.modeName = modeName;
		this.functions = functions;
		this.importUrl = importUrl;
	}



	private String modeName;
	private List<String> functions;
	private List<String> importUrl;
	
	
	public List<String> getImportUrl() {
		return importUrl;
	}

	public void setImportUrl(List<String> importUrl) {
		this.importUrl = importUrl;
	}

	public String getModeName() {
		return modeName;
	}

	public void setModeName(String modeName) {
		this.modeName = modeName;
	}

	public List<String> getFunctions() {
		return functions;
	}

	public void setFunctions(List<String> functions) {
		this.functions = functions;
	}

}
