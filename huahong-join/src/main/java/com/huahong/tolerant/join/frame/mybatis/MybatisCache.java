package com.huahong.tolerant.join.frame.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * File：MybatisCache <br>
 * Created on 2020/2/10.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class MybatisCache {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void doit(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
//            User user = (User)sqlSession.selectOne("org.format.mybatis.cache.UserMapper.getById", 1);
//            log.debug(user);
//            User user2 = (User)sqlSession.selectOne("org.format.mybatis.cache.UserMapper.getById", 1);
//            log.debug(user2);
        } finally {
            sqlSession.close();
        }
    }
}
