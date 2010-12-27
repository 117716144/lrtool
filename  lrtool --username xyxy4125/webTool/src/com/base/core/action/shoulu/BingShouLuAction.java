package com.base.core.action.shoulu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SuppressWarnings("serial")
public class BingShouLuAction extends ShouLuBaseAction{

	public String execute(){
	    String url ="http://cn.bing.com/search?q=site%3A"+this.getShoulu_domain();
	    return this.executeResponse(url,"utf-8");
    }
	
	public String link(){
	    String url ="http://cn.bing.com/search?q=link%3A"+this.getShoulu_domain();
	    return this.executeResponse(url,"utf-8");
    }
	
	
	//取相关数字
	protected void getResult(String sbf){
        Pattern pattern = Pattern.compile("(.*)条结果\\(共(.*)条\\)(.*)");
        Matcher matcher =pattern.matcher(sbf.toString());
        if(matcher.find()){
        	shoulu_result =matcher.group(2).toString().replaceAll("\\,", "").replaceAll("\\，", "").trim();
        }
	}

}
