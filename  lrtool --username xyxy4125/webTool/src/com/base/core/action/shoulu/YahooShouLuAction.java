package com.base.core.action.shoulu;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.base.core.util.StringUtil;

@SuppressWarnings("serial")
public class YahooShouLuAction extends ShouLuBaseAction{
	
	public String execute(){
		if(StringUtil.isEmpty(this.getShoulu_domain())){
			this.getResponse().setCharacterEncoding("utf-8");
			this.getResponse().setContentType("text/x-json;charset=UTF-8");
			try {
				this.getResponse().getWriter().write("-");
				this.getResponse().getWriter().close();
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		String url ="http://sitemap.cn.yahoo.com/search?bwm=p&p="+this.getShoulu_domain();
		return this.executeResponse(url,"utf-8");
	}	
        
	public String link(){
		if(StringUtil.isEmpty(this.getShoulu_domain())){
			this.getResponse().setCharacterEncoding("utf-8");
			this.getResponse().setContentType("text/x-json;charset=UTF-8");
			try {
				this.getResponse().getWriter().write("-");
				this.getResponse().getWriter().close();
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
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
