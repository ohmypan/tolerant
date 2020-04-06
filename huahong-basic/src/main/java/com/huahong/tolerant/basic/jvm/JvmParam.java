package com.huahong.tolerant.basic.jvm;

/**
 * File：JvmParam <br>
 * Created on 2020/4/2.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class JvmParam {



    public static void main(String[] args) throws Exception{
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6;
        allocation1 = new byte[60000*1024];

        allocation2 = new byte[8000*1024];

        allocation3 = new byte[1000*1024];
        allocation4 = new byte[1000*1024];
        allocation5 = new byte[1000*1024];
        allocation6 = new byte[1000*1024];
      //Thread.sleep(Integer.MAX_VALUE);
    }

    public void printStr(String str){

    }
}
