package com.huahong.tolerant.join.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author pgz
 * @Description $
 * @Date 2019/12/12$ $
 * @Param $
 * @return $
 **/
@Component
public class KafkaMessageListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = "test", groupId = "test-consumer")
    public void listen(String message) {
        logger.info("接收消息: {}", message);
    }
}
