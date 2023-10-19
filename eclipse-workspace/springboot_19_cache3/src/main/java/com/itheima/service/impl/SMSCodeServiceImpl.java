package com.itheima.service.impl;

import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;
import com.itheima.utils.CodeUtils;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

	@Autowired
	private CodeUtils codeUtils;

	// 以下是springboot中使用xmemcached
	@Autowired
	private MemcachedClient memcachedClient;

//	@Override
////	@Cacheable(value = "smsCode", key = "#tele") // 在业务层中当前方法的返回值code 进入到这个key=tele的缓存中存储起来
//	@CachePut(value = "smsCode", key = "#tele")
//	public String sendCodeToSMS(String tele) {
//		String code = codeUtils.generator(tele);
//		return code;
//	}
//
//	@Override
//	public boolean checkCode(SMSCode smsCode) {
//		// 取出内存中的验证码与传递过来的验证码比对。如果相同，返回true
//		String code = smsCode.getCode();
//		String cacheCode = codeUtils.get(smsCode.getTele());
//		return code.equals(cacheCode);
//
//	}

	// 以下是springboot中使用xmemcached
	@Override
	public String sendCodeToSMS(String tele) {
		String code = codeUtils.generator(tele);
		try {
			memcachedClient.set(tele, 10, code);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {

			e.printStackTrace();
		}

		return code;
	}

	@Override
	public boolean checkCode(SMSCode smsCode) {
		String code = null;
		try {
			code = memcachedClient.get(smsCode.getTele());
		} catch (TimeoutException | InterruptedException | MemcachedException e) {

			e.printStackTrace();
		}

		return smsCode.getCode().equals(code);
	}
}
