package com.huahong.tolerant.basic.deep.concurrency;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * File：ThreadMethod <br>
 * Created on 2020/2/9.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class ThreadMethod {
    /**
     * public static native Thread currentThread(); 返回对当前正在执行的线程对象的引用。
     * public long getId()返回该线程的标识符。
     * public final String getName()返回该线程的名称。
     * public final int getPriority()返回线程的优先级。
     * public void interrupt() 中断线程。
     * public final native boolean isAlive();测试线程是否处于活动状态。
     * public final void join() throws InterruptedException等待该线程终止。
     * public final synchronized void join(long millis) throws InterruptedException等待该线程终止的时间最长为 millis 毫秒。
     * public final synchronized void join(long millis, int nanos) throws InterruptedException 等待该线程终止的时间最长为 millis 毫秒 + nanos 纳秒。
     * public final void setDaemon(boolean on)将该线程标记为守护线程或用户线程。
     * public final void setPriority(int newPriority) 更改线程的优先级。
     * public static native void sleep(long millis) throws InterruptedException;在指定的毫秒数内让当前正在执行的线程休眠（暂停执行），此操作受到系统计时器和调度程序精度和准确性的影响。
     * public static void sleep(long millis, int nanos)throws InterruptedException 在指定的毫秒数加指定的纳秒数内让当前正在执行的线程休眠（暂停执行），此操作受到系统计时器和调度程序精度和准确性的影响。
     * public synchronized void start()使该线程开始执行；Java 虚拟机调用该线程的 run 方法。
     * public static native void yield();暂停当前正在执行的线程对象，并执行其他线程。
     */
    final ThreadPoolExecutor executor = new ThreadPoolExecutor(3,10,600, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>());

    /**
     * join 让父线程等待子线程结束之后才能继续运行。
     * join()方法是通过wait()方法 (Object 提供的方法) 实现的。当 millis == 0 时，会进入 while(isAlive()) 循环，
     * 并且只要子线程是活的，宿主线程就不停的等待。 wait(0) 的作用是让当前线程(宿主线程)等待，
     * 而这里的当前线程是指 Thread.currentThread() 所返回的线程。所以，虽然是子线程对象(锁)调用wait()方法，但是阻塞的是宿主线程。
     * sleep 线程睡眠
     */
    @Test
    public void tryJoin(){
        Thread thread = new JoinClass();
        thread.start();
        try {
            //主线程等待thread的业务处理完了之后再向下运行

            //thread和主线程合并了,先运行thread中的代码
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < 100; i++){
            System.out.println("main : " + i);
        }
    }
    class JoinClass extends Thread {
        @Override
        public void run() {
            for(int i = 0; i < 5; i++){
                System.out.println("i am " + getName());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 线程的优先级用数字表示，范围从1到10，默认的是为5
     * 每个线程默认的优先级与创建它的父线程的优先级相同
     * 优先级越高的线程，被执行的顺序就比较靠前，在Thread中存在三个常量：
     *
     * public final static int MIN_PRIORITY = 1;
     * public final static int NORM_PRIORITY = 5;
     * public final static int MAX_PRIORITY = 10;
     */
    @Test
    public void tryPriority(){
        Thread t1 = new Thread(new Priority(), "线程A");
        Thread t2 = new Thread(new Priority(), "线程B");
        Thread t3 = new Thread(new Priority(), "线程C");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }

    class Priority implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    /**
     * 守护线程：
     *      指在程序运行的时候在后台提供一种通用服务的线程，并且这种线程并不属于程序中不可或缺的部分。
     * 因此当所有的非后台线程结束时，程序也就终止了，同时会杀死进程中的所有后台线程。
     * 通过setDaemon(true)来设置该线程为后台线程。
     */
    class DaemonModel implements Runnable{ // 实现Runnable接口
        public void run(){  // 覆写run()方法
            while(true){
                System.out.println(Thread.currentThread().getName() + "在运行。") ;
            }
        }
    }
    @Test
    public void Test(){
        DaemonModel mt = new DaemonModel() ;  // 实例化Runnable子类对象
        Thread t = new Thread(mt,"守护线程");     // 实例化Thread对象
        t.setDaemon(true) ; // 此线程在后台运行
        t.start() ; // 启动线程
    }

    /**
     *
     * 终止线程
     * 有三种方法可以使终止线程。
     * 1. 使用退出标志，使线程正常退出，也就是当run方法完成后线程终止。
     * 2. 使用stop方法强行终止线程（这个方法不推荐使用，因为stop和suspend、resume一样，也可能发生不可预料的结果）。
     * 3. 使用interrupt方法中断线程。
     */
}
