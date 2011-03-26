package com.base.core.action.shoulu;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.base.core.util.StringUtil;


@SuppressWarnings("serial")
public class SogouShouLuAction extends ShouLuBaseAction{
	
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
	    String url ="http://www.sogou.com/web?query=site%3A"+this.getShoulu_domain();
	    return this.executeResponse(url,"gb2312");
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
	    String url ="http://www.sogou.com/web?query=link%3A"+this.getShoulu_domain();
	    return this.executeResponse(url,"gb2312");
    }
	
	protected void getResult(String sbf) {
		Pattern pattern = Pattern.compile("(.*)找到(.*)个网页(.*)");
		Matcher matcher = pattern.matcher(sbf.toString());
		if (matcher.find()) {
			shoulu_result = matcher.group(2).toString().replaceAll("\\,", "")
					.replaceAll("\\，", "").trim();
			if (shoulu_result.indexOf("<!-") != -1) {
				shoulu_result = shoulu_result.substring(0, shoulu_result
						.indexOf("<!-"));
			}else{
	        	shoulu_result ="-";
	        }
		}else{
        	shoulu_result ="-";
        }
	}
}