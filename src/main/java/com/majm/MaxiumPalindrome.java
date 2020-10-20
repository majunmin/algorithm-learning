package com.majm;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-01-28 19:54
 * @since
 */
public class MaxiumPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abaabacdecccccc"));
    }

    public static String longestPalindrome(String s) {

        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }

        int start = 0;
        int end = 0;
        for (int i = 1; i < s.length(); i++) {
            int len1 = calLength(s, i, i);
            int len2 = calLength(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int calLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
