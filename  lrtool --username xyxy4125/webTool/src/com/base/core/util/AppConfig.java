package com.base.core.util;

public class AppConfig {

	private final static String file = "/appconfig.properties";

	public final static PropertiesUtils Utils = PropertiesUtils.getInstance(AppConfig.class);

	public final static String getConfig(String key, String defaultValue) {
		return Utils.getValue(file, key, defaultValue);
	}
	
	public final static String getConfig(String key, String defaultValue, Object... args){
		StringBuffer str = new StringBuffer(Utils.getValue(file, key, defaultValue));
		for(int index=0;index<args.length;index++){
			AppConfig.replaceAll(str, "%"+index, ""+args[index]);
		}
		return str.toString();
	}
	
	public static StringBuffer replaceAll(StringBuffer content,
			String searchStr, String replaceStr) {

		if (searchStr == null || searchStr.length() == 0)
			return content;
		if (replaceStr == null) {
			replaceStr = "";
		}
		StringBuffer sb = new StringBuffer(content);
		int start = 0, end = 0;
		start = sb.indexOf(searchStr, start);
		end = start + searchStr.length();
		while (start != -1) {
			start = sb.indexOf(searchStr, start);
			end = start + searchStr.length();
			if (start == -1 || end == -1) {
				break;
			}
			sb = replaceContent(content, start, end, replaceStr);
		}
		return sb;
	}
	
	public static StringBuffer replaceContent(StringBuffer content,
			int startIndex, int endIndex, String replaceStr) {
		if (startIndex == -1 || endIndex == -1) {
			return content;
		}
		return content.replace(startIndex, endIndex, replaceStr);
	}

	public static StringBuffer replaceContent(StringBuffer content,
			int startIndex, int endIndex, StringBuffer replaceStr) {
		return replaceContent(content, startIndex, endIndex, replaceStr
				.toString());
	}

	public final static Boolean getConfig(String key, boolean defaultValue) {
		return Utils.getBooleanValue(file, key, defaultValue);
	}

	public final static int getConfig(String key, int defaultValue) {
		return Utils.getIntValue(file, key, defaultValue);
	}

	public final static long getConfig(String key, long defaultValue) {
		return Utils.getLongValue(file, key, defaultValue);
	}

	public final static double getConfig(String key, double defaultValue) {
		return Utils.getDoubleValue(file, key, defaultValue);
	}

	public final static float getConfig(String key, float defaultValue) {
		return Utils.getFloatValue(file, key, defaultValue);
	}
	
	public static void main(String[] args){
		System.out.println(AppConfig.getConfig("this.set.value", ""));
	}

}