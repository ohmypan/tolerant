package com.huahong.tolerant.basic.deep.concurrency.producer_consumer.semaphore;

/**
 * File：Run <br>
 * Created on 2020/2/1.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class Run {
    public static void main(String[] args) throws InterruptedException{
        RepastService service = new RepastService();
        ThreadP[] arrayP = new ThreadP[60];
        ThreadC[] arrayC = new ThreadC[60];

        for(int i = 0;i<60;i++){
            arrayP[i] = new ThreadP(service);
            arrayC[i] = new ThreadC(service);
        }

        Thread.sleep(1000);

        for(int i = 0;i<60;i++){
            arrayP[i].start();
            arrayC[i].start();
        }

    }
}
