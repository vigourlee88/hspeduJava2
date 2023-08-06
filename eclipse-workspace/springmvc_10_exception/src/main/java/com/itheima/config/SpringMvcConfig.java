package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
//做一个Spring核心控制类
@ComponentScan("com.itheima.controller")
@EnableWebMvc
public class SpringMvcConfig {

}
