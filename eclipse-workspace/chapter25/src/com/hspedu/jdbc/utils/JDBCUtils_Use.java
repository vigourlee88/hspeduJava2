package com.hspedu.jdbc.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;



//该类演示如何使用JDBCUtils工具类，完成dml和select语句
public class JDBCUtils_Use {
	
	public static void main(String[] args) {
		
		//测试
		
	}
	
	@Test
	public void testSelect() {
		//1.得到连接
		Connection connection = null;
		//2.组织sql语句
		String sql = "select * from actor where id = ?";
		//测试select 语句 应该定义一个ResultSet对象
		ResultSet set = null;
		
		//3.创建PreparedStatement对象
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBCUtils.getConnection();
			//运行类型是com.mysql.jdbc.ConnectionImpl
			System.out.println(connection.getClass());
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 11);//给?赋值
			//有 占位符? 的话，需要赋值
			
			//执行,得到结果集
			set = preparedStatement.executeQuery();
			//遍历该结果集
			while(set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				String sex = set.getString("sex");
				Date borndate = set.getDate("borndate");
				String phone = set.getString("phone");
				System.out.println(id + "\t" + name + "\t" +
						           sex + "\t" + borndate + "\t" +
						           phone + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//3.关闭资源
			JDBCUtils.close(set, preparedStatement, connection);
		}
		
	}
	
	@Test
	public void testDML() {//insert ,delete,update
		
		//1.得到连接
		Connection connection = null;
		
		//2.组织sql语句
		String sql = "update actor set name = ? where id = ?";
		//3.创建PreparedStatement对象
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBCUtils.getConnection();
			
			preparedStatement = connection.prepareStatement(sql);
			//给?占位符 赋值
			preparedStatement.setString(1, "周星驰");
			preparedStatement.setInt(2, 11);
			//执行
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭资源  这里没有结果集 为null
			JDBCUtils.close(null, preparedStatement, connection);
		}
	}

}
