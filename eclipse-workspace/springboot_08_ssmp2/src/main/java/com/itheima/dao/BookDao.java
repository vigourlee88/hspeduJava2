package com.itheima.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Book;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
