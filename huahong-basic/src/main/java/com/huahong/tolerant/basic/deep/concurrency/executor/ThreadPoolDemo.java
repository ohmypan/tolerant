package com.huahong.tolerant.basic.deep.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * File：ThreadPoolDemo <br>
 * Created on 2020/2/11.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(()->{
            System.out.println("你太棒了");
        });

        executor.execute(()->{
            System.out.println("你太棒了ma");
        });

        executor.shutdown();
    }
}
