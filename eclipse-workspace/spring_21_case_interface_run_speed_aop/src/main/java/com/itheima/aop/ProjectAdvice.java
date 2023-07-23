package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect

//测试业务层接口的执行效率
public class ProjectAdvice {
	
	//匹配业务层的所有方法
	@Pointcut("execution(* com.itheima.service.*Service.*(..))")
	private void servicePt() {}
	
	@Around("ProjectAdvice.servicePt()")
	//环绕通知，需要修改返回类型void->Object
	//参数(ProceedingJoinPoint pjp)
	//pjp.proceed();
	public void runSpeed(ProceedingJoinPoint pjp) throws Throwable {
		//代表一次执行的签名信息,封装了执行过程
		Signature signature = pjp.getSignature();
        String className = signature.getDeclaringTypeName();
		String methodName = signature.getName();
		
		//记录时间
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			pjp.proceed();
		}		
		long end = System.currentTimeMillis();
		System.out.println("万次执行时间: "+ className +"."+ methodName + "--->" +(end-start) + "ms");
	}

}
