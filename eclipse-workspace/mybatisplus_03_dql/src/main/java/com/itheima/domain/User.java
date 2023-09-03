package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok 一个Java类库，提供了一组注解，简化POPJ实体类开发
//@Setter
//@Getter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
@Data
@TableName("tbl_user")
public class User {
    
	private Long id;
	private String name;
	@TableField(value = "pwd",select = false)//不查询pwd
	private String password;
	private Integer age;
	private String tel;
	
	@TableField(exist = false)//字段不存在
	private Integer online;
		

}
