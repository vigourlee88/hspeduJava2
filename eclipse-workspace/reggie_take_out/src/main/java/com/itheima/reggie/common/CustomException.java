package com.itheima.reggie.common;

/**
 * 自定义业务异常类
 */
public class CustomException extends RuntimeException {

	// 提供构造方法，提示异常信息传入
	public CustomException(String message) {
		super(message);
	}
}
