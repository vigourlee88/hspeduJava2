package com.itheima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("/books") // 发什么形式的请求路径
public class BookController {

    @GetMapping  //设置当前操作的请求模式
    public String getById(){
        System.out.println("springboot is running...3");
        return "springboot is running...3";
    }

}
