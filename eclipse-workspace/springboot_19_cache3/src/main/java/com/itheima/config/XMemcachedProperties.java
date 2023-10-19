package com.itheima.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "memcached")
@Data
public class XMemcachedProperties {
	private String servers;
	private int poolSize;
	private long opTimeout;

}
