package com.huahong.tolerant.join.sourcecode.mybatis.executor;

import java.util.List;

/**
 * File：SimpleExecutor <br>
 * Created on 2020/3/9.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class SimpleExecutor implements Executor {
    @Override
    public <E> List<E> query() {
        System.out.println("=============================");
        return null;
    }
}
