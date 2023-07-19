package com.itheima;

import com.itheima.dao.OrderDao;
import com.itheima.dao.UserDao;
import com.itheima.factory.OrderDaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForInstanceOrder {
    public static void main(String[] args) {
        //通过静态工厂创建对象
//        OrderDao orderDao = OrderDaoFactory.getOrderDao();
//        orderDao.save();


        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
//        OrderDao orderDao1 = (OrderDao) ctx.getBean("orderDao");
//        OrderDao orderDao2 = (OrderDao) ctx.getBean("orderDao");
//        System.out.println(orderDao1);
//        System.out.println(orderDao2);
       orderDao.save();

    }
}
