package com.itheima.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itheima.domain.Account;

//接口的映射
public interface AccountDao {
	@Select("delete from tbl_account where id = #{id} ")
    void delete(Integer id);

    @Insert("insert into tbl_account(`name`,money) values(#{name},#{money}) ")
    void save(Account account);

    @Update("update tbl_account set `name`=#{name},money=#{money}")
    void update(Account account);

    @Select("select * from tbl_account")
    List<Account> findAll();

    @Select("select * from tbl_account where id=#{id}")
    Account findById(Integer id);

}
