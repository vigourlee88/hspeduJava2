package com.itheima.reggie.common;

/**
 * 基于ThreadLocal封装工具类静态，用来保存和获取当前登录用户id 作用范围是 某个线程之内
 */
public class BaseContext {
	private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

	public static void setCurrentId(Long id) {

		threadLocal.set(id);// 设置线程id

	}

	public static Long getCurrentId() {

		return threadLocal.get();// 取出id

	}
}
