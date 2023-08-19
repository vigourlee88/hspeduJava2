package com.itheima.controller;

public class Result {
	private Object data;
	private Integer code;
	private String msg;
	
	//提供构造方法
	public Result(Integer code,Object data) {
		super();
		this.code = code;
		this.data = data;
	}
	public Result() {
		super();
	}
	public Result(Integer code,Object data,String msg) {
		super();
		this.code = code;
		this.data = data;		
		this.msg = msg;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
