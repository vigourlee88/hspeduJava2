package com.itheima.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.itheima.bean.Cat;
import com.itheima.bean.Mouse;

//@Import({ MyImportSelector.class })
@Import(Mouse.class)
public class SpringConfig {

	// 定义一个bean
	@Bean
//	@ConditionalOnClass(Mouse.class)
//	@ConditionalOnClass(name = "com.itheima.bean.Mouse")
//	@ConditionalOnBean(name = "com.itheima.bean.Mouse")
	@ConditionalOnBean(name = "jerry")
//	@ConditionalOnMissingClass("com.itheima.bean.Dog") // 容器里有Dog,就不运行tom();
	@ConditionalOnNotWebApplication
	public Cat tom() {
		return new Cat();
	}

}
