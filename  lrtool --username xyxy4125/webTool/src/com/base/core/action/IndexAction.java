package com.base.core.action;


import java.io.PrintWriter;

import com.base.core.BaseAction;

@SuppressWarnings("serial")
public class IndexAction extends BaseAction{
	
	private String indexFlag="";
	
	public String getIndexFlag() {
		return indexFlag;
	}

	public void setIndexFlag(String indexFlag) {
		this.indexFlag = indexFlag;
	}

	public String execute(){
		//this.getIpInfo();
		indexFlag = "Y";
		return SUCCESS;
	}
	
	public String tools(){
		return "tools";
	}
	
	public String ipInfo(){
		try{
		this.getResponse().setCharacterEncoding("UTF-8");
		PrintWriter out =this.getResponse().getWriter();
		out.write(this.getIpAddr()+"_split_"+this.getIpLocation());
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
