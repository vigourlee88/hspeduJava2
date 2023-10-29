package com.itheima.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.stereotype.Component;

@Component("tom")
@ConditionalOnBean(name = "jerry") // 有jerry这个bean
//@ConditionalOnWebApplication
@ConditionalOnNotWebApplication
public class Cat {

}
