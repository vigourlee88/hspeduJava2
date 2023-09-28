package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SSMPApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");//覆盖当前配置文件中所有配置
		SpringApplication.run(SSMPApplication.class, args);
	}

}
