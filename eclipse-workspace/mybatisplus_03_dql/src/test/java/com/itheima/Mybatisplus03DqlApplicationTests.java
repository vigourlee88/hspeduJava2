package com.itheima;

import java.util.List;
import java.util.Map;

import org.assertj.core.internal.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.query.UserQuery;

@SpringBootTest
class Mybatisplus03DqlApplicationTests {

	@Autowired
	private UserDao userDao;
	
	
	@Test
	void testGetAll() {
//		//方式一: 按条件查询
//		QueryWrapper qw = new QueryWrapper();
//		qw.lt("age", "18");	
//		List<User> userList = userDao.selectList(qw);
//		userList.forEach(System.out::println);	
	
		//方式二: lambda格式按条件查询
//		QueryWrapper<User> qw = new QueryWrapper<>();
//		qw.lambda().lt(User::getAge, 10);	
//		List<User> userList = userDao.selectList(qw);
//		userList.forEach(System.out::println);	
        
		//方式三: lambda格式按条件查询
//		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
//		lqw.lt(User::getAge, 10);	
//		List<User> userList = userDao.selectList(lqw);
//		userList.forEach(System.out::println);
		
//		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
		//10到30岁之间		
//		lqw.lt(User::getAge, 30).gt(User::getAge, 10);//小于,大于
		//小于10岁或者大于30岁
//		lqw.lt(User::getAge, 10).or().gt(User::getAge, 30);
//	
//		List<User> userList = userDao.selectList(lqw);
//		userList.forEach(System.out::println);
  
		//模拟页面传递过来的查询数据，实际开放中，已经被封装好，直接拿过来使用
//		UserQuery uq = new UserQuery();
////	uq.setAge(10);
//		uq.setAge2(30);
		
		//null判定
//		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
//		lqw.lt(User::getAge, uq.getAge2());	
//		lqw.gt(User::getAge, uq.getAge());	
//		List<User> userList = userDao.selectList(lqw);
//		userList.forEach(System.out::println);
			
//		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
//		//先判定第一个参数是否为true,如果为true连接当前条件
//      lqw.lt(null != uq.getAge2(), User::getAge, uq.getAge2());
//      lqw.gt(null != uq.getAge(), User::getAge, uq.getAge());
//		List<User> userList = userDao.selectList(lqw);
//		userList.forEach(System.out::println);
		
		//查询投影
////	LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
////	lqw.select(User::getId,User::getName,User::getAge);
//		QueryWrapper<User> lqw = new QueryWrapper<User>();
//		lqw.select("id","name","age","tel");
//		List<User> userList = userDao.selectList(lqw);
//		userList.forEach(System.out::println);
		
//		QueryWrapper<User> lqw = new QueryWrapper<User>();
//		lqw.select("count(*) as count,tel");
//		lqw.groupBy("tel");
//		List<Map<String,Object>> userList = userDao.selectMaps(lqw);
//		userList.forEach(System.out::println);//打印出(key=value)格式
		
		
		//条件查询 
//		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//		//eq等同于=
//      lqw.eq(User::getName, "Jerry").eq(User::getPassword, "jerry");//登录业务，实际开发中要做md5加密，从查询条件中取出这些值
//        
////    List<User> userList = userDao.selectList(lqw);
//		User loginUser = userDao.selectOne(lqw);
//		System.out.println(loginUser);
		
//		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
//		//范围查询lt le gt ge eq between
//		lqw.between(User::getAge, 10, 30);		
//		List<User> userList = userDao.selectList(lqw);
//		userList.forEach(System.out::println);
		
//		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
//		//模糊匹配like 右边是%
//		lqw.likeRight(User::getName, "J");		
//		List<User> userList = userDao.selectList(lqw);
//		userList.forEach(System.out::println);
	
		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
		List<User> userList = userDao.selectList(lqw);
		userList.forEach(System.out::println);
	
		
		
	}
		
}
