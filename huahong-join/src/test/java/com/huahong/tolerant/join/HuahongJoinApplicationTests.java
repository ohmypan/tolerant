package com.huahong.tolerant.join;

import com.huahong.tolerant.join.domain.mybatis.Role;
import com.huahong.tolerant.join.mapper.RoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class HuahongJoinApplicationTests {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void contextLoads() {
       Role role =  roleMapper.getRoleById(1L);
       log.debug("role = {}",role);
    }

}
