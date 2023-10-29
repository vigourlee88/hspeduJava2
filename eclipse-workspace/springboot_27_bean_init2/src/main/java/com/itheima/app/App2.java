package com.itheima.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
	public static void main(String[] args) {
		// 定义一个上下文对象
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");

		String[] names = ctx.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);

		}
	}
}
