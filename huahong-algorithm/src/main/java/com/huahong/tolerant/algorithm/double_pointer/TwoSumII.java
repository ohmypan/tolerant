package com.huahong.tolerant.algorithm.double_pointer;

/**
 * File：TwoSumII <br>
 * Created on 2020/2/17.
 * Title:  <br>
 * Description: 有序数组的 TWO SUM:Two Sum II - Input array is sorted (Easy) <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class TwoSumII {

    public static void main(String[] args) {
        int[] rest = {2, 7, 11, 15};
        System.out.println(selfTwoSum(rest,18));
    }

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * @param numbers
     * @param target
     * @return
     */
    public static int[] selfTwoSum(int[] numbers, int target) {
        int[] rest = new int[2];
        if(numbers == null) return rest;
        int indexMin = 0;
        int indexMax = numbers.length - 1;
        int sum;
        while (indexMin<indexMax){
            sum = numbers[indexMin] + numbers[indexMax];
            if(sum > target){
                indexMax --;
            }else if(sum == target){
                rest[0] = indexMin + 1;
                rest[1] = indexMax + 1;
                return rest;
            }else{
                indexMin++;
            }
        }
        return null;
    }
}
