package com.hspedu.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//这是一个工具类，完成Mysql 的连接和关闭资源
public class JDBCUtils {
	//定义相关的属性(4个),因为只需要一份，因此做成static 
	private static String user;//用户名
	private static String password;//密码
	private static String url;//url
	private static String driver;//驱动名
	
	//在static代码块初始化
	static {
		
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src//mysql.properties"));
			//读取相关的属性值
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			url = properties.getProperty("url");
			driver = properties.getProperty("driver");
		} catch (IOException e) {
			//在实际开发中,我们可以这样处理
			//1.将编译异常 转成 运行异常 
			//2.这时调用者可以 捕获该异常，也可以选择默认处理异常，比较方便
			throw new RuntimeException(e);
		}
		
	}
	
	//编写方法，连接数据库，返回Connection
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//关闭相关资源
	/*
	 * 1.关闭ResultSet
	 * 2.Statement或PreparedStatement
	 * 3.Connection
	 * 4.如果需要关闭资源，就传入对象，否则传入null
	 */
	public static void close(ResultSet set,Statement statement,Connection connection) {
		//判断是否为null
		try {
			
			if (set != null) {
				set.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			} 
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	

}
