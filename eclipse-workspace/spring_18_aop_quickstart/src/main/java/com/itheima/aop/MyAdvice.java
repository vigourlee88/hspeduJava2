package com.itheima.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//6.定义通知类受spring容器管理，来加载它
@Aspect
//6.告诉spring，当前类是做aop的切面类

//4.定义通知类，5.绑定切入点与通知的关系，并指定通知添加到原始连接点的具体执行 位置
public class MyAdvice {
	
	//定义切入点
	//切入点定义依托一个不具有实际意义的方法进行，即无参数，无返回值，方法体无实际逻辑
	@Pointcut("execution(void com.itheima.dao.BookDao.update())")
	private void pt() {
		
	}
	
	//定义通知
	//绑定好共性功能和切入点的关系
	@Before("pt()")
	public void method() {
		System.out.println(System.currentTimeMillis());
	}

}
