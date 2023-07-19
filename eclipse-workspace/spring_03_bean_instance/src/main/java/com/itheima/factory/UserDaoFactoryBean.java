package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;
//FactoryBean创建对象UserDao
public class UserDaoFactoryBean implements FactoryBean<UserDao> {
    //代替原始实例工厂中创建对象的方法
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();//给一个对象
    }

    public Class<?> getObjectType() {
        return UserDao.class;//什么类型
    }

	@Override
	public boolean isSingleton() {
		
		return true;//修改单例
	}
    
    

}
