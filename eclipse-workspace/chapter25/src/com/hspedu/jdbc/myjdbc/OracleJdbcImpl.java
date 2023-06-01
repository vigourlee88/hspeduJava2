package com.hspedu.jdbc.myjdbc;

//模拟jdbc数据库实现 jdbc接口
public class OracleJdbcImpl implements JdbcInterface{

	@Override
	public Object getConnection() {
		System.out.println("得到 oracle 的连接");
		return null;
	}

	@Override
	public void crud() {
		System.out.println("完成 对oracle的增删改查");
	}

	@Override
	public void close() {
		System.out.println("关闭 oracle的连接");
	}

}
