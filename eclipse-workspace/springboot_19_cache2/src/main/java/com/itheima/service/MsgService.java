package com.itheima.service;

public interface MsgService {
	public String get(String tele);// 获取值

	public boolean check(String tele, String code);// 发送手机号，验证过程
}
