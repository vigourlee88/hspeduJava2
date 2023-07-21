package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.dao.BookDao;

//bean的作用范围，创建的bean是一个对象，还是多个对象，造的对象是单例还是非多例
public class AppForScope {
	  public static void main(String[] args) {

	        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

	        BookDao bookDao1 = (BookDao) ctx.getBean("bookDao");
	        BookDao bookDao2 = (BookDao) ctx.getBean("bookDao");
	        System.out.println(bookDao1);
	        System.out.println(bookDao2);


	    }

}
