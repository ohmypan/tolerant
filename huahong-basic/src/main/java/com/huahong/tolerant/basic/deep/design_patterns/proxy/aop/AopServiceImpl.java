package com.huahong.tolerant.basic.deep.design_patterns.proxy.aop;

/**
 * File：AopServiceImpl <br>
 * Created on 2020/2/23.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class AopServiceImpl implements  AopService {
    @Override
    public void aopProxy() {
        System.out.println("aop");
    }
}
