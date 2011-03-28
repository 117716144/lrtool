package com.base.core.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 字符串的(编码/加密)与(解码/解密)。
 * 
 * 规则：
 * 
 * 在Base64中，码表是由[A-Z,a-z,0-9,+,/,=(pad)]组成的。 而在这里，码表由[a-z,2-7]组成的：
 * ----------------------------------------------- a b c d e f g h i j k l m n o
 * p q r 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
 * ----------------------------------------------- s t u v w x y z 2 3 4 5 6 7
 * 18 19 20 21 22 23 24 25 26 27 28 29 30 31
 * ------------------------------------------------
 * 
 * 在Base64中，是将二进制连成一串，然后再按6位来分割，分割完后在前面补0，这个地球人都知道，不多说了。
 * 而在这里，在分割的那一步稍微有变动，是按5位来分割，如果刚好够分，那就好了，如果不够，那咋办呢？
 * 
 * 在Base64中，是用"="来解决的吧。 而在这里，就是在前面补0，然后在后面再补零。
 * 
 * 例如：字符串 "aaa"，(编码/加密)后是 "mfqwc"
 * 
 * 二进制：01100001 01100001 01100001 转换后：(000)01100 (000)00101 (000)10000
 * (000)10110 (000)0001(0) 十进制： 12 5 16 22 2 码表对应： m f q w c
 * 
 * (解码/解密)就更简单了：
 * 
 * 码表对应： m f q w c 十进制： 12 5 16 22 2 二进制： 00001100 00000101 00010000 00010110
 * 00000010 去前0后：01100 00101 10000 10110 00010 合并后： 0110000101100001011000010
 * 
 * 然后把合并后的串的长度除一下8，发现多了个0：
 * 
 * 二进制：01100001 01100001 01100001 0
 * 
 * 多了就算了，不要了（其实是在{编码/加密}的分割时候，在分剩的余数的后面补的0）。 然后再将 byte[] 转回字符串，OK！又见"aaa"了。
 * 
 * 有一点值得注意的，UTF-8、GBK、GB18030 一般都没什么问题， 但是 GB2312 可能字符集不够丰富，繁体字在decode的时候成问号了。
 * 
 * 
 * @author gembler
 * @version 2008-12-3 下午03:01:50
 * 
 */

public class TaoBaoKeyUtil {

	/**
	 * 码表
	 */
	private final static String CODEC_TABLE = "abcdefghijklmnopqrstuvwxyz234567";

	/**
	 * 表示5bit的字节
	 */
	public final static int FIVE_BIT = 5;

	/**
	 * 表示8bit的字节
	 */
	public final static int EIGHT_BIT = 8;

	/**
	 * 表示二进制
	 */
	public final static int BINARY = 2;

	/**
	 * (编码/加密)字符串，采用默认语言环境的 character set。
	 * 
	 * @author gembler
	 * @version 2008-12-3 下午03:14:36
	 * 
	 * @param keys
	 *            需要(编码/加密)的字符串
	 * 
	 * @return (编码/加密)后的字符串
	 */
	public static String encode(String keys) {

		return encode(keys, null);

	}

	/**
	 * (编码/加密)字符串
	 * 
	 * @author gembler
	 * @version 2008-12-3 下午03:14:39
	 * 
	 * @param keys
	 *            需要(编码/加密)的字符串
	 * @param characterSet
	 *            字符集
	 * 
	 * @return (编码/加密)后的字符串
	 */
	public static String encode(String keys, String characterSet) {

		if (keys == null || "".equals(keys)) {
			return "";
		}

		byte[] keyBytes = null;

		if (characterSet == null || characterSet.length() < 1) {

			// 采用默认语言环境的 character set。
			keyBytes = keys.getBytes();

		} else {

			try {

				// 采用指定的 character set。
				keyBytes = keys.getBytes(characterSet);

			} catch (UnsupportedEncodingException e) {
				// ignore...
			}

		}
		return encode(keyBytes);
	}

