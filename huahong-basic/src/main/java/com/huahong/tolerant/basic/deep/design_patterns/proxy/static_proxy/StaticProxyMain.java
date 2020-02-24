package com.huahong.tolerant.basic.deep.design_patterns.proxy.static_proxy;

/**
 * File：StaticProxyMain <br>
 * Created on 2020/2/23.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class StaticProxyMain {
    public static void main(String[] args) {
        HelloServiceImpl service = new HelloServiceImpl();
        HelloProxy proxy = new HelloProxy(service);
        System.out.println(proxy.sayHello());
    }
}
