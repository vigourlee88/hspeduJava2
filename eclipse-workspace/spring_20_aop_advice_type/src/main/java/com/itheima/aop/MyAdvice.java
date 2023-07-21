package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//定义通知类受spring容器管理，来加载它
@Aspect
//当前类是做aop的切面类

//AOP通知描述了抽取的共性功能，根据共性功能抽取的位置不同，最终运行代码时要将其加入到合理的位置
public class MyAdvice {
	
	//定义切入点
//	@Pointcut("execution(void com.itheima.dao.BookDao.update())")
//	private void pt() {}
	@Pointcut("execution(int com.itheima.dao.BookDao.select())")
	private void pt2() {}
		
	
//	@Before("pt()")
	//前置通知
	public void before() {
		System.out.println("before advice...");
	}
	
//	@After("pt2()")
	//后置通知
	public void after() {
		System.out.println("after advice...");
	}
	
//	@Around("pt()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around before advice...");
		//表示对原始操作的调用
		pjp.proceed();
		System.out.println("around after advice...");
	}
	
//	@Around("pt2()")
	//环绕通知
	public Object aroundSelect(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around before advice...");
		//表示对原始操作的调用
		Object ret = pjp.proceed();
		System.out.println("around after advice...");
		return ret;
	}
	
//	@AfterReturning("pt2()")
	//返回后通知
	public void afterReturning() {
		System.out.println("afterReturning advice...");
	}
	
	@AfterThrowing("pt2()")
	//抛出异常后通知
	public void afterThrowing() {
		System.out.println("afterThrowing advice...");
	}
	

}
