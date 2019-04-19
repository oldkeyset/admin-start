package org.admin.controller.common;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.admin.common.XCaptcha;
import org.admin.pojo.User;
import org.admin.systemconfig.RedisConfig;
import org.admin.utils.JSONResult;
import org.admin.utils.RedisOperator;
import org.admin.utils.UUIDUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonController {

	@Autowired
	private RedisOperator redis;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JSONResult login(String username,String password,String checkcode) {
		System.out.println(username);
		System.out.println(password);
		System.out.println(checkcode);
		String redisKey = RedisConfig.SESSION_ID + username;
		String sessionId = redis.get(redisKey);
		if(null == sessionId) {
			redis.set(redisKey, UUIDUtil.makeSessionId(), RedisConfig.redisSeconds.EXPIRE_DAY_7);
		}
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("sessionid", sessionId);
		map.put("username", username);
		return JSONResult.ok(map);
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public JSONResult regist(User user) {

		return JSONResult.ok("success");
	}

	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
	public JSONResult captcha(String peerid) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		String checkcode = XCaptcha.getInstance().getChallangeAndWriteImage(baos);
		String redisKey = RedisConfig.LOGIN_CODE + peerid;		
		redis.set(redisKey, checkcode,RedisConfig.redisSeconds.EXPIRE_MIN_1);
		String base64bytes = "data:image/png;base64," + Base64.encodeBase64String(baos.toByteArray());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("base64", base64bytes);
		map.put("code", checkcode);
		return JSONResult.ok(map);
	}

	@RequestMapping("/peerid")
	public static JSONResult createPeerid(String clienttype) {
		// 用户进入访问页面就有
		StringBuffer peeridSB = new StringBuffer();
		String headStr = UUIDUtil.randomString(4, false).toLowerCase();
		peeridSB.append(headStr);
		peeridSB.append(UUIDUtil.md5(clienttype + System.currentTimeMillis()).toLowerCase());
		peeridSB.append(UUIDUtil.hashNum(headStr, 9));
		peeridSB.append(UUIDUtil.randomString(3, false).toLowerCase());
		return JSONResult.ok(peeridSB.toString());
	}
}
