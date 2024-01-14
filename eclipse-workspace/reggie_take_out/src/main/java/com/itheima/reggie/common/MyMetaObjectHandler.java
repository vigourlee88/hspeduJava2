package com.itheima.reggie.common;

import java.time.LocalDateTime;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义的元数据对象处理器
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

	/**
	 * 插入操作，自动填充
	 * 
	 * @param metaObject
	 */
	@Override
	public void insertFill(MetaObject metaObject) {
		log.info("公共字段自动填充[insert]...");
		log.info(metaObject.toString());
		metaObject.setValue("createTime", LocalDateTime.now());
		metaObject.setValue("updateTime", LocalDateTime.now());
		metaObject.setValue("createUser", BaseContext.getCurrentId());// 替换new Long(1)
		metaObject.setValue("updateUser", BaseContext.getCurrentId());

	}

	/**
	 * 修改操作，自动填充
	 * 
	 * @param metaObject
	 */
	@Override
	public void updateFill(MetaObject metaObject) {
		log.info("公共字段自动填充[update]...");
		log.info(metaObject.toString());

		Long id = Thread.currentThread().getId();
		log.info("线程id为: {}", id);

		metaObject.setValue("updateTime", LocalDateTime.now());
		// metaObject.setValue("updateUser", new Long(1));
		metaObject.setValue("updateUser", BaseContext.getCurrentId());

	}

}