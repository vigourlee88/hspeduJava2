package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.service.BookService;

//修改运行类，加载Spring的IOC容器，并从中获取对应的bean对象
public class AppForDiConstructor {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BookService bookService = (BookService) ctx.getBean("bookService");
		bookService.save();
	}

}
