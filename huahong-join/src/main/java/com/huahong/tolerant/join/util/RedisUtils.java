package com.huahong.tolerant.join.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * File：RedisUtils <br>
 * Created on 2020/2/27.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate redisTemplate;

    public void set(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }
}
