package com.huahong.tolerant.algorithm.double_pointer;

/**
 * File：SumOfSquareNumbers <br>
 * Created on 2020/2/17.
 * Title:  <br>
 * Description: 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。<br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class SumOfSquareNumbers {

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2));
    }

    public static boolean judgeSquareSum(int target){
        int i = 0;
        int j = (int) Math.sqrt(target);
        while (i<j){
            int sum = i*i + j*j;
            if(target == sum){
                System.out.println(i);
                System.out.println(j);
                return true;
            }else if(target < sum){
                j--;
            }else{
                i++;
            }

        }
        return false;
    }
}
