package org.admin.utils;

import org.admin.systemconfig.ErrorCode;

public class JSONResult {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;
    
    private String ok;	// 不使用

    public static JSONResult build(Integer status, String msg, Object data) {
        return new JSONResult(status, msg, data);
    }

    public static JSONResult ok(Object data) {
        return new JSONResult(data);
    }

    public static JSONResult ok() {
        return new JSONResult(null);
    }
    
    public static JSONResult errorMsg(String msg) {
    	return new JSONResult(ErrorCode.NOK, msg, null);
    }
    
    public static JSONResult errorMsg(Integer status) {
    	return new JSONResult(status, ErrorCode.checkErrorMsg(status), null);
    }
    
    public static JSONResult errorMsg(Integer status,String msg) {
        return new JSONResult(status, msg, null);
    }
    
    public static JSONResult errorMap(Integer status,Object data) {
        return new JSONResult(status, "error", data);
    }

    public JSONResult() {

    }

    public JSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JSONResult(Object data) {
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
