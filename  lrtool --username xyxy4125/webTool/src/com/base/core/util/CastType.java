/**
 *
 */
package com.base.core.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.sql.Clob;
import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class CastType {
	private static final DecimalFormat doubleformat = new DecimalFormat("0.###");

	private static final String[] dtstyle = new String[] {
			"yyyy-MM-dd HH:mm:ss.SSS", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd",
			"HH:mm:ss.SSS", "HH:mm:ss", };

	private final static org.apache.commons.logging.Log logger = org.apache.commons.logging.LogFactory
			.getLog(CastType.class);

	public static boolean booleanValue(String s) {
		return Boolean.valueOf(s).booleanValue();
	}

	public static byte byteValue(Object objValue) {
		return (byte) doubleValue(objValue, 0);
	}

	public static byte byteValue(Object objValue, byte defaultValue) {
		return (byte) doubleValue(objValue, defaultValue);
	}

	public static String DecodeMapEntry(String enc) {
		enc = enc.replaceAll("&equal;", "=");
		enc = enc.replaceAll("&comma;", ",");
		enc = enc.replaceAll("&amp;", "&");
		return enc;
	}

	public static double doubleValue(Object objValue) {
		return doubleValue(objValue, 0);
	}

	public static double doubleValue(Object objValue, double defaultValue) {
		if (objValue == null) {
			return defaultValue;
		} else if (objValue instanceof Number) {
			return ((Number) objValue).doubleValue();
		} else {
			try {
				return Double.valueOf(objValue.toString()).doubleValue();
			} catch (Exception e) {
				return defaultValue;
			}
		}
	}

	public static java.util.Date dtparse(String dtstring) throws Exception {
		for (int i = 0; i < dtstyle.length; i++) {
			try {
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
						dtstyle[i]);
				return sdf.parse(dtstring);
			} catch (java.text.ParseException e) {
				// logger.error("", e);
			}
		}
		throw new Exception("Unparseable datetime: \"" + dtstring + "\"");
	}

	public static String EncodeMapEntry(String src) {
		src = src.replaceAll("&", "&amp;");
		src = src.replaceAll(",", "&comma;");
		src = src.replaceAll("=", "&equal;");
		return src;
	}

	public static float floatValue(Object objValue) {
		return (float) doubleValue(objValue, 0);
	}

	public static float floatValue(Object objValue, float defaultValue) {
		return (float) doubleValue(objValue, defaultValue);
	}

	public static String formatDouble(double n) {
		return doubleformat.format(n);
	}

	public static String formatDouble(Double n) {
		return doubleformat.format(n == null ? 0 : n.doubleValue());
	}

	@SuppressWarnings("unchecked")
	public static String Hashtable2String(Hashtable ht) {
		synchronized (ht) {
			int max = ht.size() - 1;
			StringBuffer buf = new StringBuffer();
			Iterator it = ht.entrySet().iterator();
			for (int i = 0; i <= max; i++) {
				Map.Entry e = (Map.Entry) (it.next());
				String key = (String) e.getKey();
				String value = (String) e.getValue();
				key = EncodeMapEntry(key);
				value = EncodeMapEntry(value);
				buf.append(key + "=" + value);
				if (i < max)
					buf.append(",");
			}
			return buf.toString();
		}
	}

	public static byte[] InputStream2ByteArray(InputStream in) {
		return InputStream2ByteArray(in, 1024);
	}

	public static byte[] InputStream2ByteArray(InputStream in, int chunksize) {
		byte[] retb = new byte[0];
		try {
			byte[] b = new byte[chunksize];
			int len = 0;
			int re = in.read(b);
			while (re != -1) {
				len += re;
				byte[] t = new byte[len];
				System.arraycopy(retb, 0, t, 0, retb.length);
				System.arraycopy(b, 0, t, retb.length, re);
				retb = t;
				re = in.read(b);
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		return retb;
	}

	public static int intValue(Object objValue) {
		return (int) doubleValue(objValue, 0);
	}

	public static int intValue(Object objValue, int defaultValue) {
		return (int) doubleValue(objValue, defaultValue);
	}

	public static long longValue(Object objValue) {
		return (long) doubleValue(objValue, 0);
	}

	public static long longValue(Object objValue, long defaultValue) {
		return (long) doubleValue(objValue, defaultValue);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public static Long MakeLong(int h, int l) {
		long key = h;
		key = key << 32 + l;
		return new Long(key);
	}

	public static short shortValue(Object objValue) {
		return (short) doubleValue(objValue, 0);
	}

	public static short shortValue(Object objValue, short defaultValue) {
		return (short) doubleValue(objValue, defaultValue);
	}

	@SuppressWarnings("unchecked")
	public static Hashtable String2Hashtable(String s) {
		Hashtable<Object, Object> ht = new Hashtable<Object, Object>();
		String[] me = s.split(",");
		for (int i = 0; i < me.length; i++) {
			String[] kv = me[i].split("=");
			if (kv.length == 2) {
				kv[0] = DecodeMapEntry(kv[0]);
				kv[1] = DecodeMapEntry(kv[1]);
				ht.put(kv[0], kv[1]);
			}
		}
		return ht;
	}

	public static String stringValue(Object obj) {
		return stringValue(obj, "");
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

	private static String stringValue(Clob clob, String defaultValue) {
		if (clob == null) {
			return defaultValue;
		}
		try {
			StringBuffer clobString = new StringBuffer();
			String aux;
			BufferedReader reader = new BufferedReader(clob
					.getCharacterStream());
			while ((aux = reader.readLine()) != null) {
				clobString.append(aux);
			}
			return clobString.toString();
		} catch (Exception e) {
			logger.error("", e);
		}
		return defaultValue;
	}

	/*
	 * Converts a byte array to hex string
	 */
	public static String toHexString(byte[] block) {
		StringBuffer buf = new StringBuffer();
		int len = block.length;
		for (int i = 0; i < len; i++) {
			byte2hex(block[i], buf);
		}
		return buf.toString();
	}

	/*
	 * Converts a byte to hex digit and writes to the supplied buffer
	 */
	private static void byte2hex(byte b, StringBuffer buf) {
		char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		int high = ((b & 0xf0) >> 4);
		int low = (b & 0x0f);
		buf.append(hexChars[high]);
		buf.append(hexChars[low]);
	}
}
