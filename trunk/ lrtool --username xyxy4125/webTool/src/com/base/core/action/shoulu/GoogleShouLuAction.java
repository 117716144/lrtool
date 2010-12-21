package com.base.core.action.shoulu;

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

@SuppressWarnings("serial")
public class GoogleShouLuAction extends ShouLuBaseAction{
	
	private Log logger =LogFactory.getLog(this.getClass());
	
	public String execute(){
		Long start =System.currentTimeMillis();
        URL url = null;
        HttpURLConnection httpConn = null;
        InputStream in = null;
        String cookie = "";
        try
        {
            do {
            	this.setTargetUrl("http://www.google.com.hk/search?hl=zh-CN&q=site%3A"+this.shoulu_domain);
            	url = new URL("http://www.google.com.hk/search?hl=zh-CN&q=site%3A"+this.shoulu_domain);
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
            //(.*)获得约 (.*)条结果(.*)
            Pattern pattern = Pattern.compile("(.*)获得约 (.*)条结果(.*)");
            Matcher matcher =pattern.matcher(sbf.toString());
            if(matcher.find()){
            	shoulu_result =matcher.group(2).toString().replaceAll("\\,", "").replaceAll("\\，", "").trim();
            }
//            pattern = Pattern.compile("(.*)用时(.*)秒(.*)");
//            matcher =pattern.matcher(sbf.toString());
//            if(matcher.find()){
//            	this.setExecuteTime(matcher.group(2).toString());
//            }else{
//            	this.setExecuteTime("0.01");
//            }
            this.getResponse().setCharacterEncoding("utf-8");
            this.getResponse().setContentType("text/x-json;charset=UTF-8");
            this.getResponse().getWriter().write(shoulu_result+"_split_"+this.getTargetUrl().toLowerCase());
            this.getResponse().getWriter().close();
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
		return null;
	}

}
