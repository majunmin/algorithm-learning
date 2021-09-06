package com.majm.leetcode;

import com.majm.Solution;

/**
 * 5. 最长回文子串 </br>
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-14 00:35
 * @since
 */
public class LeetCode_0005 implements Solution {

    @Override
    public String longestPalindrome(String s) {
        return dpSolution(s);
    }

    private String dpSolution(String s) {
        // - 状态
        //     dp[i][j] : 以 s[i:j] 是否是一个回文子串
        // -  转移方程
        //     dp[i][j] = (s[i] == s[j]) and dp[i+1][j-1]
        //  init
        //     d[i][i] = true
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // flag，目的是为了减少 substring 的次数
        int maxLen = 0;
        int start = 0;
        // 从 列处 向右填写, j(col) > i(row)
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if ((j - 1) - (i + 1) + 1 < 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(start, maxLen);
    }

    private String solution2(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        // flag
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = calLen(s, i, i);
            int len2 = calLen(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end);
    }

    private int calLen(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    private String solution1(String s) {
        char[] array = s.toCharArray();
        String result = "";
        for (int i = 0; i < array.length; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < array.length) {
                if (array[left] != array[right]) {
                    break;
                }

                if (right - left + 1 > result.length()) {
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < result.length()) {
                if (array[left] != array[right]) {
                    break;
                }
                if (right - left + 1 > result.length()) {
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return result;
    }
}
