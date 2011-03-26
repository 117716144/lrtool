package com.base.core.action;


import java.io.PrintWriter;

import com.base.core.BaseAction;

@SuppressWarnings("serial")
public class IndexAction extends BaseAction{
	
	public String execute(){
		this.getIpInfo();
		return SUCCESS;
	}
	
	public String ipInfo(){
		try{
		this.getResponse().setCharacterEncoding("UTF-8");
		PrintWriter out =this.getResponse().getWriter();
		this.getIpInfo();
		out.write(this.getIpAddr()+"_split_"+this.getIpLocation());
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
