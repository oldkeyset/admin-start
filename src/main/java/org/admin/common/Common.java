package org.admin.common;

import org.admin.utils.UUIDUtil;

public class Common {
	
	public static boolean checkPeerid(String peerid) {
		if (peerid != null && peerid.length() == 40) {
			String headStr = peerid.substring(0, 4);
			String num1 = UUIDUtil.hashNum(headStr, 9);
			String num2 = peerid.substring(36, 37);
			return num1.equals(num2);
		}
		return false;
	}
}
