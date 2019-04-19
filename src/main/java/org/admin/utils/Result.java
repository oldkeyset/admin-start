package org.admin.utils;

import org.admin.systemconfig.ErrorCode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Result {

	// 响应业务状态
	private Integer status;

	// 响应消息
	private String msg;

	// 响应中的数据
	private Object data;

	private String ok; // 不使用
	
	private static String jsonResult(Object obj) {
		return JSONObject.toJSONString(obj,SerializerFeature.DisableCircularReferenceDetect);
	}

	public static String build(Integer status, String msg, Object data) {
		Result json = new Result(status, msg, data);
		return jsonResult(json);
	}

	public static String ok(Object data) {
		Result json = new Result(data);
		return jsonResult(json);
	}

	public static String ok() {
		return jsonResult(null);
	}

	public static String errorMsg(String msg) {
		Result json = new Result(ErrorCode.NOK, msg, null);
		return jsonResult(json);
	}

	public static String errorMsg(final Integer status) {
		Result json = new Result(status, ErrorCode.checkErrorMsg(status), null);
		return jsonResult(json);
	}

	public static String errorMsg(Integer status, String msg) {
		Result json = new Result(status, msg, null);
		return jsonResult(json);
	}

	public static String errorMap(Integer status, Object data) {
		Result json = new Result(status, "error", data);
		return jsonResult(json);
	}

	public Result() {

	}

	public Result(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public Result(Object data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	public Boolean isOK() {
		return this.status == 200;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}
}
