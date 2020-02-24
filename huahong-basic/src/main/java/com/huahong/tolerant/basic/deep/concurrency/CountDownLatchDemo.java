package com.huahong.tolerant.basic.deep.concurrency;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    public void countDemo() throws InterruptedException{
        int count = 10;
        CountDownLatch cdl = new CountDownLatch(count);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i< count; i++){
            executorService.execute(()-> {
                System.out.println("run");
                cdl.countDown();
            });

        }
        cdl.await();
        System.out.println("End");
        executorService.shutdown();
    }
}
