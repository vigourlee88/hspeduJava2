package com.itheima.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;
import com.itheima.utils.CodeUtils;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

	@Autowired
	private CodeUtils codeUtils;

	// 使用jetcache整合远程的缓存 remote area=指定使用"ssm"
//    @CreateCache(area="sms",name="jetCache_",expire = 10,timeUnit = TimeUnit.SECONDS)cacheType 默认是远程方案redis

	@CreateCache(name = "jetCache_", expire = 1000, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.LOCAL)
	private Cache<String, String> jetCache;

	@Override
	public String sendCodeToSMS(String tele) {
		String code = codeUtils.generator(tele);// 生成验证码
		jetCache.put(tele, code);// 将取出的验证码放入缓存空间中
		return code;
	}

	@Override
	public boolean checkCode(SMSCode smsCode) {
		String code = jetCache.get(smsCode.getTele());
		return smsCode.getCode().equals(code);
	}

}
