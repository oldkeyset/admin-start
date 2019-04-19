# admin-start

#system_config 系统配置项
#peerid	
*检测用户登录态	后台管理系统,
*(除common下的接口)其它所有接口必须有,在intercepter中拦截
#session_id	权限拦截


# spring-boot2.0
# 项目结构	
#org.admin	
* ApplicationStart.java SpringBootApplication启动类
* 
#org.admin.common
*Common.java
*checkPeerid  _peerid的校验规则

#org.admin.config
* 项目配置项
*ErrorCode.java	异常规则,统一异常消息管理
*RedisConfig.java 管理redis_key
*WebMvcConfig.java	继承WebMvcConfigurer 处理跨域	匹配_Interceptors拦截controller的方法

#org.admin.controller.common
*CommonController.java	
*login	系统登录接口	post_param_User
*_regist 注册接口	post_param_username_password
*_captcha 生成验证码	get_param_peerid
*_peerid 生成_peerid	
#org.admin.controller.config
*menuList 返回系统功能菜单

#org.admin.controller.interceptor
*继承HandlerInterceptor
*preHandle 校验用户登录态
*returnErrorResponse 将preHandle要反馈给前端的消息写入Response

#org.admin.mapper
*数据层_mapper

#org.admin.pojo
*实体类

#org.admin.service
*业务层

#org.admin.utils
*工具类
*GeneratorDisplay.java 生成_mapper _pojo 
*JSONResult.java 生成返回给前端的消息	_status状态码 _msg 消息 data数据	_ok
*jsonUtils.java 数据转换类
*MyMapper.java	 由_mybatis逆向生成的 需要配置到 application.properties中
*RedisOperator.java _redis缓存规则
*Result.java 将所有返回的数据可以转换为String 类型
*UUIDUtils.java 工具类
*XCaptcha.java 生成base64验证码图片
