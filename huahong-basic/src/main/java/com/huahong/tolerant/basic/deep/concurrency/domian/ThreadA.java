package com.huahong.tolerant.basic.deep.concurrency.domian;

import com.huahong.tolerant.basic.deep.concurrency.SemaphoreStudy;

/**
 * File：ThreadA <br>
 * Created on 2020/1/31.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class ThreadA extends Thread{
    private SemaphoreStudy semaphoreStudy;

    public ThreadA(SemaphoreStudy semaphoreStudy) {
        super();
        this.semaphoreStudy = semaphoreStudy;
    }

    @Override
    public void run() {
        //semaphoreStudy.testS1();
        semaphoreStudy.testS4();
    }
}
