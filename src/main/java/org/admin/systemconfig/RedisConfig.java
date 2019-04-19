package org.admin.systemconfig;

public class RedisConfig {
	/**
	 * @Description key的过期时间
	 */
	public interface redisSeconds {
		public static final int EXPIRE_DAY_30 = 2592000;
		public static final int EXPIRE_DAY_7 = 604800;
		public static final int EXPIRE_DAY_1 = 86400;
		public static final int EXPIRE_MIN_1 = 60;
		public static final int EXPIRE_MIN_2 = 120;
		public static final int EXPIRE_MIN_5 = 300;
		public static final int EXPIRE_MIN_30 = 1800;
		public static final int EXPIRE_HOUR_1 = 3600;
	}
	public interface menu{
		public static final String MENU_LIST = "menu_list";
	}
	
	public static String SESSION_ID = "session_id:";
	
	public static String LOGIN_CODE = "login_code";
}
