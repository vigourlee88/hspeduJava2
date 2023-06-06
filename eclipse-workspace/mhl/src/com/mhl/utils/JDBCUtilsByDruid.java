package com.mhl.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

//基于druid数据库连接池的工具类
public class JDBCUtilsByDruid {
	
	private static DataSource ds;
	
	//在静态代码块完成 ds初始化
	static {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src//druid.properties"));
			ds = DruidDataSourceFactory.createDataSource(properties);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//编写getConnection方法,得到连接方法
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();//数据库连接池的方式 获取连接	
	}
	
	//关闭连接，老师再次强调，在数据库连接池技术中，close不是真的断掉连接
	//而是把使用的Connection对象放回连接池
	public static void close(ResultSet resultSet,Statement statement,Connection connection) {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
		}
	}
}
