package com.huahong.tolerant.join.interceptor.mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.util.Properties;

/**
 * File：SqlStatementInterceptor <br>
 * Created on 2020/3/9.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
@Intercepts({@Signature(type = Executor.class, method = "query", args = {Statement.class,
        ResultHandler.class}),
        @Signature(type = Executor.class, method = "update", args = {Statement.class}),
        @Signature(type = Executor.class, method = "batch", args = { Statement.class })})
@Component
public class SqlStatementInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println(invocation.getTarget() + "++++++++++++++++++++=");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
        //this.properties = properties;
    }
}
