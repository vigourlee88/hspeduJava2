package com.hspedu.jdbc.datasource;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.hspedu.jdbc.utils.JDBCUtils;

public class ConQuestion {

	//代码 连接mysql 5000次  会报异常 too many connections
	@Test
	public void testCon() {
		//看看连接-关闭connection 会耗用多久
		long start = System.currentTimeMillis();
		System.out.println("开始连接....");
		for (int i = 0; i < 5000; i++) {
		   //使用传统的JDBC方式，得到连接
			Connection connection = JDBCUtils.getConnection();
			//做一些工作，比如得到PreparedStatement,发送sql
			//......
			//关闭资源
			JDBCUtils.close( null, null,connection);
		}
		
		long end = System.currentTimeMillis();
		System.out.println("传统方式5000次 耗时="+ (end - start));
	}
}
