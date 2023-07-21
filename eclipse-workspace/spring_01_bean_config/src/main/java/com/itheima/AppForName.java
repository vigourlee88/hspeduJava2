package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.service.BookService;

public class AppForName {
	  public static void main(String[] args) {

	        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

	        BookService bookService = (BookService) ctx.getBean("service4");

	        bookService.save();
	    }

}
