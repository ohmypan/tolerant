package com.huahong.tolerant.join.util;


import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.TimeIntervalAspect;
import cn.hutool.core.lang.Console;

/**
 * @Author pgz
 * @Description $
 * @Date 2019/12/14$ $
 * @Param $
 * @return $
 **/

public class HuToolsCare {
    public static void main(String[] args) {
        Animal cat = ProxyUtil.proxy(new Cat(), TimeIntervalAspect.class);
        String result = cat.eat();

        cat.seize();
    }

    interface Animal {
        String eat();

        void seize();
    }
    /**
     * 有接口
     *
     * @author looly
     */
    static class Cat implements Animal {

        @Override
        public String eat() {
            return "猫吃鱼";
        }

        @Override
        public void seize() {
            Console.log("抓了条鱼");
        }
    }

    /**
     * 无接口
     *
     * @author looly
     */
    static class Dog {
        public String eat() {
            return "狗吃肉";
        }

        public void seize() {
            Console.log("抓了只鸡");
        }
    }
}
