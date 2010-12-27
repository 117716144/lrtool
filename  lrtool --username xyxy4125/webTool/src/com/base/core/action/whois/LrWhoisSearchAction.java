package com.base.core.action.whois;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.base.core.BaseAction;
import com.base.core.util.StringUtil;

@SuppressWarnings("serial")
public class LrWhoisSearchAction extends BaseAction{
	
	private Log logger =LogFactory.getLog(this.getClass());
	
	private String domain ="";
	
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	private String searchResult="";

	public String getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(String searchResult) {
		this.searchResult = searchResult;
	}

	public String execute(){
	Long start =System.currentTimeMillis();
    URL url = null;
    HttpURLConnection httpConn = null;
    InputStream in = null;
    String cookie = "";
    if(StringUtil.isEmpty(this.getDomain())){
		addActionError("请先填写正确的域名或IP地址");
		return SUCCESS;
	}
    try
    {
        do {
        	url = new URL("http://www.whois365.com/cn/domain/"+this.getDomain());
            httpConn = (HttpURLConnection) url.openConnection();
            HttpURLConnection.setFollowRedirects(true);
            httpConn.setRequestMethod("GET"); 
            httpConn.setConnectTimeout(30000);
            httpConn.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)"); 
            if(cookie.length() != 0)
            	httpConn.setRequestProperty("Cookie", cookie);
            httpConn.setInstanceFollowRedirects(false);
            int code = httpConn.getResponseCode();
            if(code == HttpURLConnection.HTTP_MOVED_TEMP) {
                cookie += httpConn.getHeaderField("Set-Cookie") + ";";
            }
            if(httpConn.getResponseCode() == HttpURLConnection.HTTP_OK)
                break;
        } while(true);
        in = httpConn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));  
        String line = "";
        StringBuffer sbf = new StringBuffer();
        while((line = br.readLine()) != null) {  
          sbf.append(line); 
        }
        int startPos = sbf.toString().indexOf("<!-- domain info - int -->");
        int endPos = sbf.toString().indexOf("<!-- whois result - fin -->");
        searchResult =sbf.toString().substring(startPos,endPos);
        
        searchResult =searchResult.replaceAll("<div class=\"ad-right\"><a href=\"(.*)</a></div>","");

        Long end =System.currentTimeMillis();
        logger.info("总共用时："+(end-start)+"毫秒");
    }
    catch (MalformedURLException e)
    {
        e.printStackTrace();
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    finally
    {
        try
        {
            in.close();
            httpConn.disconnect();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    return SUCCESS;
	}
	
	public static void main(String[] args){
		new LrWhoisSearchAction().execute();
	}
	
	

}
