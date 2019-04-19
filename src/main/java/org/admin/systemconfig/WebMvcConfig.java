package org.admin.systemconfig;

import org.admin.controller.Interceptor.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	
	/**
	 * NO Access-Control-Allow-Origin跨域异常
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowCredentials(true)
				.allowedMethods("GET", "POST", "DELETE", "PUT").maxAge(3600);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor()).addPathPatterns("/config/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	@Bean
	public Interceptor interceptor() {
		return new Interceptor();
	}
}


