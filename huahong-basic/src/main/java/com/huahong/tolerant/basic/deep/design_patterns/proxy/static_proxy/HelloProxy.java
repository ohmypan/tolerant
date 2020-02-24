package com.huahong.tolerant.basic.deep.design_patterns.proxy.static_proxy;

/**
 * File：HelloProxy <br>
 * Created on 2020/2/23.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class HelloProxy implements HelloService{
    private HelloServiceImpl helloService;

    public HelloProxy(HelloServiceImpl helloService){
        this.helloService = helloService;
    }

    @Override
    public String sayHello() {
        System.out.println("proxy method");
        return helloService.sayHello();
    }
}
