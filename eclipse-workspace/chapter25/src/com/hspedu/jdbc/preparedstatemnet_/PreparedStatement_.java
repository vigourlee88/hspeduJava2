package com.hspedu.jdbc.preparedstatemnet_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

//演示PreparedStatement使用查询语句

@SuppressWarnings({"all"})
public class PreparedStatement_ {
	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
		
        Scanner scanner = new Scanner(System.in);
		
		// 让用户输入管理员名和密码
		System.out.println("请输入管理员的名字 :");//next() 接收空格或'单引号就结束 nextLine() 回车就结束
		String admin_name = scanner.nextLine();//说明，如果希望看到sql注入，这里需要用nextLine()
		System.out.println("请输入管理员的密码 :");
		String admin_pwd = scanner.nextLine();
		
		// 通过Properties对象获取配置文件的信息
		Properties properties = new Properties();
		properties.load(new FileInputStream("src\\mysql.properties"));
		// 获取相关的值
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");

		// 1.注册驱动
		Class.forName(driver);
		// 2.得到连接
		Connection connection = DriverManager.getConnection(url, user, password);
		// 3.得到PreparedStatement接口
		// 3.1组织Sql,Sql语句的 ? 相当于占位符
		String sql = "select name , pwd from admin where name = ? and pwd = ?";
        //3.2prepareStatement对象实现了PreparedStatement接口的实现类的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    //3.3给 ? 赋值
        preparedStatement.setString(1, admin_name);
        preparedStatement.setString(2, admin_pwd);
        
        //4.执行select语句，要使用executeQuery()
        //  执行的是dml(delete,insert,update) executeUpdate()
        //  这里执行executeQuery,不要写(sql)了
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {//如果查询到一条记录，则说明该管理员存在
			System.out.println("恭喜，登录成功");

		}else {
			System.out.println("对不起，登录失败");
		}
		
		//关闭连接
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
	}
}
