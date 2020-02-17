package com.huahong.tolerant.algorithm.double_pointer;

/**
 * File：ValidPalindromeII <br>
 * Created on 2020/2/17.
 * Title:  <br>
 * Description: 可以删除一个字符，判断是否能构成回文字符串 <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class ValidPalindromeII {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }

    public static boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
