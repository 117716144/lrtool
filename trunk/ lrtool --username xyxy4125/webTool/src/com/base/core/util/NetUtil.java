package com.base.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

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
	public String getTargetStrByHttpClient(String host,String qryStr) throws HttpException, IOException {
		//String QueryString = "%BB%D8%BC%D2%B5%C4%D3%D5%BB%F3";
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost(host, 80, "http");
		HttpMethod method = getGetMethod(qryStr); // 使用 POST 方式提交数据
		int statusCode =client.executeMethod(method); // 打印服务器返回的状态
		if (statusCode != HttpStatus.SC_OK) {  
			System.err.println("Method failed: " + method.getStatusLine());  
			return null;  
		} 
		String response = new String(method.getResponseBodyAsString());
		extractPageUrl(response);
		method.releaseConnection();
		return response;
	}
	
	public void extractPageUrl(String content){
		Pattern urlPattern = Pattern.compile("<a.*href='(.*)'.*>(.+?)</a>");
		Matcher matcher =urlPattern.matcher(content);
		while(matcher.find()){
			System.out.println(matcher.group(1));
		}
	}

	private static HttpMethod getGetMethod(String qrs) {
		HttpMethod method = new GetMethod("/main/word.php?word=" + qrs);
		method.getParams().setContentCharset("gb2312");
		// method.setRequestHeader( "Content-type" , "text/xml; charset=gb2312"
		// );
		// method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
		// "gb2312");
		return method;
	}

	/**
	 * 使用 POST 方式提交数据
	 * 
	 * @return
	 */

	private static HttpMethod getPostMethod(String qrs) {
		PostMethod post = new PostMethod("/main/word.php");
		post.setRequestHeader("Content-type", "text/xml; charset=gb2312");
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

	/**
	 * MD5 加密
	 */
	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}

//	public static void main(String[] args) throws HttpException, IOException {
//		// %BB%D8%BC%D2%B5%C4%D3%D5%BB%F3
//		String qryStr = java.net.URLEncoder.encode("回家的诱惑", "gb2312");
//		// %E5%9B%9E%E5%AE%B6%E7%9A%84%E8%AF%B1%E6%83%91
//		//System.out.println(java.net.URLEncoder.encode("回家的诱惑", "utf-8"));
//		//System.out.println(NetUtil.getMD5Str("3c480793315292e002"+"%E5%9B%9E%E5%AE%B6%E7%9A%84%E8%AF%B1%E6%83%91"+"ZZg<XWe7SZcBJ^aH"));
//		 System.out.println(new NetUtil().getTargetStrByHttpClient("index.baidu.com",qryStr));
//		//System.out.println(new
//		//NetUtil().getTargetStr("http://index.baidu.com/main/word.php?word=%BB%D8%BC%D2%B5%C4%D3%D5%BB%F3","gb2312"));
//	}
	
	public static String getHTML(String url) throws Exception {  
		       HttpClient httpClient = new HttpClient();  
		       GetMethod getMethod = new GetMethod(url); 
		       getMethod.getParams().setContentCharset("gb2312");
		       int statusCode = httpClient.executeMethod(getMethod);  
		       if (statusCode != HttpStatus.SC_OK) {  
		           System.err.println("Method failed: " + getMethod.getStatusLine());  
		           return null;  
		       }  
		       // 读取内容  
		       byte[] responseBody = getMethod.getResponseBody();  
		       getMethod.releaseConnection();  
		       return new String(responseBody,"gb2312");  
		 
		   }  
		   /** 
		    *  
		    * @throws Exception 
		    */  
		   public static void test(String url) throws Exception{  
		         
		       String html = getHTML(url);  
		       Pattern p = null;  
		       Matcher m = null;  
		       StringBuffer sb0 = new StringBuffer();  
		       // ul正则  
		       String regex = "<ul class=\"d2_9\">([\\s\\S]*<li>)<a.*href='(.*)'.*>(.+?)</a> \\[(.*)\\]</li>([\\s].*)";  
		       // 链接正则  
		       String regexa = "<a.*href='(.*)'.*>(.+?)</a> \\[(.*)\\]";  
		       p = Pattern.compile(regex);  
		       // m = p.matcher(sb.toString());  
		       m = p.matcher(html);  
		       int count = 0;  
		       // ul字符串  
		       while (m.find()) {  
		           sb0.append(m.group());  
		       }  
		       //System.out.println(sb0.toString());  
		       p = Pattern.compile(regexa);  
		       m = p.matcher(sb0.toString());  
		       // 链接地址和标题  
		       while (m.find()) {  
		           System.out.println("地址:" + m.group(1));  
		           System.out.println("标题:" + m.group(2));  
		           System.out.println("时间:" + m.group(3));  
		           count++;  
		       }  
		         
		       System.out.println("抓取条数："+count);  
		 
		   }  
		     
		   public static void main(String[] args) throws Exception {  
		       String url = "http://cpc.people.com.cn/GB/194302/194306/index.html";  
		       test(url);  
		         
		   }  
}
