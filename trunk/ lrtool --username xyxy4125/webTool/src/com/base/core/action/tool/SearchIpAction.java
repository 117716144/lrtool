package com.base.core.action.tool;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import com.base.core.BaseAction;

@SuppressWarnings("serial")
public class SearchIpAction extends BaseAction {
	
	private String target;
	
	private String result;
	
	private String myIp;
	
	public String getMyIp() {
		return myIp;
	}

	public void setMyIp(String myIp) {
		this.myIp = myIp;
	}

	private String myPosition;
	
	public String getMyPosition() {
		return myPosition;
	}

	public void setMyPosition(String myPosition) {
		this.myPosition = myPosition;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String execute(){
		result =IPSeeker.getInstance().getAddress(target);
		return SUCCESS;
	}
	
	public String input(){
		myIp =getIpAddr(this.getRequest());
		myPosition =IPSeeker.getInstance().getAddress(myIp);
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
	
	public String getOsInfo(HttpServletRequest request){
		String Agent = request.getHeader("User-Agent");
		StringTokenizer st = new StringTokenizer(Agent,";");
		st.nextToken();
		//得到用户的浏览器名
		String userbrowser = st.nextToken();
		//得到用户的操作系统名
		String useros = st.nextToken();
		return useros+"  "+userbrowser;
	}

}
