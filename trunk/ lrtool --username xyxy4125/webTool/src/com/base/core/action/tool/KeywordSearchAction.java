package com.base.core.action.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.base.core.BaseAction;
import com.base.core.util.StringUtil;

@SuppressWarnings("serial")
public class KeywordSearchAction extends BaseAction{

	private String keyword="";
	
	private String siteurl="";
	
	private String keyPosition="";
	
	private String skey="";
	
	private String surl="";
	
	private Long stotal; //总字节数
	
	private Long keytotal; //关键字字节数
	
	private String percent; //占百分比
	
	private int frequency; //出现次数
	
	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public String getSurl() {
		return surl;
	}

	public void setSurl(String surl) {
		this.surl = surl;
	}

	public String getKeyPosition() {
		return keyPosition;
	}

	public void setKeyPosition(String keyPosition) {
		this.keyPosition = keyPosition;
	}

	public String getSiteurl() {
		return siteurl.replace("http://", "");
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
	
	public Long getStotal() {
		return stotal;
	}

	public void setStotal(Long stotal) {
		this.stotal = stotal;
	}

	public Long getKeytotal() {
		return keytotal;
	}

	public void setKeytotal(Long keytotal) {
		this.keytotal = keytotal;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}


	public String execute(){
		if(StringUtil.isEmpty(this.getSiteurl()) || StringUtil.isEmpty(this.getKeyword())){
			return SUCCESS;
		}
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
	
	/**
	 * 某个词在页面上的词频
	 * @return
	 */
	public String getCount(){
		if(StringUtil.isEmpty(this.getSkey()) || StringUtil.isEmpty(this.getSurl())){
			return SUCCESS;
		}
		String pageEncoding =this.pageEncoding();
		String resultStr =getTargetStr(surl,StringUtil.isEmpty(pageEncoding)?"utf-8":pageEncoding);
		if(!StringUtil.isEmpty(resultStr) && !StringUtil.isEmpty(skey)){
		resultStr =resultStr.replaceAll("\\<.*?>", "");
		resultStr =resultStr.replaceAll("\\s+", "");
		frequency =StringUtil.calcKeysFrequency(resultStr, skey);
		stotal =Long.parseLong(String.valueOf(StringUtil.getStringByteCount(resultStr)));
		keytotal =Long.parseLong(String.valueOf(StringUtil.getStringByteCount(skey)));
		percent =StringUtil.percent(keytotal*frequency, stotal);
		System.out.println(frequency+"--"+stotal+"--"+keytotal+"--"+percent);
		System.out.println(StringUtil.getStringByteCount("ddd旅游保险"));
		}
		return SUCCESS;
	}
	
	public String pageEncoding(){
		String resultStr =getTargetStr(surl,"gb2312");
//		Pattern pattern = Pattern.compile("(.*)<title>(.*)</title>(.*)");
//		Matcher matcher = pattern.matcher(resultStr.toString());
//		if (matcher.find()) {
//			String title = matcher.group(2).toString();
//			System.out.println(title);
//		}
//		pattern = Pattern.compile("(.*)<meta\\s+name=\"keywords\"\\s+content=\"(.*)\"/>(.*)");
//		matcher =pattern.matcher(resultStr.toString());
//		if(matcher.find()){
//			String keys = matcher.group(2).toString().replaceAll("\\s+", "");
//			if(keys.indexOf("\"/>")!=-1){
//			 int pos =keys.indexOf("\"/>");
//			 System.out.println(keys.substring(0,pos));
//			}
//		}
//		pattern = Pattern.compile("(.*)<meta\\s+name=\"description\"\\s+content=\"(.*)\"/>(.*)");
//		matcher =pattern.matcher(resultStr.toString());
//		if(matcher.find()){
//			String keys = matcher.group(2).toString().replaceAll("\\s+", "");
//			if(keys.indexOf("\"/>")!=-1){
//			 int pos =keys.indexOf("\"/>");
//			 System.out.println(keys.substring(0,pos));
//			}
//		}
		if(resultStr.indexOf("http-equiv=\"Content-Type\"")!=-1){
		Pattern pattern = Pattern.compile("(.*)<meta\\s+http-equiv=\"Content-Type\"\\s+content=\"(.*)\"/>(.*)");
		Matcher matcher =pattern.matcher(resultStr.toString());
		if(matcher.find()){
			String keys = matcher.group(2).toString().replaceAll("\\s+", "");
			if(keys.indexOf("\"/>")!=-1){
			 int pos =keys.indexOf("\"/>");
			 keys =keys.substring(0,pos);
			 if(keys.indexOf("charset=")!=-1){
				 pos = keys.indexOf("charset=");
				 System.out.println(keys.substring(pos+8));
				 return keys.substring(pos+8);
			 }
			}
		}
		}else{
			System.out.println("未找到页面编码");
		}
		
		return null;
		
	}
	
	public static void main(String[] args){
		KeywordSearchAction ks = new KeywordSearchAction();
//		ks.setSiteurl("www.ubao.com");
//		ks.setKeyword("在线保险");
//		ks.execute();
		ks.setSurl("http://www.ubao.com");
		ks.setSkey("旅游保险");
		ks.getCount();
		ks.pageEncoding();
		
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
