package com.fdbill.manage.app;

import com.fdbill.manage.utils.util.SpringBeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class
})
@ComponentScan(value={"com.fdbill.manage.controller",
		"com.fdbill.manage.service",
		"com.fdbill.manage.config"})
public class Application {
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Application.class, args);
		SpringBeanUtil.initContext(context);
		log.info("==============================================RUN SUCCESS===========================================");
	}

}