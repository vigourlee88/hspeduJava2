package com.itheima.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.config.SpringConfig3;

public class App3 {
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig3.class);
		String[] names = ctx.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println(ctx.getBean("dog"));// com.itheima.bean.Dog@1d082e88
		System.out.println(ctx.getBean("dog"));// com.itheima.bean.Dog@60704c
		System.out.println(ctx.getBean("dog"));// com.itheima.bean.Dog@6b19b79
	}
}
