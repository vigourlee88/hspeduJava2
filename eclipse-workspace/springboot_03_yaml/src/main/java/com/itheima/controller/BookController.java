package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itheima.MyDataSource;

//Rest模式
@RestController
@RequestMapping("/books") // 发什么形式的请求路径
public class BookController {

	//读取yaml数据中的单一数据
	@Value("${country}")
	private String country1;
    
	@Value("${user1.name}")
	private String name1;
	
	@Value("${likes[1]}")
	private String likes1;
	
	@Value("${users[1].age}")
	private String age1;
	
	@Value("${server.port}")
	private String port1;
	
	@Value("${tempDir}")
	private String tempDir1;
	
	//使用自动装配将所有数据封装到一个对象Environment中
	@Autowired
	private Environment env;
	
	@Autowired
	private MyDataSource myDataSource;
	
	@GetMapping  //设置当前操作的请求模式
    public String getById(){
        System.out.println("springboot is running...");
        System.out.println("country1==="+country1);
        System.out.println("name1==="+name1);
        System.out.println("likes1==="+likes1);
        System.out.println("age1==="+age1);
        System.out.println("port1==="+port1);
        System.out.println("tempDir1==="+tempDir1);
        System.out.println("=========================");
        System.out.println(env.getProperty("server.port"));
        System.out.println(env.getProperty("user1.name"));
        System.out.println("=========================");
        System.out.println(myDataSource);
        return "springboot is running...";
    }

}
