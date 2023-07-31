package com.itheima.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
//配置类
public class SpringMvcSupport extends WebMvcConfigurationSupport {

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		//设置静态资源访问过滤，当前类需要设置为配置类，并被扫描加载
		//当访问/pages/???时候不要走mvc,走/pages目录下的内容
		//如果发送这个请求/pages/**，就访问这个/pages/下的东西
		registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
	
	}
	
}
