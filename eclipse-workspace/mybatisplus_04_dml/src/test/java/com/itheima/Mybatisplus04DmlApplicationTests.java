package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

@SpringBootTest
class Mybatisplus04DmlApplicationTests {

	@Autowired
	private UserDao userDao;
	
	@Test
	void testSave() {//新增
		User user = new User();
//		user.setId(666L);
//		user.setId(667L);
		user.setName("黑马程序员");
		user.setPassword("itheima");
		user.setAge(12);
		user.setTel("4006184000");
		userDao.insert(user);
	}
	
	@Test
	void testDelete() {
		userDao.deleteById(1698258223066251265L);
	}
	
	@Test
	void testUpdate() {//提供哪些字段就修改哪些值，不提供就不修改
		User user = new User();
		user.setId(1L);
		user.setName("Tom666");
		user.setPassword("tom888");
		userDao.updateById(user);
		
	}
		
}
