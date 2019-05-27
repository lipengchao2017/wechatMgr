package com.wechat.mgr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@PropertySource("classpath:jdbc.properties")
@MapperScan(basePackages = "com.wechat.mgr.*",annotationClass = Repository.class)
public class MgrApplication {

	public static void main(String[] args) {
		SpringApplication.run(MgrApplication.class, args);
	}

}
