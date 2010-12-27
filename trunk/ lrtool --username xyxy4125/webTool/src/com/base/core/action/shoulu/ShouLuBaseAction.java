package com.base.core.action.shoulu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.base.core.BaseAction;
import com.base.core.util.StringUtil;

/**
 * @author XIEYING
 * 
 */
@SuppressWarnings("serial")
public class ShouLuBaseAction extends BaseAction {

	private Log logger = LogFactory.getLog(this.getClass());
	protected String shoulu_domain = "";

	public String getShoulu_domain() {
		return shoulu_domain.replace("http://", "");
	}

	public void setShoulu_domain(String shouluDomain) {
		shoulu_domain = shouluDomain;
	}

	protected String shoulu_result = "";

	public String getShoulu_result() {
		return shoulu_result;
	}

	public void setShoulu_result(String shouluResult) {
		shoulu_result = shouluResult;
	}

	protected String executeTime = "";

	protected String targetUrl = "";

	public String getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(String executeTime) {
		this.executeTime = executeTime;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	protected void common(String url,String charset) {
		try {
			String target = getTargetStr(url,charset);
			getResult(target);
			this.getResponse().setCharacterEncoding("utf-8");
			this.getResponse().setContentType("text/x-json;charset=UTF-8");
			this.getResponse().getWriter().write(
					shoulu_result + "_split_"
							+ this.getTargetUrl().toLowerCase());
			this.getResponse().getWriter().close();
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
	}

	// 取得目标字符串
	protected String getTargetStr(String urlStr,String charset) {
		URL url = null;
		HttpURLConnection httpConn = null;
		InputStream in = null;
		String cookie = "";
		this.setTargetUrl(urlStr);
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

	protected void getResult(String str) {

	}

	protected String executeResponse(String url,String charset) {
		try {
			Long start = System.currentTimeMillis();
			common(url,charset);
			Long end = System.currentTimeMillis();
			logger.info("总共用时：" + (end - start) + "毫秒");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}