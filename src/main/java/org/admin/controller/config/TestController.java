package org.admin.controller.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.admin.controller.common.CommonController;
import org.admin.utils.JSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
@RestController
public class TestController {
	
	private static Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public JSONResult testErr(Integer errCode) {
		logger.debug(errCode + "");
		return JSONResult.errorMsg(errCode);
	}	
	
	@RequestMapping(value = "/testToken", method = RequestMethod.POST)
	public JSONResult testToken(@RequestBody String requestData, HttpServletRequest request) {
		
		JSONObject obj = JSONObject.parseObject(requestData);

		if (obj == null || obj.size() == 0) {
			return JSONResult.errorMsg("USER_NULL");
		}

		Map<String, String> data = new HashMap<String, String>();
		String token = request.getHeader("token");
		if (token == null) {
			return JSONResult.errorMsg("TOKEN_NULL");
		}
		data.put("success", "1");
		data.put("msg", "请求成功!");
		return JSONResult.ok(data);
	}

	@RequestMapping(value = "/test.html", method = RequestMethod.POST)
	public String test(String name, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-type", "application/x-www-form-urlencoded");
		System.out.println(name);
		return "success";
	}
	
	@RequestMapping(value="/testPut",method = RequestMethod.PUT)
	public JSONResult testPut(@RequestBody String requestData,String password) {
		
		JSONObject obj = JSONObject.parseObject(requestData);
		
		Map<String, Object> map = new HashMap<String , Object>();
		map.put("userId", obj.getInteger("userId"));
		map.put("username", obj.getString("username"));
		map.put("password", obj.getString("password"));
		
		List<Object> list = new ArrayList<>();
		list.add(map);
		
		Map<String, Object> userMap = new HashMap<>();
		userMap.put("users", list);
		
		return JSONResult.ok(userMap);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public JSONResult delete(@RequestBody String requestData) {
		
		JSONObject obj = JSONObject.parseObject(requestData);
		Integer userId = obj.getInteger("userId");
		
		Map<String, Object> user = new HashMap<String,Object>();
		user.put("userId", userId);
		user.put("username", userId);
		
		List<Object> list = new ArrayList<Object>();
		list.add(user);
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("users", list);
		
		return JSONResult.ok(data);
	}	
}
