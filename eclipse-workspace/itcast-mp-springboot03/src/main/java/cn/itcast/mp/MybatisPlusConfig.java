package cn.itcast.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

@MapperScan("cn.itcast.mp.simple.mapper")//设置mapper接口的扫描包
@Configuration
//配置分页插件
public class MybatisPlusConfig {

    @Bean
    PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

}
