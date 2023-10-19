package com.itheima.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;
import com.itheima.utils.CodeUtils;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

	@Autowired
	private CodeUtils codeUtils;

	@Override
//	@Cacheable(value = "smsCode", key = "#tele") // 在业务层中当前方法的返回值code 进入到这个key=tele的缓存中存储起来
	@CachePut(value = "smsCode", key = "#tele")
	public String sendCodeToSMS(String tele) {
		String code = codeUtils.generator(tele);
		return code;
	}

	@Override
	public boolean checkCode(SMSCode smsCode) {
		// 取出内存中的验证码与传递过来的验证码比对。如果相同，返回true
		String code = smsCode.getCode();
		String cacheCode = codeUtils.get(smsCode.getTele());
		return code.equals(cacheCode);

	}

}
