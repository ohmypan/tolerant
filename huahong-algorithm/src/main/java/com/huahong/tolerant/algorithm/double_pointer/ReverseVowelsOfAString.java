package com.huahong.tolerant.algorithm.double_pointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * File：ReverseVowelsOfAString <br>
 * Created on 2020/2/17.
 * Title:  <br>
 * Description:  反转字符串中的元音字符 元音包括（'a', 'e', 'i', 'o', 'u'）<br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class ReverseVowelsOfAString {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static void main(String[] args) {
        System.out.println(getYy("leetcode"));
    }

    public static String getYy(String s){
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}
