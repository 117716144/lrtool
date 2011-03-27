package com.base.core.util;


import java.util.HashMap;
import java.util.Map;

/**
 * @author salim at 2008-8-5 内存缓存管理器，用户常驻内存的数据的存储。不提供自动管理，用户需自行清理.
 */
public class MemoryCacheHelper {

	private MemoryCacheHelper() {
	}

	private static MemoryCacheHelper inst = null;
	private static Map<Object, Object> caches = new HashMap<Object, Object>();

	public static MemoryCacheHelper getInstance() {
		if (inst == null) {
			inst = new MemoryCacheHelper();
		}
		return inst;
	}

	/**
	 * @add by salim at 2008-8-5 <br>
	 * @param key
	 * @return
	 */
	public Object getValue(Object key) {
		Object v = null;
		if (caches.containsKey(key)) {
			v = caches.get(key);
		}
		return v;
	}

	/**
	 * @add by salim at 2008-8-5 <br>
	 * @param keys
	 * @return
	 */
	public Object[] getMultiArray(Object[] keys) {
		if (keys == null || keys.length == 0) {
			return null;
		}
		Object[] vs = new Object[keys.length];
		for (int i = 0; i < keys.length; i++) {
			vs[i] = getValue(keys[i]);
		}
		return vs;
	}
	
	public boolean checkMemory() {
		long max = Runtime.getRuntime().maxMemory(); // 最大可用内存
		long total = Runtime.getRuntime().totalMemory(); // 目前已用内存
		long free = Runtime.getRuntime().freeMemory(); // 从操作系统搜刮过来的内存中，空余的内存。不一定到达最大可用内存了。
		if ((max - total) / (max + 0.0f) < 0.1f && free / (max + 0.0f) < 0.1f) { // 剩余内存少于10%
			return false;
		}
		return true;
	}

	/**
	 * @add by salim at 2008-8-5 <br>
	 * @param key
	 * @param value
	 */
	public void setValue(Object key, Object value) {
		if (!checkMemory()) {
			emptyMemory();
		}
		if (value == null || key == null) {
			return;
		}
		caches.put(key, value);
	}

	/**
	 * @add by salim at 2008-8-5 <br>
	 * @param key
	 */
	public void remove(Object key) {
		caches.remove(key);
	}

	/**
	 * @add by salim at 2008-8-5 <br>
	 */
	public void removeAll() {
		caches.clear();
	}

	/**
	 * @add by salim at 2008-8-5 <br>
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void emptyMemory() {
		this.removeAll();
	}

}
