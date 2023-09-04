package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

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
	
//	逻辑删除字段，标记当前记录是否被删除
//	@TableLogic(value="0",delval="1")//配置文件中已配置
	private Integer deleted;
		
	//实现乐观锁
	@Version
	private Integer version;

}
