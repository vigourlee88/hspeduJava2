package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.itheima")
@EnableAspectJAutoProxy
//告诉spring 这里有注解开发的aop
//启动 MyAdvice中的@Aspect,识别下面方法
//7.开启spring对AOP注解驱动支持
public class SpringConfig {

}
