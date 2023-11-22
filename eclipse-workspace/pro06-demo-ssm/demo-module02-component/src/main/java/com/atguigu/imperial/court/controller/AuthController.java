package com.atguigu.imperial.court.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.imperial.court.entity.Emp;
import com.atguigu.imperial.court.service.api.EmpService;
import com.atguigu.imperial.court.util.ImperialCourtConst;

@Controller
public class AuthController {

	@Autowired
	private EmpService empService;

	@RequestMapping("/auth/login")
	public String doLogin(@RequestParam("loginAccount") String loginAccount,
			@RequestParam("loginPassword") String loginPassword, HttpSession session, Model mode

	) {

		// 1.尝试查询登录系统
		Emp emp = empService.getEmpByLogin(loginAccount, loginPassword);

		// 2.判断登录是否成功
		if (emp == null) {

			// 3.如果登录失败则回到登录页面提示消息
			mode.addAttribute("message", ImperialCourtConst.LOGIN_FAILED_MESSAGE);

			return "index";
		} else {

			// 4、如果登录成功则将登录信息存入 Session 域
			session.setAttribute("loginInfo", emp);

			return "target";

		}

	}

}
