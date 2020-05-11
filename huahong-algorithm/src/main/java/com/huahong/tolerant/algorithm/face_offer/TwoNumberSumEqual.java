package com.huahong.tolerant.algorithm.face_offer;

/**
 * File：TwoNumberSumEqual <br>
 * Created on 2020/5/4.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class TwoNumberSumEqual {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        boolean flag = false;
        int i = 0;
        int j = nums.length - 1;
        while (i<j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                flag = true;
                break;
            }else if(sum < target){
                i++;
            }else{
                j--;
            }
        }
        if(flag){
            a[0] = nums[i];
            a[1] = nums[j];
        }
        return a;
    }
}
