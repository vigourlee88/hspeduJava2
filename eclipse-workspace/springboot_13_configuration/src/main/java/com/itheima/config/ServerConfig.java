package com.itheima.config;

import java.time.temporal.ChronoUnit;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import ch.qos.logback.core.joran.spi.HostClassAndPropertyDouble;
import ch.qos.logback.core.util.Duration;
import lombok.Data;

//@Component 
@Data
@ConfigurationProperties(prefix = "servers")
//2.开启对当前bean的属性注入校验
@Validated
public class ServerConfig {
	
	private String ipAddress;
	//3.设置具体的规则
    @Max(value = 8888,message = "最大值不能超过8888")
    @Min(value = 202,message = "最小值不能低于202")
	private int port;
	private long timeout;
	
	//jdk8提供的时间与空间计量单位
	@DurationUnit(ChronoUnit.MINUTES)
	private Duration serverTimeOut;
	
	//存储空间的单位大小
//	@DataSizeUnit(DataUnit.MEGABYTES)
	private DataSize dataSize;	
	
	private Host host;

}
