package com.itheima;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		BookDao bookDao1 = ctx.getBean(BookDao.class);
		BookDao bookDao2 = ctx.getBean(BookDao.class);
		System.out.println(bookDao1);
		System.out.println(bookDao2);
		
		ctx.close();//关闭容器
	}

}
