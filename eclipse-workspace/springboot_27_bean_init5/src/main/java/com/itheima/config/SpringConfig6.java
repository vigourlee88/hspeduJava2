package com.itheima.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.itheima.bean.MyImportSelector;

@Configuration
//@ComponentScan(basePackages = "com.itheima")
@Import(MyImportSelector.class)
public class SpringConfig6 {

}
