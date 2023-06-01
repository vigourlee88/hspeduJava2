package com.hspedu.jdbc.myjdbc;

public class TestJDBC {
	public static void main(String[] args) {
		//完成对mysql的操作
		JdbcInterface jdbcInterface = new MysqlJdbcImpl();
		jdbcInterface.getConnection();//通过接口来调用实现类[多态的动态绑定机制]
		jdbcInterface.crud();
		jdbcInterface.close();
		
		//完成对mysql的操作
		System.out.println("==============");
		JdbcInterface jdbcInterface2 = new OracleJdbcImpl();
		jdbcInterface2.getConnection();//通过接口来调用实现类[多态的动态绑定机制]
		jdbcInterface2.crud();
		jdbcInterface2.close();
	}

}
