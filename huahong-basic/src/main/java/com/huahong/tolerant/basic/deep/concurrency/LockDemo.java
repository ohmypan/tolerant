package com.huahong.tolerant.basic.deep.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * File：LockDemo <br>
 * Created on 2020/4/11.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class LockDemo {

    final static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        if(lock.tryLock()){
            System.out.println("1");
        }
        lock.unlock();
    }
}