	/**
	 * (编码/加密)字节数组
	 * 
	 * @author gembler
	 * @version 2008-12-3 下午03:14:43
	 * 
	 * @param keyBytes
	 *            需要(编码/加密)的字节数组
	 * 
	 * @return (编码/加密)后的字符串
	 */
	private static String encode(byte[] keyBytes) {

		if (keyBytes == null || keyBytes.length < 1) {

			return "";

		}

		/*
		 * 合并二进制码， 如： 00101010 11010011 00101101 10100011 to
		 * 00101010110100110010110110100011
		 */

		StringBuilder mergrd = new StringBuilder();

		for (int i = 0; i < keyBytes.length; i++) {

			FormatUtil.formatBinary(keyBytes[i], mergrd);

		}

		/*
		 * 以5个bit为单位，计算能分多少组， 如： 00101010110100110010110110100011 to 00101 01011
		 * 01001 10010 11011 01000 11 | （这个11为余下的位）
		 */

		int groupCount = mergrd.length() / FIVE_BIT;

		// 计算余下的位数
		int lastCount = mergrd.length() % FIVE_BIT;

		// 类似数据分页的算法，有余数的情况下需要加 1。
		if (lastCount > 0) {

			groupCount += 1;

		}

		/*
		 * (编码/加密)
		 */

		StringBuilder sbEncoded = new StringBuilder();

		// 循环所需的条件
		int forMax = groupCount * FIVE_BIT;

		// 每次递增5位来截取
		for (int i = 0; i < forMax; i += FIVE_BIT) {

			// 结束点
			int end = i + FIVE_BIT;

			/*
			 * 如果结束点比已合并的二进制码串的长度要大， 相当于有余数， 并且表示当前循环到了（已合并的二进制码串的长度 %
			 * FIVE_BIT）的那一截。
			 */

			// 标记是否到了余数的那一截
			boolean flag = false;

			if (end > mergrd.length()) {

				/*
				 * 如果结束点比已合并的二进制码串的长度要大， 结束点需要被重设为： 已合并的二进制码串的长度，等价于（i +
				 * lastCount). 并且重设标记。
				 */

				end = (i + lastCount);

				flag = true;

			}

			// 截取
			String strFiveBit = mergrd.substring(i, end);

			// 截取后从二进制转为十进制
			int intFiveBit = Integer.parseInt(strFiveBit, BINARY);

			if (flag) {

				/*
				 * 如果结束点比已合并的二进制码串的长度要大， 或者是到了余数的那一截： 需要左移操作，假设余下的二进制位为：11，
				 * 那么需要从后面补0，左移操作后为 (000)11(000)
				 */

				intFiveBit <<= (FIVE_BIT - lastCount);

			}

			// 利用该十进制数作为码表的索引获取对应的字符，并追加到sbEncoded
			sbEncoded.append(CODEC_TABLE.charAt(intFiveBit));

		}

		return sbEncoded.toString();

	}

	/**
	 * (解码/解密)字符串，采用默认语言环境的 character set。
	 * 
	 * @author gembler
	 * @version 2008-12-3 下午03:14:57
	 * 
	 * @param code
	 *            需要(解码/解密)的字符串
	 * 
	 * @return (解码/解密)后的字符串
	 */
	public static String decode(String code) {

		return decode(code, null);

	}

