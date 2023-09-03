package com.itheima.query;

import com.itheima.domain.User;

import lombok.Data;

//专门用来封装User模型的查询条件的
@Data
public class UserQuery extends User{	
	private Integer age2;//描述age的上限

}
