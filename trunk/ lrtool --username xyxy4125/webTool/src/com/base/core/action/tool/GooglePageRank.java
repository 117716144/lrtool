package com.base.core.action.tool;


import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public class GooglePageRank {
	

	public final String GOOGLE_PR_DATACENTER_IP = "toolbarqueries.google.com";

	public int getPageRank(String domain) {
		
		JenkinsHash jHash = new JenkinsHash();
		long hash = jHash.hash(("info:" + domain).getBytes());

		String url = "http://" + GOOGLE_PR_DATACENTER_IP
				+ "/search?client=navclient-auto&hl=en&" + "ch=6" + hash
				+ "&ie=UTF-8&oe=UTF-8&features=Rank&q=info:" + domain;

		try {
			URLConnection conn = new URL(url).openConnection();
			String pageRankResponse = IOUtils.toString(conn.getInputStream());
			
			if (StringUtils.isNotBlank(pageRankResponse)) {
				return NumberUtils.toInt(pageRankResponse.split(":")[2].trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		GooglePageRank prService = new GooglePageRank();
		System.out.println("PageRank: " + prService.getPageRank("http://www.ubao.com"));
	}

}
