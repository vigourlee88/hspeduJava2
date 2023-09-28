package com.itheima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j  //添加日志功能注解，pom.xml添加lombok依赖

//Rest模式
@RestController
@RequestMapping("/books") // 发什么形式的请求路径
public class BookController {

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
