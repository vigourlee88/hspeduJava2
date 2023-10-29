package com.itheima.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.druid.pool.DruidDataSource;

//@Import({ MyImportSelector.class })
//@Import(Mouse.class)
@ComponentScan("com.itheima.bean")
public class SpringConfig {

	/*
	 * @Bean // @ConditionalOnClass(name = "com.itheima.bean.Wolf")
	 * // @ConditionalOnMissingClass("com.itheima.bean.Mouse")
	 * 
	 * @ConditionalOnBean(name="jerry")
	 * // @ConditionalOnMissingClass("com.itheima.bean.Dog")
	 * // @ConditionalOnNotWebApplication
	 * 
	 * @ConditionalOnWebApplication public Cat tom(){ return new Cat(); }
	 */

	@Bean
	@ConditionalOnClass(name = "com.mysql.jdbc.Driver") // pom.xml中加载mysql驱动
	public DruidDataSource dataSource() {
		return new DruidDataSource();
	}

}
