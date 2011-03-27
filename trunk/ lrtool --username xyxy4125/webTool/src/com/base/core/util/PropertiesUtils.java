package com.base.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public class PropertiesUtils {
	private static int commit = 0;
	private final static int commitsize = 100;

	private final static int defaultRefreshInterval = 60;
	public final static String REFRESH_INTERVAL = "configuration.refresh.interval";

	private static PropertiesUtils inst = null;

	private final static org.apache.commons.logging.Log logger = org.apache.commons.logging.LogFactory
			.getLog(PropertiesUtils.class);

	public final static PropertiesUtils getInstance() {
		if (inst == null) {
			inst = new PropertiesUtils();
		}
		return inst;
	}

	@SuppressWarnings("unchecked")
	public final static PropertiesUtils getInstance(Class referenceClass) {
		PropertiesUtils pu = getInstance();
		pu.referenceClass = referenceClass;
		return pu;
	}

	public static void main(String[] args) throws Exception {
		{
			String file = "/net/gsu/commons/test/messages.properties";
			PropertiesUtils pu = PropertiesUtils.getInstance();
			Enumeration<String> keys = pu.getKeys(file);
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				System.out.println("[KEY:" + key + "] - "
						+ pu.getValue(file, key, "<NULL>"));
			}
		}
		System.out.println("Please press enter after several second");
		System.in.read();
		{
			String file = "/net/gsu/commons/test/messages.properties";
			PropertiesUtils pu = PropertiesUtils.getInstance();
			Enumeration<String> keys = pu.getKeys(file);
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				System.out.println("[KEY:" + key + "] - "
						+ pu.getValue(file, key, "<NULL>"));
			}
		}
		if (1 == 1) {
			System.exit(0);
		}
		boolean immediately = true;
		{
			String file = "/test1.properties";
			String key = "nameOfGx";
			String defaultValue = "salim";
			PropertiesUtils pu = PropertiesUtils.getInstance();
			String ret = pu.getValue(file, key, defaultValue);
			System.out.println(ret);
			ret += " Success";
			pu.setValue(file, key, ret, immediately);
		}
		{
			String file = "/test2.properties";
			String key = "numberOfGx";
			int defaultValue = 1;
			PropertiesUtils pu = PropertiesUtils.getInstance();
			int ret = pu.getIntValue(file, key, defaultValue);
			System.out.println(ret);
			ret++;
			pu.setIntValue(file, key, ret, immediately);
		}
		{
			String file = "/test3.properties";
			String key = "BirthdayOfGx";
			String defaultValue = new Timestamp(new Date().getTime())
					.toString();
			PropertiesUtils pu = PropertiesUtils.getInstance();
			Date ret = pu.getDateTimeValue(file, key, defaultValue);
			System.out.println(ret);
			ret = new Date();
			pu.setDateTimeValue(file, key, ret, immediately);
		}
	}

	// every five minue save
	@SuppressWarnings("unchecked")
	private Class referenceClass = PropertiesUtils.class;

	private PropertiesUtils() {
	}

	public boolean getBooleanValue(String file, String key, boolean defaultValue) {
		return CastType.booleanValue(getValue(file, key, String
				.valueOf(defaultValue)));
	}

	public Date getDateTimeValue(String file, String key, String defaultValue) {
		try {
			return CastType.dtparse(getValue(file, key, defaultValue));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public byte getDoubleValue(String file, String key, byte defaultValue) {
		return CastType.byteValue(getValue(file, key, String
				.valueOf(defaultValue)), defaultValue);
	}

	public double getDoubleValue(String file, String key, double defaultValue) {
		return CastType.doubleValue(getValue(file, key, String
				.valueOf(defaultValue)), defaultValue);
	}

	public float getFloatValue(String file, String key, float defaultValue) {
		return CastType.floatValue(getValue(file, key, String
				.valueOf(defaultValue)), defaultValue);
	}

	public int getIntValue(String file, String key, int defaultValue) {
		return CastType.intValue(getValue(file, key, String
				.valueOf(defaultValue)), defaultValue);
	}

	public Enumeration<String> getKeys(String file) {
		Vector<String> ret = new Vector<String>();
		Enumeration<Object> _enum = loadPropertiesWithCache(file).keys();
		while (_enum.hasMoreElements()) {
			ret.add(String.valueOf(_enum.nextElement()));
		}
		return ret.elements();
	}

	public long getLongValue(String file, String key, long defaultValue) {
		return CastType.longValue(getValue(file, key, String
				.valueOf(defaultValue)), defaultValue);
	}

	/**
	 * @return the referenceClass
	 */
	@SuppressWarnings("unchecked")
	public Class getReferenceClass() {
		return referenceClass;
	}

	public String getValue(String file, String key, String defaultValue) {
		String source = loadPropertiesWithCache(file).getProperty(key,
				defaultValue);
		return source;
	}

	public Properties loadPropertiesWithCache(String file) {
		long time = System.currentTimeMillis();
		String cachekey = "file:///" + file + "";
		Properties props = (Properties) MemoryCacheHelper.getInstance()
				.getValue(cachekey);
		Long timeout = (Long) MemoryCacheHelper.getInstance().getValue(
				cachekey + "/timeout");
		if (props == null || (timeout != null && timeout < time)) {
			props = new Properties();
			InputStream is = null;
			try {
				try {
					is = new FileInputStream(file);
				} catch (FileNotFoundException e) {
					try {
						is = ClassLocation.getFileInputStream(
								getReferenceClass(), file);
					} catch (FileNotFoundException e1) {
						is = getClass().getResourceAsStream(file);
					}
				}
			} catch (IOException e1) {
				logger.error("??Exception Happen??", e1);
			}
			if (is != null)
				try {
					props.load(is);
					int refresh = CastType.intValue(props
							.getProperty(REFRESH_INTERVAL),
							defaultRefreshInterval) * 1000;
					MemoryCacheHelper.getInstance().setValue(cachekey, props);
					MemoryCacheHelper.getInstance().setValue(
							cachekey + "/timeout", time + refresh);
				} catch (IOException e) {
					logger.error("", e);
				} finally {
					try {
						is.close();
					} catch (IOException e) {
						logger.error("", e);
					}
				}
		}
		return props;
	}

	public void setBooleanValue(String file, String key, boolean value) {
		setBooleanValue(file, key, value, false);
	}

	public void setBooleanValue(String file, String key, boolean value,
			boolean immediately) {
		setValue(file, key, String.valueOf(value), immediately);
	}

	public void setByteValue(String file, String key, byte value) {
		setByteValue(file, key, value, false);
	}

	public void setByteValue(String file, String key, byte value,
			boolean immediately) {
		setValue(file, key, String.valueOf(value), immediately);
	}

	public void setDateTimeValue(String file, String key, Date value) {
		setDateTimeValue(file, key, value, false);
	}

	public void setDateTimeValue(String file, String key, Date value,
			boolean immediately) {
		setValue(file, key, new Timestamp(value.getTime()).toString(),
				immediately);
	}

	public void setDoubleValue(String file, String key, double value) {
		setDoubleValue(file, key, value, false);
	}

	public void setDoubleValue(String file, String key, double value,
			boolean immediately) {
		setValue(file, key, String.valueOf(value), immediately);
	}

	public void setFloatValue(String file, String key, float value) {
		setFloatValue(file, key, value, false);
	}

	public void setFloatValue(String file, String key, float value,
			boolean immediately) {
		setValue(file, key, String.valueOf(value), immediately);
	}

	public void setIntValue(String file, String key, int value) {
		setIntValue(file, key, value, false);
	}

	public void setIntValue(String file, String key, int value,
			boolean immediately) {
		setValue(file, key, String.valueOf(value), immediately);
	}

	public void setLongValue(String file, String key, long value) {
		setLongValue(file, key, value, false);
	}

	public void setLongValue(String file, String key, long value,
			boolean immediately) {
		setValue(file, key, String.valueOf(value), immediately);
	}

	/**
	 * @param referenceClass
	 *            the referenceClass to set
	 */
	@SuppressWarnings("unchecked")
	public void setReferenceClass(Class referenceClass) {
		this.referenceClass = referenceClass;
	}

	public void setValue(String file, String key, String value,
			boolean immediately) {
		String cachekey = "file:///" + file + "";
		Properties props = (Properties) MemoryCacheHelper.getInstance()
				.getValue(cachekey);
		if (props == null) {
			props = new Properties();
			if (file.startsWith("/")) {
				InputStream is = getClass().getResourceAsStream(file);
				if (is==null) {
					is = ClassLoader.getSystemClassLoader()
							.getResourceAsStream(file);
				}
				if (is != null)
					try {
						props.load(is);
					} catch (IOException e) {
						logger.error("read io error of file:" + file, e);
					} finally {
						try {
							is.close();
						} catch (IOException e) {
							logger.error("", e);
						}
					}
			} else {
				File f = new File(file);
				if (f.exists()) {
					InputStream is = null;
					try {
						is = new FileInputStream(f);
						props.load(is);
					} catch (FileNotFoundException e) {
						logger.error("not found file:" + file, e);
					} catch (IOException e) {
						logger.error("read io error of file:" + file, e);
					} finally {
						try {
							if (is != null)
								is.close();
						} catch (IOException e) {
							logger.error("", e);
						}
					}
				}
			}
		}
		// set key
		props.setProperty(key, value);
		// cache key
		MemoryCacheHelper.getInstance().setValue(cachekey, props);
		MemoryCacheHelper.getInstance().setValue(cachekey + "/timeout",
				System.currentTimeMillis());
		if (immediately || commit > commitsize) {
			File f = new File(file);
			if (file.startsWith("/")) {
				String path = ClassLocation.getClassPath(getReferenceClass());
				f = new File(path + file);
			}
			File dir = f.getParentFile();
			if (!dir.exists()) {
				dir.mkdirs();
			}
			OutputStream os = null;
			try {
				os = new FileOutputStream(f);
				props.store(os, getClass().getName());
				commit = 0;
			} catch (FileNotFoundException e) {
				logger.error("not found file:" + file, e);
			} catch (IOException e) {
				logger.error("read io error of file:" + file, e);
			} finally {
				if (os != null)
					try {
						os.close();
					} catch (IOException e) {
						logger.error("FileOutputStream close Error <" + file
								+ ">", e);
					}
			}
		} else {
			commit++;
		}

	}

}
