package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.itheima.dao")
@Import({JdbcConfig.class})
//在SpringConfig中扫描BookDao
//扫描的目的是让Spring能管理到BookDao，
//也就是要让IOC容器中有一个BookDao对象
public class SpringConfig {
	
}
