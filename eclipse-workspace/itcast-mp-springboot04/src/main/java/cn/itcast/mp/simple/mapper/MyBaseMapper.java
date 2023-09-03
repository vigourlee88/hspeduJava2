package cn.itcast.mp.simple.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface MyBaseMapper<T> extends BaseMapper<T>{

	List<T> findAll();
	
	//扩展其他方法
}
