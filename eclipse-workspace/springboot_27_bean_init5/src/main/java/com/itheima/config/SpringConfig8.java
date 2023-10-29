package com.itheima.config;

import org.springframework.context.annotation.Import;

import com.itheima.bean.MyPostProcessor;
import com.itheima.bean.MyRegistrar2;
import com.itheima.service.impl.BookServiceImpl1;

@Import({ BookServiceImpl1.class, MyPostProcessor.class, MyRegistrar2.class })
public class SpringConfig8 {

}
