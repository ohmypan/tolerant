package com.huahong.tolerant.basic.deep.data_structure;

import org.junit.Test;

import java.util.Hashtable;

/**
 * File：HashTableDemo <br>
 * Created on 2020/2/16.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class HashTableDemo {

    @Test
    public void tableDemo(){
        Hashtable<String,Object> table = new Hashtable<>(16);
        table.put("11",222);
        table.put(null,"null");
        System.out.println(table);
    }
}
