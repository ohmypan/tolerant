package com.huahong.tolerant.algorithm.face_offer;

/**
 * File：MaxSlidingWindow <br>
 * Created on 2020/5/7.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{1,2,4,2,6,6,8},3));
    }


    /**
     * 最垃圾解法  时间复杂度击败10%的人  lowB
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] all = new int[nums.length - k + 1];
        for(int i = 0;i<nums.length - k + 1;i++){
            int[] old = new int[k];
            int j = 0;
            int max = - Integer.MAX_VALUE;
            while (j<k){
                old[j] = nums[i+j];
                if(old[j] > max){
                    max = old[j];
                }
                j++;
            }
            all[i] = max;
            System.out.println(max);
        }
        return all;
    }
}
