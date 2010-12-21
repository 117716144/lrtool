package com.base.core.util;

public class DWRBeanUtil {
    public static String[] splitString(String toSplit,String regex,int limit){
        if(toSplit==null || "".equals(toSplit)) return null;
        String[] splited=toSplit.split(regex,limit);
        return splited;
    }

    public static String removePrefixByDot(String toSplit){
        String lastSplited[]=splitString(toSplit,"\\.",2);
        if(lastSplited==null || lastSplited.length<=1){ 
            return "";
        }else{
            return lastSplited[1];
        }
    }

    public static void main(String[] args){
        String test="aaa.bbb.ccc";
        String split=removePrefixByDot(test);
        System.out.println(split);
    }
}
