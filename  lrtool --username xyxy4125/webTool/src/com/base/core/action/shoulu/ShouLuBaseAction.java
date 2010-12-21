package com.base.core.action.shoulu;

import com.base.core.BaseAction;

/**
 * @author XIEYING
 * 
 */
@SuppressWarnings("serial")
public class ShouLuBaseAction extends BaseAction{

	protected String shoulu_domain="";

	public String getShoulu_domain() {
		return shoulu_domain.replace("http://", "");
	}

	public void setShoulu_domain(String shouluDomain) {
		shoulu_domain = shouluDomain;
	}
	
	protected String shoulu_result="";

	public String getShoulu_result() {
		return shoulu_result;
	}

	public void setShoulu_result(String shouluResult) {
		shoulu_result = shouluResult;
	}
	
	protected String executeTime="";
	
	protected String targetUrl="";

	public String getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(String executeTime) {
		this.executeTime = executeTime;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	
	
	
}