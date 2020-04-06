package com.huahong.tolerant.orm.controller;

import com.huahong.tolerant.orm.model.Hr;
import com.huahong.tolerant.orm.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * File：HrController <br>
 * Created on 2020/4/6.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@RestController
@RequestMapping("/hr")
public class HrController {
    @Autowired
    private HrService hrService;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/getASimpleHr")
    public Hr getASimpleHr(Integer id){
        //Hr hr = redisTemplate.opsForValue().get("hr:" + id);
        return hrService.getASimpleHr(id);
    }
}
