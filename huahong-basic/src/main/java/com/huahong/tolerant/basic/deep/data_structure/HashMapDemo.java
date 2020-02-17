package com.huahong.tolerant.basic.deep.data_structure;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * File：HashMapDemo <br>
 * Created on 2020/2/11.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class HashMapDemo {

    @Test
    public void hashMapCon() throws InterruptedException{
        Map<String,Object> map = new HashMap<>(16);
        map.put("11","@2");
        System.out.println(map.hashCode());

        Map<String,Object> cMap = new ConcurrentHashMap<>();
        cMap.putIfAbsent("y",123);
        cMap.putIfAbsent("y",234);
        System.out.println(cMap);
    }
}
