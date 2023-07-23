package com.itheima.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountDao {
	
	//表名tbl_account =>不是1是 字母l
	@Update("update tbl_account set money = money + #{money} where name = #{name}")
	void inMoney(@Param("name") String name,@Param("money") Double money);
	
	@Update("update tbl_account set money = money - #{money} where name = #{name}")
	void outMoney(@Param("name") String name,@Param("money") Double money);

}
