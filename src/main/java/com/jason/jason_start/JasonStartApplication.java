package com.jason.jason_start;

import com.jason.jason_start.common.MyAspect;
import com.jason.jason_start.config.AppConfig;
import com.jason.jason_start.domain.User;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@SpringBootApplication
@EnableCaching // 启动缓存
public class JasonStartApplication {

	@Bean(name = "myAspect")
	public MyAspect initMyAspect() {
		return new MyAspect();
	}

	public static void main(String[] args) {
		SpringApplication.run(JasonStartApplication.class, args);

	}

}
