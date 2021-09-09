package com.majm.leetcode;

import com.majm.Solution;

/**
 * 1143. 最长公共子序列 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-09 00:28
 * @since
 */
public class LeetCode_1143 implements Solution {


    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i-1][j]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_1143();
        System.out.println(leetCode.longestCommonSubsequence("abcde", "ace"));
    }

}
