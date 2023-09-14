package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.itheima.controller.BookController;

@SpringBootApplication   //引导类 就是配置类，程序入口，加载bean
public class Springboot0101QuickstartApplication {

	public static void main(String[] args) {
		//main()方法下SpringApplication.run启动了一个spring容器，定义的bean就可以加载到这里
//		SpringApplication.run(Springboot0101QuickstartApplication.class, args);
		ConfigurableApplicationContext ctx = 
				     SpringApplication.run(Springboot0101QuickstartApplication.class, args);
		
		BookController bean = ctx.getBean(BookController.class);
		System.out.println("bean====>" + bean);
		User bean2 = ctx.getBean(User.class);
		System.out.println("bean====>" + bean2);
	}

}
