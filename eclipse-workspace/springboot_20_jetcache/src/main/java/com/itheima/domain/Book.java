package com.itheima.domain;
//lombok

import java.io.Serializable;

import lombok.Data;

@Data
public class Book implements Serializable {// 要实现序列化存储到redis中
	private Integer id;
	private String type;
	private String name;
	private String description;
}
