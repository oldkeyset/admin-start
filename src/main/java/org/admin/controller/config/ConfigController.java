package org.admin.controller.config;

import org.admin.service.menu.MenuService;
import org.admin.utils.JSONResult;
import org.admin.utils.RedisOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/config")
public class ConfigController {

	@Autowired
	private RedisOperator redis;

	@Autowired
	private MenuService menuService;

	@RequestMapping(value="/menu_list",method=RequestMethod.GET)
	public JSONResult menuList() {

		Object list = null;
		String redisData = redis.get("el-menu");
		if (StringUtils.isEmpty(redisData)) {
			list = menuService.queryMenuList();
		} else {
			list = JSONObject.parse(redisData);
		}
		redis.set("el-menu", JSONObject.toJSONString(list), 300);
		return JSONResult.ok(list);
	}
	
}
