package com.itheima.config;

import org.springframework.context.annotation.Import;

import com.itheima.bean.DogFactoryBean;

//@Import({ Dog.class, DbConfig.class })
@Import(DogFactoryBean.class)
public class SpringConfig4 {

}
