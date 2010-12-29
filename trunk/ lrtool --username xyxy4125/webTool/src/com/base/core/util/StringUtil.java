package com.base.core.util;

import java.net.URLEncoder;
import java.sql.Clob;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil {
    public static boolean isEmpty(String str) {
        return (str == null) || (str.trim().length() == 0);
    }

    // 替换Null为空值
    public static String convertNull(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String toString(Integer iSource){
        if(iSource==null) return "";
        else return iSource.toString();
    }

    public static boolean isNullString(String str){
        if(str==null || "".equals(str) || "null".equals(str)) return true;
        return false;
    }

    public static String replaceFirst(String strSource,String regex, String replacement){
        if(isEmpty(strSource)) return "";
        return strSource.replaceFirst(regex,replacement);
    }

    public static String getAvailableURL(String srcURI){
        StringBuffer bufferURI=new StringBuffer();
        if(!isEmpty(srcURI)){
            String[] covertURI=srcURI.split("\\?");
            if(covertURI.length>0 && !isEmpty(covertURI[0])) bufferURI.append(covertURI[0]);
            bufferURI.append("?");
            if(covertURI.length==2){
                String[] parameters=covertURI[1].split("\\&");
                for(int i=0;i<parameters.length;i++){
                    String[] valuePair=parameters[i].split("=");
                    if (valuePair.length == 2) {
                        try {
                            bufferURI.append(valuePair[0]).append("=").append(URLEncoder.encode(valuePair[1], "UTF-8")).append("&");
                        } catch (Exception e) {}
                    }
                }
            }
            return bufferURI.toString();
        }
        return srcURI;
    }

    public static String getStringBeforeSplit(String str, String separator) {
        if (str == null || separator == null || str.length() == 0 || separator.length() == 0) {
            return str;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }

    public static String getStringAfterSplit(String str, String separator) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (separator == null || separator.length() == 0) {
            return "";
        }
        int pos = str.lastIndexOf(separator);
        if (pos == -1 || pos == (str.length() - separator.length())) {
            return "";
        }
        return str.substring(pos + separator.length());
    }

    /**
     * 比较页为空时显示无
     * @param str
     * @return
     */
    public static String getEmptyDefaultValue(String str){
        if(StringUtil.isEmpty(str)){
            return "无";
        }else{
            return str;
        }
    }

    public static String getDuBangSerialNumber(String appId){
        StringBuffer sb=new StringBuffer("");
        for(int i=0;i<10-appId.length();i++){
            sb.append("0");
        }
        sb.append(appId);
        return sb.toString();
    }

    public static String getDoubleStr(Double value){
        if(value ==null || "null".equals(value)){
            value = 0.0;    
        }
        return String.valueOf(value);
    }

    public static String getIntegerStr(Integer value){
        if(value ==null || "null".equals(value)){
            value = 0;
        }
        return String.valueOf(value);
    }
    public static Integer getIntegerByStr(String value){
        if(StringUtil.isEmpty(value)){
            value = "0";
        }
        return Integer.valueOf(value);
    }


    public static String parseDoubleStr(String str){
        if(str==null || "".equals(str) || "null".equals(str)){
            str =  "0";    
        }
        return str;
    }
    
    public static String stringValue(Object obj, String defaultValue) {
		if (obj == null) {
			return defaultValue;
		} else if (obj instanceof String) {
			return (String) obj;
		} else if (obj instanceof Clob) {
			return stringValue((Clob) obj, "");
		} else {
			return obj.toString();
		}
	}

    
    public static void main(String[] args){
    	 System.out.println(getFormatNumbers("123456", 0, ","));
         System.out.println(getFormatNumbers("2545625.457", 4, ""));
         System.out.println(getFormatNumbers("2545625.457878", 4, ""));
         System.out.println(getFormatNumbers("0.457878", 4, ""));
         System.out.println(getFormatNumbers("57878", 3, ","));
         System.out.println(getFormatNumbers(".57878", 3, ","));
         System.out.println("abc".indexOf("d"));
    }
    
    public static String right(String mainStr,int lngLen) {
    	if (mainStr.length()-lngLen>=0 && mainStr.length()>=0 && mainStr.length()-lngLen<=mainStr.length()) {
    	    return mainStr.substring(mainStr.length()-lngLen,mainStr.length());
    	}else{
    		return null;
    	}
    }
    
    //长串数字处理，如用千分位分隔，小数点保留几位
    public static String getFormatNumbers(String value, int decimalPrecision,
            String thousandsSeparator) {
    	Pattern integerPattern = Pattern.compile("^-?[0-9]*$");
    	Pattern thousandsSeparatePattern = Pattern.compile("(\\d{1,3})(?=(\\d{3})+(?:$|\\D))");
        if (decimalPrecision > 0) {
            if (value == null || value.equals("")) {
                if (!Pattern.matches("^-?[0-9]*\\.{0,1}\\d{0,"+ decimalPrecision + "}$", value)) {
                    value = "0";
                }
            }
            String pattern = "0.";
            for (int i = 0; i < decimalPrecision; i++) {
                pattern += "0";
            }
            value = new DecimalFormat(pattern)
                    .format(Double.parseDouble(value));
            String integerPart = value.split("\\.")[0];
            String decimalPart = value.split("\\.")[1];
 
            Matcher matcher = thousandsSeparatePattern.matcher(integerPart);
            integerPart = matcher.replaceAll("$1" + thousandsSeparator);
            value = integerPart + "." + decimalPart;
        } else {
            if (value == null || value.equals("")) {
                if (!integerPattern.matcher(value).find()) {
                    value = "0";
                }
            }
            Matcher matcher = thousandsSeparatePattern.matcher(value);
            value = matcher.replaceAll("$1" + thousandsSeparator);
        }
        return value;
    }
    
    
}
