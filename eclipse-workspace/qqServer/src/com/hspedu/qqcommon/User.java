package com.hspedu.qqcommon;

import java.io.Serializable;

//表示一个用户/客户信息
//如果一个对象 希望通过Object对象流的方式来读写的话，这个对象对应的类必须实现序列化
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String userId;//用户Id用户名
	private String passwd;//用户密码
	public User(String userId, String passwd) {
		super();
		this.userId = userId;
		this.passwd = passwd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	

}
