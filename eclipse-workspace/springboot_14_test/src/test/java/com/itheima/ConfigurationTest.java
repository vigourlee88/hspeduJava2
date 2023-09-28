package com.itheima;

import com.itheima.config.MsgConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

//使用@Import注解加载当前测试类 专用的配置
@SpringBootTest
@Import({MsgConfig.class})
public class ConfigurationTest {

    @Autowired
    private String msg;

    @Test
    void testConfiguration(){
        System.out.println(msg);
    }

}
