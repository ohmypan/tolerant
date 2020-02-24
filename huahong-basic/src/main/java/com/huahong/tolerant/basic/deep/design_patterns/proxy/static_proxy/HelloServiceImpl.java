package com.huahong.tolerant.basic.deep.design_patterns.proxy.static_proxy;

/**
 * File：HelloServiceImpl <br>
 * Created on 2020/2/23.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "hello";
    }
}
