package com.huahong.tolerant.basic.deep.data_structure;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * File：BlockingQueueDemo <br>
 * Created on 2020/2/13.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class BlockingQueueDemo {

    ExecutorService executor = Executors.newFixedThreadPool(5);

    final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    final BlockingQueue<String> arrayQueue = new ArrayBlockingQueue<>(16);

    /**
     * take 和 peek的区别 ，take会取出数据并删除，peek只取出数据
     */
    public class Consumer implements Runnable{
        @Override
        public void run() {
            try {
                String out = queue.take();
                System.out.println("消费类--" + out);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * add 和 offer 的区别，offer会等待
     */
    public class Provider implements Runnable{
        @Override
        public void run() {
            String str = "2";
            System.out.println("生产了--" + str);
            queue.add(str);
        }
    }
    @Test
    public void queueExp1() throws InterruptedException{
        for(int i=0;i<10;i++){
            executor.execute(new Consumer());
            executor.execute(new Provider());
        }
        System.out.println(queue.remainingCapacity());
        executor.shutdown();

    }
}
