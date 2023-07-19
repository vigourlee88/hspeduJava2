package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.service.BookService;

public class App2 {
	public static void main(String[] args) {
		
	//3.获取IoC容器
	//使用Spring提供的接口完成IOC容器的创建
	ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
	
	//4.获取bean
	//从IOC容器中获取对象进行方法调用
	//使用getBean(String name)方法，其name参数就是我们在bean配置的id，通过这个id来造对象
//	BookDao bookDao = (BookDao) ctx.getBean("bookDao");
//	bookDao.save();
	
	
	BookService bookService = (BookService) ctx.getBean("bookService");
	bookService.save();
	
	}
}
