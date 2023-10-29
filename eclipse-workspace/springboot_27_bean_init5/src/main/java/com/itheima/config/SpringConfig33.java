package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itheima.bean.Cat;

@Configuration(proxyBeanMethods = false)
public class SpringConfig33 {

	@Bean
	public Cat cat() {
		return new Cat();
	}

}
