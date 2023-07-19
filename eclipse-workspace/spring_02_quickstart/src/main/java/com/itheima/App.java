package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.service.BookService;

/*
 * bean依赖注入的ref属性指定bean，必须在容器中存在，
 * 而ref的值也可以是name里的别名，
 * 不过还是建议用id值来注入
 * 如果我们在调用getBean(String name)方法时，
 * 传入了一个不存在该名称的bean对象，
 * 则会报错NoSuchBeanDefinitionException，
 * 此时我们要检查一下是哪边写错了（例如bean的id和name都没有service100，
 * 而getBean的参数却写了service100）
 */
public class App {
	 public static void main(String[] args) {
	        //BookService bookService = new BookServiceImpl();
		    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	        //此处根据bean标签的id属性和name属性的任意一个值来获取bean对象
	        BookService bookService = (BookService) context.getBean("service2");
	        bookService.save();
	    }

}
