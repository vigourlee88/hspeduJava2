package com.itheima.config;

import org.springframework.context.annotation.Import;

import com.itheima.bean.MyImportSelector;

@Import({ MyImportSelector.class })
public class SpringConfig {

}
