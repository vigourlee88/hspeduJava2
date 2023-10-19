package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;

@SpringBootApplication
//jetcache启用缓存的主开关
@EnableCreateCacheAnnotation // 启用使用注解的方式创建缓存
//开启方法注解缓存
@EnableMethodCache(basePackages = "com.itheima")

public class Springboot20JetcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot20JetcacheApplication.class, args);
	}

}
