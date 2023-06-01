package com.hspedu.jdbc.batch_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.hspedu.jdbc.utils.JDBCUtils;

//演示java的批处理
public class Batch_ {

	//传统方法，添加5000条数据到admin2
	@Test
	public void noBatch() throws SQLException {
		Connection connection = JDBCUtils.getConnection();
		String sql = "insert into admin2 values(null,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		System.out.println("开始执行");
		long start = System.currentTimeMillis();//开始时间
		for (int i = 0; i < 5000; i++) {
			//给?,?赋值
			preparedStatement.setString(1, "jack" + i);
			preparedStatement.setString(2, "666");
			preparedStatement.executeUpdate();
		}
		long end = System.currentTimeMillis();//结束时间
		System.out.println("传统的方式 耗时=" + (end - start));//耗时=168040
		//关闭连接，添加操作无结果集，所以 null
		JDBCUtils.close(null, preparedStatement, connection);

		
	}
	
	//批量方法，添加5000条数据到admin2
	//注意:JDBC连接mysql时使用批量处理功能，、
	//请在配置文件的URL中添加参数?rewriteBatchedStatements=true
	@Test
	public void useBatch() throws Exception {
		Connection connection = JDBCUtils.getConnection();
		String sql = "insert into admin2 values(null,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		System.out.println("开始执行");
		long start = System.currentTimeMillis();//开始时间
		for (int i = 0; i < 5000; i++) {
			//给?,?赋值
			preparedStatement.setString(1, "jack" + i);
			preparedStatement.setString(2, "666");

			/*
			1.第1就创建ArrayList-elementData => Object[]
			2.elementData=>Object[] 就会存放我们预处理的sql语句
			3.当elementData满后，就按照1.5扩容
			4.当添加指定的值后，就executeBatch
			5.批量处理就会减少我们发送sql语句的网络开销
			public void addBatch() throws SQLException{
			  synchronized(this.checkClosed().getConnectionMutex();
			   if(this.batchedArgs == null){
			      this.batchedArgs = new ArrayList();
			      }
			      for(int i = 0;i < this.parametervalues.length;i++){
			        this.checkAllparametersSet(this.parameterValues[i]

			 */
			//将sql语句加入到批处理包中
			preparedStatement.addBatch();
			//当有1000条记录时，再批量执行
			if((i + 1) % 1000 == 0) {//1000条sql语句
				preparedStatement.executeBatch();//批量执行
				//清空一把
				preparedStatement.clearBatch();
				
			}
		}
		long end = System.currentTimeMillis();//结束时间
		System.out.println("批量方式 耗时=" + (end - start));//耗时=756
		//关闭连接，添加操作无结果集，所以 null
		JDBCUtils.close(null, preparedStatement, connection);
		
	}
	
}
