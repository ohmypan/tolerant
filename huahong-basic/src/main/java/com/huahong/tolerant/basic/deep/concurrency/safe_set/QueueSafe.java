package com.huahong.tolerant.basic.deep.concurrency.safe_set;

import org.junit.Test;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * File：QueueSafe <br>
 * Created on 2020/2/6.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class QueueSafe {

    /**
     * 双向列表，Deque是双端队列
     */
    @Test
    public void blockingDeque(){
        BlockingDeque<Integer> deque = new LinkedBlockingDeque<>();
        deque.add(1);
        deque.add(2);
        System.out.println(deque);
        deque.peek();
        System.out.println(deque);
        deque.poll();
        System.out.println(deque);
    }

    /**
     * Queue是FIFO的单端队列
     */
    @Test
    public void blockingQueue() throws InterruptedException{
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        queue.add("1");
        queue.add("2");
        System.out.println(queue);
        queue.take();
        System.out.println(queue);
        queue.peek();
        System.out.println(queue);
    }
}
