package com.hspedu.resultset_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//演示select查询语句，返回一个ResultSet，并取出结果
public class ResultSet_ {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		
		//通过Properties对象获取配置文件的信息
		Properties properties = new Properties();
		properties.load(new FileInputStream("src//mysql.properties"));
		//获取相关的值
		String user = properties.getProperty("user");
      	String password = properties.getProperty("password");
      	String driver = properties.getProperty("driver");
      	String url = properties.getProperty("url");
      	
      	//1.加载驱动
      	//Class.forName("com.mysql.jdbc.driver");
      	Class.forName(driver);
      	
      	//2.得到连接
      	Connection connection = DriverManager.getConnection(url, user, password);
	
      	//3.得到一个Statement
      	Statement statement = connection.createStatement();
      	//4.组织SQL语句
      	String sql = "select id,name,sex,borndate from actor";
      	/*
      	 * +----+--------+-----+---------------------+-------+
           | id | name   | sex | borndate            | phone |
           +----+--------+-----+---------------------+-------+
           | 11 | 刘德华 | 男  | 1970-12-12 00:00:00 | 110   |
           | 12 | jack   | 男  | 1990-12-12 00:00:00 | 112   |
           +----+--------+-----+---------------------+-------+
      	 * 
      	 */
      	//这里不是DML语句，所以使用executeQuery
      	ResultSet resultSet = statement.executeQuery(sql);
      	
      	//5.使用while取出数据
      	//resultSet开始指向 表头
        //next()让光标向后移动，如果没有更多的行，则返回false
      	while(resultSet.next()) {
      		int id = resultSet.getInt(1);//获取该行的第1列
      		int id1 = resultSet.getInt("id");//通过 列名 获取值
      		String name = resultSet.getString(2);//获取该行的第2列
      		String sex = resultSet.getString(3);//获取该行的第3列
      		Date date = resultSet.getDate(4);//获取该行的第4列
      		
      		System.out.println(id + "\t" + name +"\t"
      				           + sex + "\t" + date);
      		
      	}
      	//6.关闭连接
      	resultSet.close();
      	statement.close();
      	connection.close();
	}

}
