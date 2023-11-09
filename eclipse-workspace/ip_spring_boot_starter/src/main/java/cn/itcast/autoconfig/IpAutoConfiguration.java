package cn.itcast.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import cn.itcast.properties.IpProperties;
import cn.itcast.service.IpCountServive;

@EnableScheduling
//@EnableConfigurationProperties(IpProperties.class)
@Import(IpProperties.class)
public class IpAutoConfiguration {

	@Bean
	public IpCountServive ipCountServive() {
		return new IpCountServive();
	}

}
