package com.huahong.tolerant.basic.deep.design_patterns.template;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * File：TemplateImpl1 <br>
 * Created on 2020/3/1.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class TemplateImpl1 extends AbstractTemplate{
    @Override
    int getRandomNumber() {
        num = RandomUtils.nextInt();
        return num;
    }

    @Override
    String printRandomNumber() {
        System.out.println(num);
        return null;
    }

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("consumer-queue-thread-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(5, 5, 60L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0;i<10000;i++){
            pool.execute(() -> System.out.println("开始" + RandomUtils.nextDouble()));
        }
        pool.shutdown();
        int[] a = {1,2,4,5,1,5,6};
        TemplateImpl1 templateImpl1 = new TemplateImpl1();
        Arrays.sort(a);
        templateImpl1.doAll();
    }
}
