package com.itheima.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.LogDao;
import com.itheima.service.LogService;

@Service
//业务层接口上添加Spring事务，设置事务传播行为REQUIRES_NEW(需要新鲜事务)
public class LogServiceImpl implements LogService{
	@Autowired
    private LogDao logDao;

   
	@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void log(String out, String in, Double money) {
        logDao.log(out + "向" + in + "转账" + money + "元");
    }

}
