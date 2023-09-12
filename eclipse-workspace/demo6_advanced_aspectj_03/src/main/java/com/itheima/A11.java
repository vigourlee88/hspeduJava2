package com.itheima;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.itheima.service.MyService;

/*
注意几点
1. 版本选择了 java 8, 因为目前的 aspectj-maven-plugin 1.14.0 最高只支持到 java 16
2. 一定要用 maven 的 compile 来编译, idea 不会调用 ajc 编译器
*/
@SpringBootApplication
public class A11 {

private static final Logger log = LoggerFactory.getLogger(A11.class);

public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(A11.class, args);
    MyService service = context.getBean(MyService.class);

    log.debug("service class: {}", service.getClass());
    service.foo();

    context.close();

//   new MyService().foo();

    /*
        学到了什么
        1. aop 的原理并非代理一种, 编译器也能玩出花样
     */
}
}
