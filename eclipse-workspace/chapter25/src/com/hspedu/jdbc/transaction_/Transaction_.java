package com.hspedu.jdbc.transaction_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.hspedu.jdbc.utils.JDBCUtils;

//不使用事务可能出现的问题 模拟经典的转账业务
//演示jdbc 中如何使用事务

@SuppressWarnings({"all"})
public class Transaction_ {
	
	@Test
	public void noTransaction() {
		
		//操作转账的业务
		//1.得到连接
		Connection connection = null;
		
		//2.组织sql语句，需要确认连的表 和 url的库 是否一致
		String sql1 = "update account01 set balance = balance - 100 where id = 1";
		String sql2 = "update account01 set balance = balance + 100 where id = 2";
		//3.创建PreparedStatement对象
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBCUtils.getConnection();//在默认情况下，执行这个语句后，connection是默认自动提交
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.executeUpdate();//执行第一条sql
			
			int i = 1 / 0;//抛出异常，try中出现异常的话，下面的代码就不会执行
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.executeUpdate();//执行第二条sql
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭资源  这里没有结果集 为null
			JDBCUtils.close(null, preparedStatement, connection);
		}
	}

	//事务来解决
	@Test
    public void useTransaction() {
		
		//操作转账的业务
		//1.得到连接
		Connection connection = null;
		
		//2.组织sql语句，需要确认连的表 和 url的库 是否一致
		String sql1 = "update account01 set balance = balance - 100 where id = 1";
		String sql2 = "update account01 set balance = balance + 100 where id = 2";
		//3.创建PreparedStatement对象
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBCUtils.getConnection();//在默认情况下，执行这个语句后，connection是默认自动提交
			//将connection设置为 不自动提交
			connection.setAutoCommit(false);//相当于 开启了事务
			
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.executeUpdate();//执行第一条sql
			
			int i = 1 / 0;//抛出异常，try中出现异常的话，下面的代码就不会执行，而进入catch语句
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.executeUpdate();//执行第二条sql
			
			//这里提交事务
			connection.commit();
			
		} catch (SQLException e) {
			//这里可以进行 回滚，即撤销执行的sql
			//默认回滚到 事务开始的地方
			System.out.println("执行发生了异常，撤销执行的sql");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			//关闭资源  这里没有结果集 为null
			JDBCUtils.close(null, preparedStatement, connection);
		}
	}

}


