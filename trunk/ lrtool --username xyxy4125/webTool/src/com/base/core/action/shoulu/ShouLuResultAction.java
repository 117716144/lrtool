package com.base.core.action.shoulu;

@SuppressWarnings("serial")
public class ShouLuResultAction extends ShouLuBaseAction{

	private String googlecheck;
	
	private String baiducheck;
	
	private String yahoocheck;
	
	private String sosocheck;
	
	private String sogoucheck;
	
	private String youdaocheck;
	
	private String bingcheck;
	
	public String getGooglecheck() {
		return googlecheck;
	}

	public void setGooglecheck(String googlecheck) {
		this.googlecheck = googlecheck;
	}

	public String getBaiducheck() {
		return baiducheck;
	}

	public void setBaiducheck(String baiducheck) {
		this.baiducheck = baiducheck;
	}

	public String getYahoocheck() {
		return yahoocheck;
	}

	public void setYahoocheck(String yahoocheck) {
		this.yahoocheck = yahoocheck;
	}

	public String getSogoucheck() {
		return sogoucheck;
	}

	public void setSogoucheck(String sogoucheck) {
		this.sogoucheck = sogoucheck;
	}

	public String getSosocheck() {
		return sosocheck;
	}

	public void setSosocheck(String sosocheck) {
		this.sosocheck = sosocheck;
	}

	public String getYoudaocheck() {
		return youdaocheck;
	}

	public void setYoudaocheck(String youdaocheck) {
		this.youdaocheck = youdaocheck;
	}

	public String getBingcheck() {
		return bingcheck;
	}

	public void setBingcheck(String bingcheck) {
		this.bingcheck = bingcheck;
	}

	public String execute(){
		return SUCCESS;
	}
	
	//搜索引擎反向链接
    public String link(){
		return SUCCESS;
	}
}
