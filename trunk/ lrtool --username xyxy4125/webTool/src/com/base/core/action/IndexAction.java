package com.base.core.action;

import javax.servlet.http.HttpServletRequest;

import com.base.core.BaseAction;
import com.base.core.action.tool.IPSeeker;

@SuppressWarnings("serial")
public class IndexAction extends BaseAction{
	

	public String execute(){
		String ipAddr = this.getIpAddr(this.getRequest());
		String ipLocation =IPSeeker.getInstance().getAddress(ipAddr);
		this.setIpAddr(ipAddr);
		this.setIpLocation(ipLocation);
		return SUCCESS;
	}
	
	public String getIpAddr(HttpServletRequest request) {      
		String ip = request.getHeader("x-forwarded-for");      
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
		   ip = request.getHeader("Proxy-Client-IP");      
		}      
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
		ip = request.getHeader("WL-Proxy-Client-IP");      
		}      
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
		   ip = request.getRemoteAddr();      
		}      
		return ip;      
	} 

}
