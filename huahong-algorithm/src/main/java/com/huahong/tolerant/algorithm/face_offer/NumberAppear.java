package com.huahong.tolerant.algorithm.face_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * File：NumberAppear <br>
 * Created on 2020/5/4.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class NumberAppear {
    public static void main(String[] args) {
        singleNumber(new int[]{3,4,3,3});
    }

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     *
     *  注意 只出现一次
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>(16);
        for(int i = 0;i<nums.length;i++){
           Integer j =  map.getOrDefault(nums[i],0);
           if(j > 1){
               continue;
           }
           map.put(nums[i],++j);
        }
        for(Map.Entry<Integer,Integer> t :map.entrySet()){
            if(t.getValue() == 1){
                return t.getKey();
            }
        }
        return -1;
    }
}
