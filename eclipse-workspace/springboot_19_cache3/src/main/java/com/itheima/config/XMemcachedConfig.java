package com.itheima.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;

@Configuration
public class XMemcachedConfig {

	@Autowired
	private XMemcachedProperties memcachedProperties;

	@Bean
	public MemcachedClient getMemcachedClient() throws IOException {
		MemcachedClientBuilder memcachedClientBuilder = new XMemcachedClientBuilder(memcachedProperties.getServers());
		memcachedClientBuilder.setConnectionPoolSize(memcachedProperties.getPoolSize());
		memcachedClientBuilder.setOpTimeout(memcachedProperties.getOpTimeout());
		MemcachedClient memcachedClient = memcachedClientBuilder.build();
		return memcachedClient;

	}

}
