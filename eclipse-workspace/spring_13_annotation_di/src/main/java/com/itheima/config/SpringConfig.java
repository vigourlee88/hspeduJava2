package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.itheima")
@PropertySource("jdbc.properties")
//注意:路径仅支持单一文件配置，多文件请使用数组格式配置，不允许使用通配符*
//@PropertySource("classpath:jdbc.properties")
//@PropertySource({"jdbc.properties","jdbc.properties","jdbc.properties"})
public class SpringConfig {

}
