package com.baselib.utlis;

public class StringUtils {

	public static boolean isEmpty(CharSequence str) {
		return str == null || str.length() == 0;
	}

	public static boolean isEmpty(String... strs) {
		if (strs == null) {
			return true;
		}

		for (String str : strs) {
			if ((str != null) && !str.isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean hasEmpty(String strs) {
		if (isEmpty(strs)) {
			return true;
		}

		for (int i = 0; i < strs.length(); i++) {
			char c = strs.charAt(i);
			if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
				return false;
			}
		}
		return true;
	}

}
