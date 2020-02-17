package com.huahong.tolerant.basic.deep.concurrency;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * File：CountDownLatchDemo <br>
 * Created on 2020/2/13.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class CountDownLatchDemo {

    @Test
    public void countDemo(){
        CountDownLatch cdl = new CountDownLatch(3);


        cdl.countDown();
    }
}
