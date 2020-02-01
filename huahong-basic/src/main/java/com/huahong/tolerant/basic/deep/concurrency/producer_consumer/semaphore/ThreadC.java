package com.huahong.tolerant.basic.deep.concurrency.producer_consumer.semaphore;

/**
 * File：ThreadP <br>
 * Created on 2020/2/1.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class ThreadC extends Thread {
    private RepastService repastService;

    public ThreadC(RepastService repastService) {
        super();
        this.repastService = repastService;
    }

    @Override
    public void run() {
        repastService.get();
    }
}
