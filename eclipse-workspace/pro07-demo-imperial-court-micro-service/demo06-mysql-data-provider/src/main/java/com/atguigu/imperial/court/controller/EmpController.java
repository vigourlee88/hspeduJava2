package com.atguigu.imperial.court.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.imperial.court.entity.Emp;
import com.atguigu.imperial.court.service.api.EmpService;
import com.atguigu.imperial.court.util.ResultEntity;

@RestController
public class EmpController {

	@Autowired
	private EmpService empService;

	@RequestMapping("/remote/get/emp/by/login/info")
	ResultEntity<Emp> getEmpByLoginInfo(

			// @RequestParam 注解不能省略
			@RequestParam("loginAccount") String loginAccount, @RequestParam("loginPassword") String loginPassword) {

		try {
			// 1.调用Service 方法 根据账号，密码查询Emp对象
			Emp emp = empService.getEmpByLoginInfo(loginAccount, loginPassword);

			// 2.返回成功消息
			return ResultEntity.successWithData(emp);

		} catch (Exception e) {

			e.printStackTrace();

			String message = e.getMessage();

			// 3.返回失败消息
			return ResultEntity.failed(message);

		}
	}
}
