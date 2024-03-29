package com.itheima.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.config.SpringConfig7;

public class App7 {
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig7.class);
		String[] names = ctx.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println("----------------");
	}
}
