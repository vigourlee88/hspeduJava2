package com.itheima;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.config.SpringConfig;
import com.itheima.controller.UserController;

public class App {
	public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println(ctx.getBean(UserController.class));
 }

}
