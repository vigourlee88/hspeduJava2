package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		BookDao bookDao = ctx.getBean(BookDao.class);
		String name = bookDao.findName(100);
		System.out.println(name);
		
	}

}
