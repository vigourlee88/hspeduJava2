package com.itheima.dao;

import org.apache.ibatis.annotations.Insert;

import com.itheima.domain.User;

public interface UserDao {
	@Insert("insert into tb1_user(name,age)values(#{name},#{age})")
	public void save(User user);
	

}
