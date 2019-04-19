package org.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "org.admin.mapper")
@ComponentScan(basePackages = { "org.admin" })
public class ApplicationStart {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationStart.class, args);
	}
}