	/**
	 * (解码/解密)字符串
	 * 
	 * @author gembler
	 * @version 2008-12-3 下午03:15:00
	 * 
	 * @param code
	 *            需要(解码/解密)的字符串
	 * @param characterSet
	 *            字符集
	 * 
	 * @return (解码/解密)后的字符串
	 */
	public static String decode(String code, String characterSet) {

		if (code == null || code.length() < 1) {

			return "";

		}

		/*
		 * 拆除每一个字符，从码表里获取相应的索引。
		 */

		StringBuilder sbBinarys = new StringBuilder();

		for (int i = 0; i < code.length(); i++) {

			// 从码表里获取相应的索引
			int index = getCodecTableIndex(code.charAt(i));

			// 将十进制的索引转换为二进制串
			String indexBinary = Integer.toBinaryString(index);

			// 去掉前3个0，并且追加到sbBinarys
			FormatUtil.formatBinary(indexBinary, sbBinarys, FIVE_BIT);

		}

		/*
		 * 按8个bit拆分，剩下的余数扔掉。 扔掉的余数是在(编码/加密)的分割时候，在分剩的余数的后面补的0
		 */

		byte[] binarys = new byte[sbBinarys.length() / EIGHT_BIT];

		for (int i = 0, j = 0; i < binarys.length; i++) {

			// 每8个bit截取一份
			String sub = sbBinarys.substring(j, j += EIGHT_BIT);

			// 将截取下来的二进制串转换为十进制
			Integer intBinary = Integer.valueOf(sub, BINARY);

			binarys[i] = intBinary.byteValue();

		}

		String decoded = null;

		if (characterSet == null || characterSet.length() < 1) {

			// 采用默认语言环境的 character set。
			decoded = new String(binarys);

		} else {

			try {

				// 采用指定的 character set。
				return new String(binarys, characterSet);

			} catch (UnsupportedEncodingException e) {
				// ignore...
			}
		}
		return decoded;
	}

	/**
	 * 根据所给出的字符，遍历CODEC_TABLE，返回对应的下标。 如果没找到，则返回 -1。
	 * 
	 * @author gembler
	 * @version 2008-12-3 下午03:14:53
	 * 
	 * @param code
	 *            在CODEC_TABLE范围内的字符。
	 * 
	 * @return 字符在CODEC_TABLE里对应的下标，如果没找到，则返回 -1。
	 */
	private static int getCodecTableIndex(char code) {

		for (int i = 0; i < CODEC_TABLE.length(); i++) {

			if (CODEC_TABLE.charAt(i) == code) {

				return i;

			}

		}

		return -1;

	}

	/**
	 * 测试
	 * 
	 * @author gembler
	 * @version 2008-12-3 下午03:05:52
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			while (true) {

				System.out.print("输入字符号串：");

				String in = br.readLine();

				if ("exit".equalsIgnoreCase(in)) {
					break;
				}

				String enCode = TaoBaoKeyUtil.encode(in, "UTF-8");

				String deCode = TaoBaoKeyUtil.decode(enCode, "UTF-8");
				System.out.println();
				System.out.println("------------------------------test");
				System.out.println("original: " + in);
				System.out.println("encode: " + enCode);
				System.out.println("decode: " + deCode);
				System.out.println("------------------------------test");
				System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 格式化工具类
	 * 
	 * @author gembler
	 * @version 2008-12-3 下午03:01:50
	 */
	public static class FormatUtil {

		/**
		 * 格式化二进制。默认取8位，超过则截取，不足则补零。
		 * 格式：“00000000”，与NumberFormat的pattern：“########”类似。
		 * 
		 * @author gembler
		 * @version 2008-12-3 下午03:15:06
		 * 
		 * @param binary
		 *            需要格式化的字节。
		 * 
		 * @return 格式化后的字符串。
		 */
		public static String formatBinary(byte binary) {

			return formatBinary(binary, null).toString();

		}

		/**
		 * 格式化二进制，超过则截取，不足则补零。格式：“00000000”，与NumberFormat的pattern：“########”类似。
		 * 
		 * @author gembler
		 * @version 2008-12-3 下午03:15:09
		 * 
		 * @param binary
		 *            需要格式化的字节。
		 * @param bitCount
		 *            需要格式化的位数。
		 * 
		 * @return 格式化后的字符串。
		 */
		public static String formatBinary(byte binary, int bitCount) {

			return formatBinary(binary, null, bitCount).toString();

		}

		/**
		 * 格式化二进制，超过则截取，不足则补零。格式：“00000000”，与NumberFormat的pattern：“########”类似。
		 * 
		 * @author gembler
		 * @version 2008-12-3 下午03:15:12
		 * 
		 * @param binary
		 *            需要格式化的字节。
		 * @param toAppendTo
		 *            追加到的Builder。
		 * 
		 * @return 格式化后的StringBuilder。
		 */
		public static StringBuilder formatBinary(byte binary,
				StringBuilder toAppendTo) {

			return formatBinary(binary, toAppendTo, TaoBaoKeyUtil.EIGHT_BIT);
		}

