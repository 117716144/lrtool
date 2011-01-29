package com.base.core.action.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.base.core.BaseAction;
import com.base.core.util.StringUtil;

@SuppressWarnings("serial")
public class KeywordSearchAction extends BaseAction{

	private String keyword;
	
	private String siteurl;
	
	private String keyPosition;
	
	public String getKeyPosition() {
		return keyPosition;
	}

	public void setKeyPosition(String keyPosition) {
		this.keyPosition = keyPosition;
	}

	public String getSiteurl() {
		return siteurl;
	}

	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String execute(){
		String url = "http://www.baidu.com/s?rn=100&q1="+this.getKeyword();
		String resultStr =getTargetStr(url,"gb2312");
		int position =StringUtil.ignoreIndexOf(resultStr, siteurl, 0, true);
		if(position!=-1){
		resultStr =resultStr.substring(position-330,position);
		if(resultStr.indexOf("<table cellpadding=\"0\" cellspacing=\"0\" class=\"result\" id=\"")!=-1){
			int start =resultStr.indexOf("<table cellpadding=\"0\" cellspacing=\"0\" class=\"result\" id=\"");
			int end =resultStr.indexOf("\"><tr>");
			int length ="<table cellpadding=\"0\" cellspacing=\"0\" class=\"result\" id=\"".length();
			keyPosition =resultStr.substring(start+length,end);
		}
		}else{
			System.out.println("not find it");
		}
		return SUCCESS;
	}
	
	public static void main(String[] args){
		KeywordSearchAction ks = new KeywordSearchAction();
		ks.setSiteurl("www.ubao.com");
		ks.setKeyword("在线保险");
		ks.execute();
	}
	
	protected String getTargetStr(String urlStr,String charset) {
		URL url = null;
		HttpURLConnection httpConn = null;
		InputStream in = null;
		String cookie = "";
		try {
			do {
				url = new URL(urlStr);
				httpConn = (HttpURLConnection) url.openConnection();
				HttpURLConnection.setFollowRedirects(true);
				httpConn.setRequestMethod("GET");
				httpConn.setConnectTimeout(30000);
				httpConn.setRequestProperty("User-Agent",
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)");
				if (cookie.length() != 0)
					httpConn.setRequestProperty("Cookie", cookie);
				httpConn.setInstanceFollowRedirects(false);
				int code = httpConn.getResponseCode();
				if (code == HttpURLConnection.HTTP_MOVED_TEMP) {
					cookie += httpConn.getHeaderField("Set-Cookie") + ";";
				}
				if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK)
					break;
			} while (true);
			in = httpConn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in,
					StringUtil.isEmpty(charset)?"gb2312":charset));
			String line = "";
			StringBuffer sbf = new StringBuffer();
			while ((line = br.readLine()) != null) {
				sbf.append(line);
			}
			return sbf.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				httpConn.disconnect();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
}
