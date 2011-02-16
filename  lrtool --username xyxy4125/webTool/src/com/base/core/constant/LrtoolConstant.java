package com.base.core.constant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LrtoolConstant {
	
	public final static String urlPattern ="http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?";

	public static void main(String[] args){
		String url ="https://www.ubao.com.cn";
		Pattern p = Pattern.compile(LrtoolConstant.urlPattern);
		Matcher mat =p.matcher(url);
		if(mat.find()){
			System.out.println("就是你了");
		}else{
			System.out.println("Oh,no");
		}
	}
}
