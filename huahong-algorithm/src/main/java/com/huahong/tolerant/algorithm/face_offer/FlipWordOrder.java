package com.huahong.tolerant.algorithm.face_offer;

/**
 * File：FlipWordOrder <br>
 * Created on 2020/5/7.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class FlipWordOrder {
    public static void main(String[] args) {
        System.out.println(reverseWords("  12   34 "));
    }

    /**
     * 还有更优秀解法
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        s = s.trim().replaceAll(" ",",");
        System.out.println(s);
        String[] strs = s.split(",");
        StringBuilder sb = new StringBuilder();
        if(strs.length > 0){
            for(int i= strs.length -1;i>=0;i--){
                if(strs[i].toCharArray().length > 0){
                    System.out.println(strs[i]);
                    sb.append(strs[i]).append(" ");
                }
            }
        }
        return sb.toString().trim();
    }
}
