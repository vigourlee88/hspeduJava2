package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.config.SpringConfig;
import com.itheima.service.ResourcesService;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        ResourcesService resourcesService = ctx.getBean(ResourcesService.class);
		Boolean flag = resourcesService.openURL("http://pan.baidu.com/haha","root ");//密码加空格
		System.out.println(flag);
		
	}

}
