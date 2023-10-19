package com.itheima.service;

import com.itheima.domain.SMSCode;

public interface SMSCodeService {
	// 发送验证码到手机
	public String sendCodeToSMS(String tele);

	// 校验结果
	public boolean checkCode(SMSCode smsCode);

}
