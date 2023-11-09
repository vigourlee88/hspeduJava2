package cn.itcast.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import cn.itcast.service.IpCountServive;

public class IpCountInterceptor implements HandlerInterceptor {

	@Autowired
	private IpCountServive ipCountService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		ipCountService.count();
		return true;
	}

}
