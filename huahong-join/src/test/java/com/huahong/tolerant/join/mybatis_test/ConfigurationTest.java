package com.huahong.tolerant.join.mybatis_test;

import com.huahong.tolerant.join.domain.mybatis.Role;
import com.huahong.tolerant.join.mapper.RoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * File：ConfigurationTest <br>
 * Created on 2020/3/9.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class ConfigurationTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void ConfigTest(){

        Role role = roleMapper.getRoleById(1L);

        log.info("role:{}",role);
    }
}
