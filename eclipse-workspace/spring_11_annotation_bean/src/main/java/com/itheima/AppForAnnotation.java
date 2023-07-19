package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;
import com.itheima.service.BookService;

public class AppForAnnotation {
	public static void main(String[] args) {
		
		//加载配置类的初始化容器SpringConfig.class
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		BookDao bookDao = (BookDao) ctx.getBean("bookDao");
	    System.out.println(bookDao);
	    
	    //按照类型获取bean
	    BookService bookService = ctx.getBean(BookService.class);
	    System.out.println(bookService);
    }
}
