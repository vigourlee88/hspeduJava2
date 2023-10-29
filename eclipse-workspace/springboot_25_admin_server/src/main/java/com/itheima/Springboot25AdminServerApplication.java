package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer // 开启AdminServer
public class Springboot25AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot25AdminServerApplication.class, args);
	}

}
