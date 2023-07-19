package com.itheima;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.config.SpringConfig;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource);
	}

}
