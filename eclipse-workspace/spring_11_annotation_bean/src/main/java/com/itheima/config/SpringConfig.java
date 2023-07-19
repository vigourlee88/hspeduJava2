package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//在配置文件中对包进行了扫描，Spring在3.0版已经支持纯注解开发，使用Java类替代配置文件，开启了Spring快速开发赛道
//@Configuration将其标识为一个配置类，用于替换掉applicationContext.XML
//添加包扫描注解@ComponentScan替换<context:component-scan base-package=""/>
@Configuration
@ComponentScan({"com.itheima.service","com.itheima.dao"})
public class SpringConfig {
	

}
