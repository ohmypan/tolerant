package com.huahong.tolerant.join.domain.message;

import lombok.Data;

/**
 * @Author pgz
 * @Description $
 * @Date 2019/12/13$ $
 * @Param $
 * @return $
 **/
@Data
public class KafkaMessage {
    /**
     * 消息
     */
    private String message;

    /**
     * 从哪来
     */
    private String from;
}
