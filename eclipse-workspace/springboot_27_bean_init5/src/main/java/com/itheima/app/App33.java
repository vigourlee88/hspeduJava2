package com.itheima.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.config.SpringConfig33;

public class App33 {
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig33.class);
		String[] names = ctx.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println("--------------------------");
//		System.out.println(ctx.getBean("springConfig33"));// $EnhancerBySpringCGLIB
		SpringConfig33 springConfig33 = ctx.getBean("springConfig33", SpringConfig33.class);

		// proxyBeanMethods = false 使用当前对象，再执行方法几次，重新得到新的对象
		// proxyBeanMethods = true 在容器里取的创建好的对象
		System.out.println(springConfig33.cat());
		System.out.println(springConfig33.cat());
		System.out.println(springConfig33.cat());
	}
}
