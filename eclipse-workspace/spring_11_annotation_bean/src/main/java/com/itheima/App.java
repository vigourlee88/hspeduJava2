package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;


public class App {
	 public static void main(String[] args) {
	        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
	        System.out.println(bookDao);
	        
	        //按照类型获取bean
	        BookService bookService = ctx.getBean(BookService.class);
	        System.out.println(bookService);
	}

}
