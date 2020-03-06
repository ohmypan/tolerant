package com.huahong.tolerant.basic.deep.concurrency;

/**
 * File：SynchronizedDemo <br>
 * Created on 2020/3/6.
 * Title:  <br>
 * Description:  synchronized(this)、synchronized（obj） synchronized（all） 的区别<br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class SynchronizedDemo {
    public static void main(String args[]){
        MethodImpl m = new MethodImpl();
//        SThis a=new SThis(m);
//        a.setName("ASThis");
//        a.start();
//        SThis b=new SThis(m);
//        b.setName("BSThis");
//        b.start();
//        SObj c=new SObj(m);
//        c.setName("ASThis");
//        c.start();
//        SObj d=new SObj(m);
//        d.setName("BSThis");
//        d.start();

        SSameObj e=new SSameObj(m);
        e.setName("ASThis");
        e.start();
        SSameObj f=new SSameObj(m);
        f.setName("BSThis");
        f.start();
    }


}
class MethodImpl{

    String lock = new String();
    public void print1(){
        try {
            synchronized (MethodImpl.class) {
                System.out.println("method begin 线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
                Thread.sleep(4000);
                System.out.println("method end   线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void print2(){
        try {
            synchronized (lock) {
                System.out.println("method begin 线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println("method end   线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void print3(){
        String localLock = new String();
        try {
            synchronized (localLock) {
                System.out.println("method begin 线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("method end   线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SThis extends Thread{
    private MethodImpl method;

    public SThis(MethodImpl method) {
        this.method = method;
    }

    @Override
    public void run() {
        method.print1();
    }

}
class SObj extends Thread{
    private MethodImpl method;
    public SObj(MethodImpl method) {
        this.method = method;
    }
    @Override
    public void run() {
        method.print2();
    }
}
class SSameObj extends Thread{
    private MethodImpl method;
    public SSameObj(MethodImpl method) {
        this.method = method;
    }
    @Override
    public void run() {
        method.print3();
    }
}