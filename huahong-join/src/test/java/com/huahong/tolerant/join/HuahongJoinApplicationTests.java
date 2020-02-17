package com.huahong.tolerant.join;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HuahongJoinApplicationTests {

    @Test
    void contextLoads() {
        BeanFactory factory = new DefaultListableBeanFactory();
        factory.getBean("iocObject");
    }

}
