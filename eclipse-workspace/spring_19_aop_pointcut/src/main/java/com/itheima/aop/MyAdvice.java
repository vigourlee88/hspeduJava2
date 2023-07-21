package com.itheima.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//定义通知类受spring容器管理，来加载它
@Aspect
//当前类是做aop的切面类

//定义通知类
public class MyAdvice {
	
	//定义切入点
//	@Pointcut("execution(void com.itheima.dao.BookDao.update())")
//	@Pointcut("execution(void com.itheima.dao.impl.BookDaoImpl.update())")
//	@Pointcut("execution(* com.itheima.dao.impl.BookDaoImpl.update(*))")  No
//	@Pointcut("execution(void com.*.*.*.*.update())")
//	@Pointcut("execution(void com.*.*.*.update())")
//	@Pointcut("execution(void com.*..*.update())")
//	@Pointcut("execution(* *..*e(..))")
//	@Pointcut("execution(void com..*())")
	@Pointcut("execution(* com.itheima.*.*Service.find*(..))")
//  @Pointcut("execution(* com.itheima.*.*Service.save(..))")
	private void pt() {
		
	}
	
	//绑定好共性功能和切入点的关系
	@Before("pt()")
	public void method() {
		System.out.println(System.currentTimeMillis());
	}

}
