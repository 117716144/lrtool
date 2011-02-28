package com.base.core.action;


import com.base.core.BaseAction;

@SuppressWarnings("serial")
public class IndexAction extends BaseAction{
	
	public String execute(){
		this.getIpInfo();
		return SUCCESS;
	}
	
}
