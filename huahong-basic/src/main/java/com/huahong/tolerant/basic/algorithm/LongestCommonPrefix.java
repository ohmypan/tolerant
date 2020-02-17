package com.huahong.tolerant.basic.algorithm;

/**
 * File：LongestCommonPrefix <br>
 * Created on 2020/2/16.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"aa","aa"};

        System.out.println( "wwww: " + longestCommonPrefix(strs));
    }
    /**
     * 最长公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int min = strs[0].length();
        String minStr = strs[0];
        if(minStr == null || minStr.equals("")){
            return "";
        }
        String cStr = minStr.substring(0,1);
        int checkFlag = 0;

        for(String str:strs){
            if(min > str.length()){
                min = str.length();
                minStr = str;
            }
            if(!str.startsWith(cStr)){
                checkFlag = 1;
                break;
            }
        }
        if(checkFlag == 1){
            return "";
        }
        int stableMin = minStr.length();
        min = 1 ;
        while (min < stableMin && checkFlag != 2){
            min ++;
            if(min > stableMin){
                break;
            }
            String wStr = minStr.substring(0,min);
            System.out.println(wStr);
            for(String str:strs){
                if(!str.startsWith(wStr)) {
                    checkFlag = 2;
                    break;
                }
            }
            if(checkFlag != 2){
                cStr = wStr;
            }
        }
        return cStr;
    }

    public static String other(String[] strs){
        if(strs == null || strs.length == 0) return "";
        String str = strs[0];
        for(String strx:strs){
            while(strx.indexOf(str) != 0){
                str=str.substring(0, str.length() - 1);
            }
        }
        return str;
    }
}
