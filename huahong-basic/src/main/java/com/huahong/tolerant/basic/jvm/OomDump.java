package com.huahong.tolerant.basic.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * File：OomDump <br>
 * Created on 2020/4/4.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class OomDump {

    public static List<Object> list = new ArrayList<>();

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new String( UUID.randomUUID().toString()));
            new String(UUID.randomUUID().toString());
        }
    }
}
