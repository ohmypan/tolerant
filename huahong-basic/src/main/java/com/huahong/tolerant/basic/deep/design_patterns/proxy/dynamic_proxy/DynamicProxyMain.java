package com.huahong.tolerant.basic.deep.design_patterns.proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * File：DynamicProxyMain <br>
 * Created on 2020/2/23.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class DynamicProxyMain {

    public static void main(String[] args) {
        DynamicHelloServiceImpl service = new DynamicHelloServiceImpl();
        InvocationHandler proxy = new DynamicProxy(service);
        DynamicHelloService object =
                (DynamicHelloService)Proxy.newProxyInstance(DynamicHelloServiceImpl.class.getClassLoader(),
                        DynamicHelloServiceImpl.class.getInterfaces(),proxy);
        System.out.println("obj:" + object.sayHello());

    }
}
