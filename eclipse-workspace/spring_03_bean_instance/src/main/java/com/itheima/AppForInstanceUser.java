package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.factory.UserDaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForInstanceUser {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        //创建实例工厂对象
//        UserDaoFactory userDaoFactory = new UserDaoFactory();
//        通过实例工厂对象创建对象，不是静态方法，需要通过对象去调用
//        UserDao userDao = userDaoFactory.getUserDao();
//        userDao.save();

     
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = (UserDao) ctx.getBean("userDao");

        userDao.save();

    }
}
