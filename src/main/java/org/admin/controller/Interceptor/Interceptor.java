package org.admin.controller.Interceptor;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.admin.common.Common;
import org.admin.systemconfig.ErrorCode;
import org.admin.systemconfig.RedisConfig;
import org.admin.utils.JSONResult;
import org.admin.utils.JsonUtils;
import org.admin.utils.RedisOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor implements HandlerInterceptor {

	@Autowired
	private RedisOperator redis;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String peerid = request.getParameter("peerid");
		
		System.out.println("peerid :"+peerid);
		System.out.println(Common.checkPeerid(peerid));
		
		if (!Common.checkPeerid(peerid)) {
			returnErrorResponse(response, JSONResult.errorMsg(ErrorCode.TOKEN_ERROR));
			return false;
		}
		
		String username = request.getParameter("username");
		String sesssionId = request.getParameter("sessionid");
		
		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(sesssionId)) {
			String uniqueSessionId = redis.get(RedisConfig.SESSION_ID + ":" + username);
			if (StringUtils.isEmpty(uniqueSessionId) && StringUtils.isBlank(uniqueSessionId)) {
				returnErrorResponse(response, JSONResult.errorMsg(ErrorCode.INFO_OUTDATED));
				return false;
			}
			if (!uniqueSessionId.equals(sesssionId)) {
				returnErrorResponse(response, JSONResult.errorMsg(ErrorCode.THE_ACCOUNT_IS_CROWDED_OUT));
				return false;
			}
		} else {
			returnErrorResponse(response, JSONResult.errorMsg(ErrorCode.SESSIONID_INVALID));
			return false;
		}
		return true;
	}

	public void returnErrorResponse(HttpServletResponse response, JSONResult result)
			throws IOException, UnsupportedEncodingException {
		OutputStream out = null;
		try {
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/json");
			response.setHeader("/**","*");
			out = response.getOutputStream();
			out.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
			out.flush();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
