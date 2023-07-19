package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.service.BookService;

/*
 * 需要注入属性的类中对应属性的setter方法不能省略
 *被注入的对象必须要被Spring的IOC容器管理
 *按照类型在Spring的IOC容器中如果找到多个对象，会报NoUniqueBeanDefinitionException
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BookService bookService = (BookService) ctx.getBean("bookService");
		bookService.save();
	}

}
