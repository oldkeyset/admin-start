package org.admin.systemconfig;

public class ErrorCode {

	private ErrorCode() {}
	
	public static final int SYSTEM_ERROR = 500;

	/** 登录态过期 */
	public static final int INFO_OUTDATED = 2051;
	/** 账号在异地登陆 */
	public static final int THE_ACCOUNT_IS_CROWDED_OUT = 2052;

	public static final int OK = 200;
	/** 通配异常 */
	public static final int NOK = -1;

	public static final int REQUEST_ERROR = 4001;
	public static final int METHOD_ERROR = 4002;
	public static final int PARAMETER_ERROR = 4003;
	public static final int VALIDATION_ERROR = 4004;
	public static final int TOKEN_ERROR = 4005;

	public static final int INTERNAL_ERROR = 4000;
	public static final int SERVICE_BUSY = 4009;

	public static final int INFO_NULL = 4010;
	/** 未登陆操作 */
	public static final int SESSIONID_INVALID = 4101;
	public static final int USERNAME_ERROR = 4102;
	public static final int PASSWORD_ERROR = 4103;
	public static final int PASSWORD_UNSET = 4106;

	public static final int ACCOUNT_NULL = 4107;
	public static final int ACCOUNT_EXISTED = 4108;
	public static final int ACCOUNT_BLOCKED = 4109;

	public static final int NO_PERMISSION = 4120;

	public static String checkErrorMsg(final int status) {
		String errMsg = "";
		switch (status) {
		case 500:
			errMsg = "SYSTEM_ERROR";
			break;
		case 2051:
			errMsg = "INFO_OUTDATED";
			break;
		case 2052:
			errMsg = "THE_ACCOUNT_IS_CROWDED_OUT";
			break;
		case 4001:
			errMsg = "REQUEST_ERROR";
			break;
		case 4002:
			errMsg = "METHOD_ERROR";
			break;
		case 4003:
			errMsg = "PARAMETER_ERROR";
			break;
		case 4004:
			errMsg = "VALIDATION_ERROR";
			break;
		case 4005:
			errMsg = "TOKEN_ERROR";
			break;
		case 4000:
			errMsg = "INTERNAL_ERROR";
			break;
		case 4009:
			errMsg = "SERVICE_BUSY";
			break;
		case 4101:
			errMsg = "SESSIONID_INVALID";
			break;
		case 4102:
			errMsg = "USERNAME_ERROR";
			break;
		case 4103:
			errMsg = "PASSWORD_ERROR";
			break;
		case 4106:
			errMsg = "PASSWORD_UNSET";
			break;
		case 4107:
			errMsg = "ACCOUNT_NULL";
			break;
		case 4108:
			errMsg = "ACCOUNT_EXISTED";
			break;
		case 4109:
			errMsg = "ACCOUNT_BLOCKED";
			break;
		case 4120:
			errMsg = "NO_PERMISSION";
			break;
		default:
			errMsg = "NOK";
			break;
		}
		return errMsg;
	}
}
