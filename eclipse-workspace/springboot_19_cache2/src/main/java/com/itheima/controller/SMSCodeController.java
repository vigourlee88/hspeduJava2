package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;

@RestController
@RequestMapping("/sms")
public class SMSCodeController {

	@Autowired
	private SMSCodeService smsCodeService;

	@GetMapping
	public String getCode(String tele) {
		String code = smsCodeService.sendCodeToSMS(tele);
		return code;
	}

	@PostMapping
	public boolean checkCode(SMSCode smsCode) {
		return smsCodeService.checkCode(smsCode);
	}

}
