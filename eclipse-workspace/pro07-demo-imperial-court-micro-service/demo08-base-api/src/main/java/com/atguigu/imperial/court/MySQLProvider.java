package com.atguigu.imperial.court;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.imperial.court.entity.Emp;
import com.atguigu.imperial.court.util.ResultEntity;

//@FeignClient 注解中指定的是提供服务的微服务名称，要和注册中心注册的一致
// @FeignClient 注解将当前接口标记为服务暴露接口
// name 属性：指定被暴露服务的微服务名称
@FeignClient(name = "demo06-mysql-data-provider")
public interface MySQLProvider {

	@RequestMapping("/remote/get/emp/by/login/info")
	ResultEntity<Emp> getEmpByLoginInfo(

			// @RequestParam 注解不能省略
			@RequestParam("loginAccount") String loginAccount, @RequestParam("loginPassword") String loginPassword);
}
