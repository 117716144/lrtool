package com.base.core.util;

public class UbString {

    /**
     * 将字符串中的 子字符串 替换为新 字符串 (区分大小写)
     *
     * @param string    被操作字符串 "abcedfg"
     * @param oldString 被替换子字符串 "ce"
     * @param newString 新字符串 "11"
     * @return 替换后字符串 "ab11dfg"
     */
    public static final String replace(String string, String oldString,
                                       String newString) {
        if (string == null)
            return null;
        if (newString == null)
            return string;
        int i = 0;
        if ((i = string.indexOf(oldString, i)) >= 0) {
            char string2[] = string.toCharArray();
            char newString2[] = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(string2.length);
            buf.append(string2, 0, i).append(newString2);
            i += oLength;
            int j;
            for (j = i; (i = string.indexOf(oldString, i)) > 0; j = i) {
                buf.append(string2, j, i - j).append(newString2);
                i += oLength;
            }

            buf.append(string2, j, string2.length - j);
            return buf.toString();
        } else {
            return string;
        }
    }

    /**
     * 将字符串中的 子字符串 替换为新 字符串 (不区分大小写)
     *
     * @param strSource 被操作字符串 "abcedfg"
     * @param oldString 被替换子字符串 "Ce"
     * @param newString 新字符串 "11"
     * @return 替换后字符串 "ab11dfg"
     */

    public static final String replaceIgnoreCase(String strSource, String oldString,
                                                 String newString) {
        if (strSource == null)
            return null;
        String lcLine = strSource.toLowerCase();
        String lcOldString = oldString.toLowerCase();
        int i = 0;
        if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
            char line2[] = strSource.toCharArray();
            char newString2[] = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j;
            for (j = i; (i = lcLine.indexOf(lcOldString, i)) > 0; j = i) {
                buf.append(line2, j, i - j).append(newString2);
                i += oLength;
            }

            buf.append(line2, j, line2.length - j);
            return buf.toString();
        } else {
            return strSource;
        }
    }

    public static String strNull(String s) {
        if (s == null)
            return "";
        else
            return s;
    }
}
