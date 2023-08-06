package com.itheima.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;

@RestControllerAdvice
//用于标识当前类为REST风格对应的异常处理器
public class ProjectExceptionAdvice {

	@ExceptionHandler(SystemException.class)
	//拦截异常 用于设置当前处理器类对应的异常类型
	public Result doSystemException(SystemException ex) {
		//记录日志
		//发送消息给运维
		//发送消息给开发人员 ex对象发送给开发人员
		return new Result(ex.getCode(),null,ex.getMessage()); 
	}
	
	@ExceptionHandler(BusinessException.class)
	//拦截异常
	public Result doBusinessException(BusinessException ex) {
		return new Result(ex.getCode(),null,ex.getMessage()); 
	}
	
	
	@ExceptionHandler(Exception.class)
	////除了自定义的异常处理器，保留对Exception类型的异常处理，用于处理非预期的异常
	public Result doException(Exception ex) {
		//记录日志
		//发送消息给运维
		//发送消息给开发人员 ex对象发送给开发人员
		return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙，请稍后再试!"); 
	
	}
}
