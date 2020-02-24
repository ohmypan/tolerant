package com.huahong.tolerant.basic.deep.design_patterns.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * File：AopProxy <br>
 * Created on 2020/2/23.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class AopProxy implements InvocationHandler {
    private Object object;

    public AopProxy(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(object,args);
    }
}
