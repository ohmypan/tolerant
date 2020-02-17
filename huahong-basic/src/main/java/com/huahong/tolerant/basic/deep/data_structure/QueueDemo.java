package com.huahong.tolerant.basic.deep.data_structure;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * File：QueueDemo <br>
 * Created on 2020/2/13.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class QueueDemo {
    @Test
    public void queueCon() throws InterruptedException{
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.offer("0");

        System.out.println(queue);
        queue.peek();
        System.out.println(queue);



    }
}
