package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;


@Data
//@TableName("tbl_user")
public class User {
    
//	@TableId(type = IdType.AUTO)
//	@TableId(type = IdType.INPUT)
//	@TableId(type = IdType.ASSIGN_ID)
	private Long id;
	private String name;
	@TableField(value = "pwd",select = false)//不查询pwd
	private String password;
	private Integer age;
	private String tel;
	
	@TableField(exist = false)//字段不存在
	private Integer online;
		

}
