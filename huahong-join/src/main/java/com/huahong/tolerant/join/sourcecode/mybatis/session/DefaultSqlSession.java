package com.huahong.tolerant.join.sourcecode.mybatis.session;

import com.huahong.tolerant.join.sourcecode.mybatis.executor.Executor;

/**
 * File：DefaultSqlSession <br>
 * Created on 2020/3/9.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;
    private Executor executor;

    @Override
    public <T> T selectOne(String statement) {
        return null;
    }
}
