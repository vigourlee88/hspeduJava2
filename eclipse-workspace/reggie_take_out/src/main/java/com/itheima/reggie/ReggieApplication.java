package com.itheima.reggie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement // 开启事务注解支持

public class ReggieApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReggieApplication.class, args);
		log.info("项目启动成功...");
	}

}
