package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataAdvice {
	@Pointcut("execution(boolean com.itheima.service.*Service.*(*,*))")
	public void servicePt() {
		
	}
	
	@Around("DataAdvice.servicePt()")
	public Object trimStr(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		
		for (int i = 0; i < args.length; i++) {
			//判断参数是不是字符串
			if(args[i].getClass().equals(String.class)) {
				args[i] = args[i].toString().trim();//trim()前后空格去掉返回
			}
		}
		
		Object ret = pjp.proceed(args);//调用原始操作，修改完后，加入到原来的参数
		return ret;
		
	}

}
