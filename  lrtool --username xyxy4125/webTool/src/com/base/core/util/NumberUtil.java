package com.base.core.util;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class NumberUtil {
    private static DecimalFormat decimalFormat = new DecimalFormat();

    /*
      return last four bit Number.
     */
    public static String getLastFourBitNumber(long sourceNumber) {
        decimalFormat.applyPattern("0000");
        String stSourceNumber = decimalFormat.format(sourceNumber);
        return stSourceNumber.substring(stSourceNumber.length() - 4, stSourceNumber.length());
    }

    public static String formatNumber(BigDecimal number) {
        if (number == null) {
            return "";
        }
        return number.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static String formatNumber(double number) {
        return formatNumber(new BigDecimal(number));
    }

    public static String formatNumber(double number, int scale) {
        BigDecimal num = new BigDecimal(number);
        if (num == null) {
            return "";
        }
        return num.setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static int parseInt(String numStr) {
        int n = 0;
        try {
            n = Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            // ignore error
        }
        return n;
    }

    public static double parseDouble(String numStr) {
        double n = 0;
        try {
            n = Double.parseDouble(numStr);
        } catch (NumberFormatException e) {
            // ignore error
        }
        return n;
    }

    public static float parseFloat(String numStr) {
        float n = 0;
        try {
            n = Float.parseFloat(numStr);
        } catch (NumberFormatException e) {
            // ignore error
        }
        return n;
    }

    public static BigDecimal parseBigDecimal(double numDouble) {
        BigDecimal n = new BigDecimal(0);
        try {
            n = new BigDecimal(String.valueOf(numDouble));
        } catch (NumberFormatException e) {
            //ignore error
        }
        return n;
    }

    public static String formatBigDecimal(BigDecimal source) {
        if (StringUtil.isEmpty(source.toString())) return "0";
        Double dbSource = new Double(source.toString());
        DecimalFormat dbFormat = new DecimalFormat();
        dbFormat.applyPattern("###,###,###,###,##0.00");
        return dbFormat.format(dbSource);
    }

    /**
     * @param numInteger
     * @return
     */
    public static String formatInteger(double numInteger) {
        DecimalFormat integerFormat = new DecimalFormat();
        integerFormat.applyPattern("###,###,###,###,##0");
        return integerFormat.format(numInteger);
    }

    public static BigDecimal getBigDecimal(String str) {
        if (str != null && !"".equals(str) && !"null".equals(str)) {
            str = "0";
        }
        return new BigDecimal(str);
    }

    public static String getFormNumber(double number, String pattern) {
        DecimalFormat format = new DecimalFormat(pattern);
        return format.format(number);
    }

    public static boolean isNum(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNumber = pattern.matcher(str);
        if (!isNumber.matches()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(formatInteger(1060.0));

        // System.out.print(getFormNumber(22.3,"##0.00"));

        //System.out.println(formatBigDecimal(new BigDecimal(100.21)));
    }

}
