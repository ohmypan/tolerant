package com.huahong.tolerant.algorithm.face_offer;

/**
 * File：LeftRotateString <br>
 * Created on 2020/5/7.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class LeftRotateString {

    public static void main(String[] args) {
        reverseLeftWords("qwerty",3);
    }

    public static String reverseLeftWords(String s, int n) {
        if(s.length() < n){
            return "";
        } else if(s.length() == n){
            return s;
        }
        StringBuilder str = new StringBuilder();
        s = s.substring(0,n);
        return str.append(s.substring(n)).append(s).toString();
    }
}
