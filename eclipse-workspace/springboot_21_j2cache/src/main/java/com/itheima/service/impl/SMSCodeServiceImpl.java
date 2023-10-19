package com.itheima.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;
import com.itheima.utils.CodeUtils;

import net.oschina.j2cache.CacheChannel;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

	@Autowired
	private CodeUtils codeUtils;

	@Autowired
	private CacheChannel cacheChannel; // 定义缓存对象

	@Override
	public String sendCodeToSMS(String tele) {
		String code = codeUtils.generator(tele);
		cacheChannel.set("sms", tele, code);// name,key,value
		return code;
	}

	@Override
	public boolean checkCode(SMSCode smsCode) {
		String code = cacheChannel.get("sms", smsCode.getTele()).asString();
		return smsCode.getCode().equals(code);
	}

}
