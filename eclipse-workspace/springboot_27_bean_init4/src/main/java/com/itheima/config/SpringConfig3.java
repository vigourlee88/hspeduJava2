package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.itheima.bean.DogFactoryBean;

@ComponentScan({ "com.itheima.bean", "com.itheima.config" })
public class SpringConfig3 {

	@Bean
	public DogFactoryBean dog() {// 方法名就是Bean的名字
		return new DogFactoryBean();
	}

}
