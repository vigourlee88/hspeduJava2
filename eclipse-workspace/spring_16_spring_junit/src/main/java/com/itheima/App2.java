package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;

public class App2 {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		AccountService accountService = ctx.getBean(AccountService.class);
		Account ac = accountService.findById(2);
		System.out.println(ac);
	}

}
