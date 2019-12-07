package com.huahong.tolerant.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @date 2019年12月6日10:51:32
 * @author huahong
 */
@SpringBootApplication
@EnableCaching
@EnableScheduling
public class BasicApplication {

    public static void main(String[] args){
        SpringApplication.run(BasicApplication.class, args);
    }

}
