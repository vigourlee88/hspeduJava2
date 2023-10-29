package com.itheima.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.config.SpringConfig8;
import com.itheima.service.BookService;

public class App8 {
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig8.class);
		BookService bookService = ctx.getBean("bookService", BookService.class);// 使用接口拿bean
		bookService.check();

	}
}
