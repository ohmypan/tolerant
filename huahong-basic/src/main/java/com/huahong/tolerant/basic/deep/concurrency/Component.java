package com.huahong.tolerant.basic.deep.concurrency;


import com.huahong.tolerant.basic.domain.CallableDemo;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * @Author huahong
 * @Description $
 * @Date 2019/12/6$ $
 * @Param $
 * @return $
 **/
public class Component {
    private static final ScheduledExecutorService SERVICE = new ScheduledThreadPoolExecutor(10, new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());


    /**
     * CountDownLatch
     * 利用它可以实现类似计数器的功能。比如有一个任务A，它要等待其他10个任务执行完毕之后才能执行
     * @return
     */
    public static Object countDownLatch() throws Exception{
        final  CountDownLatch latch = new CountDownLatch(1);
        CallableDemo calTask = new CallableDemo();
        FutureTask<Integer> futureTask = new FutureTask<>(calTask);
        SERVICE.execute(futureTask);
        while (futureTask.isDone()){
            latch.countDown();
        }
        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * CyclicBarrier
     * @return
     */
    public static Object cyclicBarrier() throws Exception{
        CyclicBarrier barrier = new CyclicBarrier(10);

        barrier.await();
        return null;
    }


    public static void main(String[] args) throws Exception {
        //countDownLatch();
        String msg = String.format("%s|%s|%s|%s","!","2","3","555");
        System.out.println("330100D15600000500753CC8404DDC4D".substring(0,6));
    }
}
