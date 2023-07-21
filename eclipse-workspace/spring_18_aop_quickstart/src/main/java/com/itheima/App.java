package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		BookDao bookDao = ctx.getBean(BookDao.class);
//		bookDao.save();
//		bookDao.update();
		System.out.println(bookDao);
		System.out.println(bookDao.getClass());
	}

}
