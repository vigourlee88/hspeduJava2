package com.itheima.a15;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.GenericApplicationContext;


// 代理能否重复被代理
public class A15_3 {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("Config", Config.class);
        context.registerBean(ConfigurationClassPostProcessor.class);//解析
        context.registerBean("aspect1", Aspect1.class);
        //自动代理创建器
        context.registerBean(AnnotationAwareAspectJAutoProxyCreator.class);//解析
        //BeanPostProcessor
        //创建 -> (*) 依赖注入 -> 初始化 (*)
        
        context.refresh();

        for (String name : context.getBeanDefinitionNames()) {
        	System.out.println(name);
			
		}
        
       
//        Bean1 bean1 = context.getBean(Bean1.class);
//        bean1.foo();
//        System.out.println(bean1.getClass());
//        // 此代理是为了解决功能增强问题
//        System.out.println(context.getBean("scopedTarget.bean1").getClass());
    }
    static class Target1{
    	public void foo() {
    		System.out.println("target1 foo");
    	}
    }

    static class Target2{
    	public void bar() {
    		System.out.println("target2 bar");
    	}
    }

    static class Config {
       
        @Bean  //低级切面
        public Advisor advisor3(MethodInterceptor advice3) {
        	AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        	pointcut.setExpression("execution(* foo())");
        	return new DefaultPointcutAdvisor(pointcut,advice3);
        }
        @Bean
        public MethodInterceptor advice3() {
//        	return  new MethodInterceptor() {		
//				@Override
//				public Object invoke(MethodInvocation invocation) throws Throwable {
        	
        	return invocation -> {
					//环绕通知，可以有前值增强
					System.out.println("advice3 before...");
					//调用目标方法
					Object result = invocation.proceed();
					System.out.println("advice3 after...");
					return result;//返回目标方法的结果
//				}
			};
        }
    }

    static class Bean1 {
        public void foo() {
            System.out.println("bean1 foo");
        }
    }

    @Aspect   //高级切面
    static class Aspect1 {
        @Before("execution(* foo())")
        public void before()  {
            System.out.println("aspect1 before...");
            
        }
        @After("execution(* foo())")
        public void after()  {
            System.out.println("aspect1 after...");
            
        }
    }
}
