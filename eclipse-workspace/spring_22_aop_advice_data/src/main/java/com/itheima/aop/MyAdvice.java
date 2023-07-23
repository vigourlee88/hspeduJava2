package com.itheima.aop;

import java.util.Arrays;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
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
@Aspect
public class MyAdvice {
	@Pointcut("execution(* com.itheima.dao.BookDao.findName(..))")
    public void pt(){}

//    @Before("pt()")
    public void before(JoinPoint jp){
    	Object[] args = jp.getArgs();
    	System.out.println(Arrays.toString(args));
        System.out.println("before advice ...");
    }

//    @After("pt()")
    public void after(JoinPoint jp){
    	Object[] args = jp.getArgs();
    	System.out.println(Arrays.toString(args));
        System.out.println("after advice ...");
    }

//    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
    	Object[] args = pjp.getArgs();
    	args[0] = 666;//处理参数
    	
        Object res = pjp.proceed(args);
        return res;
    }

//    @AfterReturning("pt()")
    @AfterReturning(value ="pt()",returning ="ret")
    public void afterReturning(JoinPoint jp,String ret){
        System.out.println("afterReturning advice ..." + ret);
    }

//    @AfterThrowing("pt()")
    @AfterThrowing(value = "pt()",throwing = "t")
    public void afterThrowing(Object t){
        System.out.println("afterThrowing advice ..." + t);
    }
	
}
