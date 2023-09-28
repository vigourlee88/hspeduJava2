package com.itheima.controller.bak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

//Rest模式
@RestController
@RequestMapping("/books") // 发什么形式的请求路径
public class BookController extends BaseClass{

	//创建记录日志的对象
//	private static final Logger log = LoggerFactory.getLogger(BookController.class);
   
	@GetMapping  //设置当前操作的请求模式
    public String getById(){
        System.out.println("springboot is running...");
        
        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");
        
        
        
        return "springboot is running...";
    }

}
