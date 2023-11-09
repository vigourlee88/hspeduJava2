package com.ithiema.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

//@Component // 必须是spring管控的类来能来加载
@ConfigurationProperties(prefix = "cartoon") // 读取配置文件信息，前缀起名"cartoon"
@Data
public class CartoonProperties {// 用来专门封装Cartoon类属性的类
	private Cat cat;
	private Mouse mouse;

}
