package cn.itcast.mp.simple.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.itcast.mp.simple.pojo.User;

//接口
public interface UserMapper extends BaseMapper<User> {

	User findById(Long id);
}
