package com.huahong.tolerant.basic.domain;

import java.util.concurrent.Callable;

/**
 * @Author pgz
 * @Description $
 * @Date 2019/12/3$ $
 * @Param $
 * @return $
 **/
public class CallableDemo implements Callable<Integer> {
    private int sum;

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable子线程开始计算啦！");
        Thread.sleep(2000);

        for(int i=0 ; i < 5000 ; i++){
            sum = sum + i;
        }
        System.out.println("Callable子线程计算结束！");
        return sum;
    }
}
