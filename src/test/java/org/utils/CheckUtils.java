package org.utils;

import java.io.ByteArrayOutputStream;

import org.admin.common.Common;
import org.admin.common.XCaptcha;
import org.admin.utils.UUIDUtil;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class CheckUtils {
	
	@Test
	public void checkCode() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		String checkcode = XCaptcha.getInstance().getChallangeAndWriteImage(baos);
		String base64bytes = "data:image/png;base64,"+Base64.encodeBase64String(baos.toByteArray());
		System.out.println(checkcode);
		System.out.println(base64bytes.length());
	}
	@Test
	public void checkPeerid() {
		StringBuffer peeridSB = new StringBuffer();
		String headStr = UUIDUtil.randomString(4, false).toLowerCase();
		peeridSB.append(headStr);
		peeridSB.append(UUIDUtil.md5("admin" + System.currentTimeMillis()).toLowerCase());
		peeridSB.append(UUIDUtil.hashNum(headStr, 9));
		peeridSB.append(UUIDUtil.randomString(3, false).toLowerCase());
		System.out.println(peeridSB);
		boolean flag = Common.checkPeerid("95lda20993db410d3efe73e7885e1babab626a2u");
		System.out.println(flag);
	}

}
