package com.itheima;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.config.SpringConfig;
import com.itheima.service.BookService;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		BookService bookService = ctx.getBean(BookService.class);
		bookService.save();
	}

}
