package com.huahong.tolerant.basic.deep.concurrency.producer_consumer.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * File：RepastService <br>
 * Created on 2020/2/1.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class RepastService {
    // 厨师
    volatile private Semaphore setSemaphore = new Semaphore(10);
    //顾客
    volatile private Semaphore getSemaphore = new Semaphore(20);
    //锁
    volatile private ReentrantLock lock = new ReentrantLock();

    volatile private Condition setCondition = lock.newCondition();

    volatile private Condition getCondition = lock.newCondition();

    volatile private Object[] producePosition = new Object[4];

    private boolean isEmpty(){
        boolean isEmpty = true;
        for(int i=0;i<producePosition.length;i++){
            if(producePosition[i] != null){
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    private boolean isFull(){
        boolean isFull = true;
        for(int i=0;i<producePosition.length;i++){
            if(producePosition[i] == null){
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void set(){
        try{
            setSemaphore.acquire();
            lock.lock();
            while (isFull()){
                setCondition.await();
            }
            for(int i=0;i<producePosition.length;i++){
                if(producePosition[i] == null){
                    producePosition[i] = "数据";
                    System.out.println(Thread.currentThread().getName() + "生产了" + producePosition[i]);
                    break;
                }
            }
            getCondition.signalAll();
            lock.unlock();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            setSemaphore.release();
        }
    }


    public void get(){
        try{
            getSemaphore.acquire();
            lock.lock();

            while (isEmpty()){
                getCondition.await();
            }
            for(int i=0;i<producePosition.length;i++){
                if(producePosition[i] != null){

                    System.out.println(Thread.currentThread().getName() + "消费了" + producePosition[i]);
                    producePosition[i] = null;
                    break;
                }
            }
            setCondition.signalAll();
            lock.unlock();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            getSemaphore.release();
        }
    }
}
