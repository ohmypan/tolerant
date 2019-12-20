package com.huahong.tolerant.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author huahong
 */
@EnableEurekaServer
@SpringBootApplication
public class HuahongEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuahongEurekaApplication.class, args);
    }

}
