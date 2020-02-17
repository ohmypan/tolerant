package com.huahong.tolerant.basic.deep.sourcecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * File：StringMethod <br>
 * Created on 2020/2/10.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class StringMethod {

    @Test
    public void mainCore(){
        String str = "233";
        System.out.println(str);
        String str3 = "23" + "3";
        String str2 = new String("233");
        String str1 = "233".intern();

        Map<String,Object> map = new HashMap<>(16);
        System.out.println(str == str1);
        System.out.println(str == str2);
        System.out.println(str == str3);
    }
}
