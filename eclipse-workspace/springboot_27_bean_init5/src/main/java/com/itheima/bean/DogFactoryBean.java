package com.itheima.bean;

import org.springframework.beans.factory.FactoryBean;

//implements FactoryBean，当前类被spring加载后，创建出来的对象 是泛型类型<Dog>
public class DogFactoryBean implements FactoryBean<Dog> {

	@Override
	public Dog getObject() throws Exception {

		return new Dog();
	}

	@Override
	public Class<?> getObjectType() {

		return Dog.class;
	}

	@Override
	public boolean isSingleton() {

		return false;// 设置是否是单例对象，true是同一个对象
	}

}
