package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

//定义第三方的bean
//@Component 定义成bean
@Configuration // 专门做配置类的声明，做配置的，有文件要加载
public class DbConfig {

	@Bean
	public DruidDataSource dataSource() {
		DruidDataSource ds = new DruidDataSource();
		return ds;
	}

}
