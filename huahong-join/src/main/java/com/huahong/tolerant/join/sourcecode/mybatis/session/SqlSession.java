package com.huahong.tolerant.join.sourcecode.mybatis.session;

/**
 * File：SqlSession <br>
 * Created on 2020/3/9.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public interface SqlSession {
    <T> T selectOne(String statement);
}
