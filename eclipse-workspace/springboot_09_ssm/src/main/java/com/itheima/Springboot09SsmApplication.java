package com.itheima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@SpringBootApplication
//@MapperScan("com.itheima.dao")
public class Springboot09SsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot09SsmApplication.class, args);
	}

}
