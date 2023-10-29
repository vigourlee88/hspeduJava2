package com.itheima.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.config.SpringConfig3;

public class App3 {
	public static void main(String[] args) {
		// 定义一个上下文对象
		// ClassPathXmlApplicationContext 加载配置文件.xml
		// AnnotationConfigApplicationContext 加载配置类 .class

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig3.class);

		String[] names = ctx.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);

		}
	}
}
