package com.fdbill.manage.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class
})
@ComponentScan(value={"com.fdbill.manage.controller",
		"com.fdbill.manage.service",
		"com.fdbill.manage.config"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}