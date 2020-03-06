package com.huahong.tolerant.basic.deep.design_patterns.template;

/**
 * File：AbstractTemplate <br>
 * Created on 2020/3/1.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public abstract class AbstractTemplate {
    protected int num;

    final void doAll(){
        getRandomNumber();
        printRandomNumber();
    }

    abstract int getRandomNumber();

    String printRandomNumber(){
        return null;
    }
}
