package com.base.core.action.shoulu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class SosoShouLuAction extends ShouLuBaseAction{
	
	public String execute(){
		String url ="http://www.soso.com/q?w=site%3A"+this.getShoulu_domain();
		return this.executeResponse(url,"gb2312");
    }
	
	public String link(){
		String url ="http://www.soso.com/q?w=link%3A"+this.getShoulu_domain();
		return this.executeResponse(url,"gb2312");
    }
	
	protected void getResult(String sbf) {
		Pattern pattern = Pattern.compile("(.*)搜索到约(.*)项结果(.*)");
        Matcher matcher =pattern.matcher(sbf.toString());
        if(matcher.find()){
        	shoulu_result =matcher.group(2).toString().replaceAll("\\,", "").replaceAll("\\，", "").trim();
        }
	}

}
