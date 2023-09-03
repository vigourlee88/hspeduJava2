package cn.itcast.mp.simple.mapper;

import java.util.List;

import cn.itcast.mp.simple.pojo.User;

//接口
public interface UserMapper extends MyBaseMapper<User> {

	User findById(Long id);
	
//	List<User> findAll();
	
}
