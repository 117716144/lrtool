package com.base.core.action.shoulu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class BaiduShouLuAction extends ShouLuBaseAction{
	
	public String execute(){
	    String url ="http://www.baidu.com/s?wd=site%3A"+this.getShoulu_domain();
	    return this.executeResponse(url,"gb2312");
    }
	
	public String link(){
	    String url ="http://www.baidu.com/s?wd=link%3A"+this.getShoulu_domain();
        return this.executeResponse(url,"gb2312");
	}
	
	
	
	//取相关数字
	protected void getResult(String sbf){
		//(.*)找到相关网页约(.*)篇，用时(.*)秒(.*)
		Pattern pattern = Pattern.compile("(.*)找到相关网页约(.*)篇，用时(.*)");
        Matcher matcher =pattern.matcher(sbf.toString());
        if(matcher.find()){
        	shoulu_result =matcher.group(2).toString().replaceAll("\\,", "").replaceAll("\\，", "").trim();
        }
//        pattern = Pattern.compile("(.*)用时(.*)秒(.*)");
//        matcher =pattern.matcher(sbf.toString());
//        if(matcher.find()){
//        	this.setExecuteTime(matcher.group(2).toString());
//        }
        
	}

}
