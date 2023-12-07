package com.atguigu.imperial.court.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.imperial.court.entity.Emp;
import com.atguigu.imperial.court.exception.LoginFailedException;
import com.atguigu.imperial.court.mapper.EmpMapper;
import com.atguigu.imperial.court.service.api.EmpService;
import com.atguigu.imperial.court.util.ImperialCourtConst;
import com.atguigu.imperial.court.util.MD5Util;

import tk.mybatis.mapper.entity.Example;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpMapper empMapper;

	@Override
	public Emp getEmpByLoginInfo(String loginAccount, String longinPassword) {

		// 执行密码加密
		String encodedLoginPassword = MD5Util.encode(longinPassword);

		// 创建Example对象，用于封装查询条件
		Example example = new Example(Emp.class);

		// 封装查询条件
		example.createCriteria().andEqualTo("loginAccount", loginAccount).andEqualTo("loginPassword",
				encodedLoginPassword);

		List<Emp> empList = empMapper.selectByExample(example);

		if (empList == null || empList.size() == 0) {
			throw new LoginFailedException(ImperialCourtConst.LOGIN_FAILED_MESSAGE);
		}

		return empList.get(0);
	}

}
