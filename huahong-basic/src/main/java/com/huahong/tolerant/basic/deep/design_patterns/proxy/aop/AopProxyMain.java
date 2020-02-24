package com.huahong.tolerant.basic.deep.design_patterns.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * File：AopProxyMain <br>
 * Created on 2020/2/23.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class AopProxyMain {


    public static void main(String[] args) {
        AopServiceImpl aopService = new AopServiceImpl();
        InvocationHandler handler = new AopProxy(aopService);

        AopService service = (AopService)Proxy.newProxyInstance(AopServiceImpl.class.getClassLoader(),
                AopServiceImpl.class.getInterfaces(),handler);
        service.aopProxy();
    }
}
