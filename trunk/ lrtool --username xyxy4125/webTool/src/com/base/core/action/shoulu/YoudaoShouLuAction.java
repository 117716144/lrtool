package com.base.core.action.shoulu;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.base.core.util.StringUtil;


@SuppressWarnings("serial")
public class YoudaoShouLuAction extends ShouLuBaseAction{
	
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
		String url ="http://www.youdao.com/search?q=site%3A"+this.getShoulu_domain();
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
		String url ="http://www.youdao.com/search?q=link%3A"+this.getShoulu_domain();
		return this.executeResponse(url,"utf-8");
    }
	
	protected void getResult(String sbf) {
		 Pattern pattern = Pattern.compile("(.*)共(.*)条结果(.*)");
         Matcher matcher =pattern.matcher(sbf.toString());
         if(matcher.find()){
         	shoulu_result =matcher.group(2).toString().replaceAll("\\,", "").replaceAll("\\，", "").trim();
         }else{
         	shoulu_result ="-";
         }
	}

}
