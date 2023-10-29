package com.itheima.config;

import org.springframework.context.annotation.Bean;

import com.itheima.bean.Cat;

//@Import({ MyImportSelector.class })
public class SpringConfig {

	// 定义一个bean
	@Bean
//	@ConditionalOnClass(Mouse.class)
//	@ConditionalOnClass(name = "com.itheima.bean.Mouse")
	public Cat tom() {
		return new Cat();
	}

}
