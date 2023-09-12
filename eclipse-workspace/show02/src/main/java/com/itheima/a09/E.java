package com.itheima.a09;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class E {
	
	@Lazy
	@Autowired
	private F1 f1;
	
	
	@Autowired
	private F2 f2;

	@Autowired
	private ObjectFactory<F3> f3;//通过工厂识别到f3的多例，每次获取时，创建f3的多例返回
	
	@Autowired
	private ApplicationContext context;
	
	public F1 getF1() {
		return f1;
	}

	public F2 getF2() {
		return f2;
	}

	public F3 getF3() {
		return f3.getObject();
	}
	
	public F4 getF4() {
		return context.getBean(F4.class);//通过容器得到f4额多例
	}

}
