package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
//实例工厂创建对象
public class UserDaoFactory {
	//非静态方法
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
