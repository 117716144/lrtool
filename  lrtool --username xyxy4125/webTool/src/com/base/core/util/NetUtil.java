package com.base.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import sun.security.provider.MD5;

import com.base.core.constant.LrtoolConstant;

public class NetUtil {

	public String getTargetStr(String urlStr, String charset) {
		URL url = null;
		HttpURLConnection httpConn = null;
		InputStream in = null;
		String cookie = "";
		try {
			do {
				if (StringUtil.isEmpty(urlStr) || !NetUtil.checkUrl(urlStr)) {
					return "";
				}

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
					StringUtil.isEmpty(charset) ? "gb2312" : charset));
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

	@SuppressWarnings("deprecation")
	public String getTargetStrByHttpClient() throws HttpException, IOException {
		String QueryString = "%BB%D8%BC%D2%B5%C4%D3%D5%BB%F3";
		String URLQueryString = URLEncoder.encode(QueryString);
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost( "index.baidu.com" , 80, "http" );
		HttpMethod method = getGetMethod(QueryString);    // 使用 POST 方式提交数据 
	    client.executeMethod(method);   //打印服务器返回的状态 
	    System.out.println(method.getStatusLine());   //打印结果页面
	    String response=new String(method.getResponseBodyAsString());

	      //打印返回的信息
	    System.out.println(response);
	    method.releaseConnection();

		return response;
	}
	
	private static HttpMethod getGetMethod(String qrs) {
		HttpMethod method = new GetMethod("/main/word.php?word="+qrs);
		method.getParams().setContentCharset("gb2312");  
//		method.setRequestHeader( "Content-type" , "text/xml; charset=gb2312" );
//		method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "gb2312");  
		return method;
	}

	/**
	 * 使用 POST 方式提交数据
	 * 
	 * @return
	 */

	private static HttpMethod getPostMethod(String qrs) {
		PostMethod post = new PostMethod("/main/word.php");
		post.setRequestHeader( "Content-type" , "text/xml; charset=gb2312" );
		NameValuePair simcard = new NameValuePair("word", qrs);
		post.setRequestBody(new NameValuePair[] { simcard });
		return post;
	}

	public static boolean checkUrl(String url) {
		Pattern p = Pattern.compile(LrtoolConstant.urlPattern);
		Matcher mat = p.matcher(url);
		if (mat.find()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static void main(String[] args) throws HttpException, IOException{
		//%BB%D8%BC%D2%B5%C4%D3%D5%BB%F3
		System.out.println(java.net.URLEncoder.encode("回家的诱惑", "gb2312"));
		//%E5%9B%9E%E5%AE%B6%E7%9A%84%E8%AF%B1%E6%83%91
		System.out.println(java.net.URLEncoder.encode("回家的诱惑", "utf-8"));
		//System.out.println(new NetUtil().getTargetStrByHttpClient());
		//System.out.println(new NetUtil().getTargetStr("http://index.baidu.com/main/word.php?word=%BB%D8%BC%D2%B5%C4%D3%D5%BB%F3","gb2312"));
	}
}
