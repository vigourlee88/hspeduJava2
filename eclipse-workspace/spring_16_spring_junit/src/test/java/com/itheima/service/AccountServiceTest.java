package com.itheima.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Account;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//设置类运行器
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring环境对应的配置类
@ContextConfiguration(classes = {SpringConfig.class})//加载配置类
public class AccountServiceTest {
	
	//支持自动装配注入bean
    @Autowired
    private AccountService accountService;

    @Test
    public void test(){
        Account account = accountService.findById(1);
        System.out.println(account);
    }

    @Test
    public void selectAll(){
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }

}
