package com.huahong.tolerant.basic.deep.reflection;

import java.lang.reflect.Field;

/**
 * File：PrivateDemo <br>
 * Created on 2020/2/21.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class PrivateDemo {
    public static void main(String[] args) throws Exception{

        Field field = Domain.class.getDeclaredField("loop");

        System.out.println(" field.getAnnotatedType() = " +  field.getAnnotatedType());
        field.setAccessible(true);
        Domain domain = new Domain("1");
        System.out.println(field.get(domain));
    }
}

