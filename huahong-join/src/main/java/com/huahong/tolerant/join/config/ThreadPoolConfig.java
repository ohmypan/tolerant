package com.huahong.tolerant.join.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * File：ThreadPoolConfig <br>
 * Created on 2020/3/1.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@Configuration
public class ThreadPoolConfig {

    @Bean("consumerQueueThreadPool")
    public ExecutorService consumerQueueThreadPool(){
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("consumer-queue-thread-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(30),namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        return pool ;
    }
}
