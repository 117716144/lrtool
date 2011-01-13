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
public class PageRankAction extends BaseAction{

	private String prdomain;
	
	public String getPrdomain() {
		return prdomain;
	}

	public void setPrdomain(String prdomain) {
		this.prdomain = prdomain;
	}
	
	private int googlePR;
	
	private int sogouPR;

	public int getGooglePR() {
		return googlePR;
	}

	public void setGooglePR(int googlePR) {
		this.googlePR = googlePR;
	}

	public int getSogouPR() {
		return sogouPR;
	}

	public void setSogouPR(int sogouPR) {
		this.sogouPR = sogouPR;
	}

	public String execute(){
		GooglePageRank gr = new GooglePageRank();
		googlePR =gr.getPageRank(this.getPrdomain());
		String url ="http://www.sogou.com/web?query=link%3A"+this.getPrdomain();
		String resultStr =getTargetStr(url,"gb2312");
		Pattern pattern = Pattern.compile("(.*)搜狗评级:(.*)&nbsp;-&nbsp;(.*)");
		Matcher matcher = pattern.matcher(resultStr.toString());
		if (matcher.find()) {
			String result = matcher.group(2).toString().replaceAll("\\,", "")
					.replaceAll("\\，", "").trim();
			if(result.indexOf("/100")!=-1){
				result = result.substring(0,result.indexOf("/100"));
			}
			sogouPR =(Integer.parseInt(result)/10);
		}
	    return SUCCESS;
	}
	
	public static void main(String[] args){
		PageRankAction pr = new PageRankAction();
		pr.setPrdomain("http://www.hao123.com");
		pr.execute();
	}
	
	protected String getTargetStr(String urlStr,String charset) {
		URL url = null;
		HttpURLConnection httpConn = null;
		InputStream in = null;
		String cookie = "";
		this.setPrdomain(urlStr);
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
