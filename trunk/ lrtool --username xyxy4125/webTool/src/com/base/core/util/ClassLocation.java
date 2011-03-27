package com.base.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public class ClassLocation {
	public static final String BACKSLASH = "\\";

	public static final char CHR_BACKSLASH = '\\';

	public static final char CHR_COLON = ':';

	public static final char CHR_DOT = '.';

	public static final char CHR_SLASH = '/';

	public static final String COLON = ":";

	public static final String CSN_GB2312 = "GB2312";

	public static final String CSN_US_ASCII = "US-ASCII";

	public static final String CSN_UTF_16 = "UTF-16";

	public static final String CSN_UTF_8 = "UTF-8";

	public static final String DOT = ".";

	public static final String DOTCLASS = ".class";

	public static final String EMPTY_STRING = "";

	public static final String NewLine = "\n";

	public static final String PROTOCOL_FILE = "file";

	public static final String PROTOCOL_JAR = "jar";

	public static final String RNewLine = "\r\n";

	public static final String SLASH = "/";

	private final static org.apache.commons.logging.Log logger = org.apache.commons.logging.LogFactory
			.getLog(ClassLocation.class);

	@SuppressWarnings("unchecked")
	public static String getClassDir(Class cls) {
		try {
			URL url = getClassURL(cls);
			if (url == null) {
				return EMPTY_STRING;
			}
			String classpath = url.getPath();
			int nl = cls.getName().length() + DOTCLASS.length();
			int pl = classpath.length();
			int i_cut_start = 0;
			int i_cut_end = pl - nl;
			classpath = classpath.substring(i_cut_start, i_cut_end);
			if (url.getProtocol().equalsIgnoreCase(PROTOCOL_JAR)) {
				pl = i_cut_end - 1;
				classpath = classpath.substring(0, pl); // cut the last slash
				if (classpath.startsWith(PROTOCOL_FILE + COLON)) {
					i_cut_start = PROTOCOL_FILE.length() + COLON.length();
				}
				i_cut_end = classpath.lastIndexOf(SLASH);
				classpath = classpath.substring(i_cut_start, i_cut_end);
			}
			if (!classpath.endsWith(SLASH)) {
				classpath += SLASH;
			}
			return URLDecoder.decode(classpath, CSN_UTF_8);
		} catch (Exception e) {
			logger.error("", e);
		}
		return EMPTY_STRING;
	}

	@SuppressWarnings("unchecked")
	public static String getClassPath(Class cls) {
		try {
			URL url = getClassURL(cls);
			if (url == null) {
				return EMPTY_STRING;
			}
			String classpath = url.getPath();
			int nl = cls.getName().length() + DOTCLASS.length();
			int pl = classpath.length();
			int i_cut_start = 0;
			int i_cut_end = pl - nl;
			classpath = classpath.substring(i_cut_start, i_cut_end);
			if (classpath.startsWith(PROTOCOL_FILE + COLON)) {
				i_cut_start = PROTOCOL_FILE.length() + COLON.length();
				classpath = classpath.substring(i_cut_start);
			}
			if (classpath.endsWith(SLASH)) {
				classpath = classpath.substring(0, classpath.length() - 1);
			}
			return URLDecoder.decode(classpath, CSN_UTF_8);
		} catch (Exception e) {
			logger.error("", e);
		}
		return EMPTY_STRING;
	}

	@SuppressWarnings("unchecked")
	public static URL getClassURL(Class cls) {
		try {
			ClassLoader cl = ClassLocation.class.getClassLoader();
			String classname = cls.getName();
			String findresname = "/" + classname.replace('.', '/') + DOTCLASS;
			URL url = cl.getResource(findresname);
			if (url == null) {
				int i = classname.lastIndexOf(DOT);
				findresname = classname.substring(i + 1) + DOTCLASS;
				url = cls.newInstance().getClass().getResource(findresname);
			}
			return url;
		} catch (Exception e) {
			// Do nothing
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static InputStream getFileInputStream(Class PathRelateClass,
			String RelateFilePath) throws IOException {
		String s = getClassPath(PathRelateClass);
		if (s.endsWith("!")) {
			// cut the jar file
			int i = s.lastIndexOf(SLASH);
			String filesamejardir = s.substring(0, i) + '/' + RelateFilePath;
			if (new File(filesamejardir).exists()) {
				return new FileInputStream(filesamejardir);
			}
			// is a jar file, cut the "!"
			s = s.substring(0, s.length() - 1);
			JarFile jf = new JarFile(s);
			if (RelateFilePath.startsWith("/")) {
				RelateFilePath = RelateFilePath.substring(1);
			}
			ZipEntry ze = jf.getEntry(RelateFilePath);
			if (ze != null) {
				// find file in jar
				return jf.getInputStream(ze);
			} else {
				return null;
			}
		}

		s = s + '/' + RelateFilePath;
		s = formatPath(s);
		return new FileInputStream(s);
	}

	public static InputStream getFileInputStream(String relateFilePath)
			throws IOException {
		return getFileInputStream(ClassLocation.class, relateFilePath);
	}

	private static String formatPath(String path) {
		return path.replaceAll(SLASH + SLASH, SLASH);
	}
}
