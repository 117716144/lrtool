package com.base.core.action.shoulu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class YahooShouLuAction extends ShouLuBaseAction{
	
	public String execute(){
		String url ="http://sitemap.cn.yahoo.com/search?bwm=p&p="+this.getShoulu_domain();
		return this.executeResponse(url,"utf-8");
	}	
        
	public String link(){
		String url ="http://sitemap.cn.yahoo.com/search?bwm=i&p="+this.getShoulu_domain();
		return this.executeResponse(url,"utf-8");
	}
	
	protected void getResult(String sbf) {
		//(.*)被收录的网页： 共(.*)条  当前显示(.*)
		Pattern pattern = Pattern.compile("(.*)的网页： 共(.*)条  当前显示(.*)");
        Matcher matcher =pattern.matcher(sbf.toString());
        if(matcher.find()){
        	shoulu_result =matcher.group(2).toString().replaceAll("\\,", "").replaceAll("\\，", "").trim();
        	shoulu_result =shoulu_result.replaceAll("\\<strong>", "").replaceAll("\\</strong>", "");
        }else{
        	shoulu_result ="-";
        }
	}

}