		/**
		 * 格式化二进制，超过则截取，不足则补零。格式：“00000000”，与NumberFormat的pattern：“########”类似。
		 * 
		 * @author gembler
		 * @version 2008-12-3 下午03:15:16
		 * 
		 * @param binary
		 *            需要格式化的字节。
		 * @param toAppendTo
		 *            追加到的Builder。
		 * @param bitCount
		 *            需要格式化的位数。
		 * 
		 * @return 格式化后的StringBuilder。
		 */
		public static StringBuilder formatBinary(byte binary,
				StringBuilder toAppendTo, int bitCount) {

			String strBinary = Integer.toBinaryString(binary);

			return formatBinary(strBinary, toAppendTo, bitCount);
		}

		/**
		 * 格式化二进制，超过则截取，不足则补零。格式：“00000000”，与NumberFormat的pattern：“########”类似。
		 * 
		 * @author gembler
		 * @version 2008-12-3 下午03:15:20
		 * 
		 * @param binary
		 *            需要格式化的字节。
		 * 
		 * @return 格式化后的字符串。
		 */
		public static String formatBinary(String binary) {

			return formatBinary(binary, null).toString();

		}

		/**
		 * 格式化二进制，超过则截取，不足则补零。格式：“00000000”，与NumberFormat的pattern：“########”类似。
		 * 
		 * @author gembler
		 * @version 2008-12-3 下午03:15:24
		 * 
		 * @param binary
		 *            需要格式化的字节。
		 * @param bitCount
		 *            需要格式化的位数。
		 * 
		 * @return 格式化后的字符串。
		 */
		public static String formatBinary(String binary, int bitCount) {

			return formatBinary(binary, null, bitCount).toString();

		}

		/**
		 * 格式化二进制，超过则截取，不足则补零。格式：“00000000”，与NumberFormat的pattern：“########”类似。
		 * 
		 * @author gembler
		 * @version 2008-12-3 下午03:15:27
		 * 
		 * @param binary
		 *            需要格式化的字节。
		 * @param toAppendTo
		 *            追加到的Builder。
		 * 
		 * @return 格式化后的StringBuilder。
		 */
		public static StringBuilder formatBinary(String binary,
				StringBuilder toAppendTo) {

			return formatBinary(binary, toAppendTo, TaoBaoKeyUtil.EIGHT_BIT);

		}

		/**
		 * 格式化二进制，超过则截取，不足则补零。格式：“00000000”，与NumberFormat的pattern：“########”类似。
		 * 
		 * @author gembler
		 * @version 2008-12-3 下午03:15:31
		 * 
		 * @param binary
		 *            需要格式化的字节。
		 * @param toAppendTo
		 *            追加到的Builder。
		 * @param bitCount
		 *            追加到的Builder。
		 * 
		 * @return 格式化后的StringBuilder。
		 */
		public static StringBuilder formatBinary(String binary,
				StringBuilder toAppendTo, int bitCount) {

			if (binary == null || binary.length() < 1) {

				return toAppendTo;

			}

			if (toAppendTo == null) {

				toAppendTo = new StringBuilder();

			}

			if (binary.length() == bitCount) {

				toAppendTo.append(binary);

				return toAppendTo;

			}

			/*
			 * 前补0， 如： "100011" to "00100011"
			 */
			if (binary.length() < bitCount) {

				StringBuilder formatted = new StringBuilder();

				formatted.append(binary);

				do {

					formatted.insert(0, "0");

				} while (formatted.length() < bitCount);

				toAppendTo.append(formatted);

				return toAppendTo;

			}

			/*
			 * 截取， 如： "11111111111111111111111110100011" to "10100011"
			 */
			if (binary.length() > bitCount) {

				String intercepted = binary.substring(binary.length()
						- bitCount);

				toAppendTo.append(intercepted);

				return toAppendTo;

			}

			return toAppendTo;
		}

	}
}