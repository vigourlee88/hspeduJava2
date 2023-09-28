package com.itheima.testcase.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component  //加载数据，设置成bean
@Data
@ConfigurationProperties(prefix = "testcase.book")//加载配置文件中的哪个数据
public class BookCase {
    private int id;
    private int id2;
    private int type;
    private String name;
    private String uuid;
    private long publishTime;
}
