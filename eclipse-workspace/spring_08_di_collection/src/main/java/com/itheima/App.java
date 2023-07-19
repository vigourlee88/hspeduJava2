package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.dao.BookDao;

public class App {
	 public static void main( String[] args ) {
	        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
	        bookDao.save();
	    }

}
