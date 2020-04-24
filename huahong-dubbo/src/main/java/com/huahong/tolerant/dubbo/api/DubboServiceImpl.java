package com.huahong.tolerant.dubbo.api;

/**
 * File：DubboServiceImpl <br>
 * Created on 2020/4/8.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class DubboServiceImpl implements DubboService {
    @Override
    public String sayHi(String name) {
        return "hi, " + name;
    }
}
