package com.huahong.tolerant.basic.deep.concurrency;

import com.huahong.tolerant.basic.deep.concurrency.domian.ThreadA;
import com.huahong.tolerant.basic.deep.concurrency.domian.ThreadB;
import com.huahong.tolerant.basic.deep.concurrency.domian.ThreadC;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * File：SemaphoreStudy <br>
 * Created on 2020/1/31.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class SemaphoreStudy {

    private Semaphore semaphore = new Semaphore(3);

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void testS1(){
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "s-time:" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "e-time:" + System.currentTimeMillis());
            semaphore.release();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void testS2(){
        try {
            if(semaphore.tryAcquire()){
                System.out.println(Thread.currentThread().getName() + "s-time:" + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "e-time:" + System.currentTimeMillis());
                semaphore.release();
            }else{
                System.out.println(Thread.currentThread().getName() + "---------->未成功进入");
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void testS3(){
        try {
            // 1s 尝试，失败为false （时间）
            if(semaphore.tryAcquire(1, TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getName() + "s-time:" + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "e-time:" + System.currentTimeMillis());
                semaphore.release();
            }else{
                System.out.println(Thread.currentThread().getName() + "---------->未成功进入");
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void testS4(){
        try {
            semaphore.acquire();
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "start-:");
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName() + "->index:"+ i);
            }
            lock.unlock();
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + "end-:");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SemaphoreStudy study = new SemaphoreStudy();
        ThreadA t1 = new ThreadA(study);
        t1.setName("t1");
        ThreadB t2 = new ThreadB(study);
        t2.setName("t2");
        ThreadC t3 = new ThreadC(study);
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
    }


    @Test
    public void start() {
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequestCount; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.print(semaphore.availablePermits() + " ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }
}
