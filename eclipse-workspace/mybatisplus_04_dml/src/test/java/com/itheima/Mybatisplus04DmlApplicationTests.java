package com.itheima;

import java.util.ArrayList;
import java.util.List;

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
//		List<Long> list=new ArrayList<>();
//		list.add(1698253885501603842L);
//		list.add(1698255605086552066L);
//		list.add(1698256056964132866L);
//		userDao.deleteBatchIds(list);
		
//		List<Long> list=new ArrayList<>();
//		list.add(1L);
//		list.add(3L);
//		list.add(4L);
//		userDao.selectBatchIds(list);
		
		
		userDao.deleteById(2L);
//		System.out.println(userDao.selectList(null));
	}
	
	@Test
	void testUpdate() {//提供哪些字段就修改哪些值，不提供就不修改
//		User user = new User();
//		user.setId(3L);
//		user.setName("Jock666");
//		user.setVersion(1);//传入1传出2
//		userDao.updateById(user);
		
//		//1.先通过要修改的数据id将当前数据查询出来
//		User user = userDao.selectById(3L);
//		//2.将要修改的属性逐一设置进去
//		user.setName("Jock888");
//		userDao.updateById(user);
		
		//1.先通过要修改的数据id将当前数据查询出来
		User user = userDao.selectById(3L);//A用户version=3
		
		User user2 = userDao.selectById(3L);//B用户version=3
		
		user2.setName("Jock aaa");  //更新成功
		userDao.updateById(user2);  //version=>4 ok
		
		user.setName("Jock bbb");   //version=3?条件还成立吗?不成立
		userDao.updateById(user);
		
	}
		
}
