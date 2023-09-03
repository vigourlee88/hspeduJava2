package com.itheima;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;


@SpringBootTest
class Mybatisplus02QuickstartApplicationTests {

	@Autowired
	private UserDao userDao;
	
	@Test
	void testSave() {//新增
		User user = new User();
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
	
	@Test
	void testGetById() {
		User user = userDao.selectById(2L);
		System.out.println(user);
	}
	
	@Test
	void testGetAll() {
		List<User> userList = userDao.selectList(null);
		userList.forEach(System.out::println);	
	
    }
	
	@Test
	void testGetByPage() {
		//需要配置mp的分页拦截器才能显示单页信息，不是全部
		//IPage对象封装了分页操作相关的数据
		IPage page= new Page(1,3);//1查第几页，2有多少条
		userDao.selectPage(page, null);
		System.out.println("当前页码值: "+ page.getCurrent());
		System.out.println("每页显示数: "+ page.getSize());
		System.out.println("一共多少页: "+ page.getPages());
		System.out.println("一共多少条数据: "+ page.getTotal());
		System.out.println("数据: "+ page.getRecords());
	}

}
