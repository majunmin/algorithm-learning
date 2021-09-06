package com.majm.leetcode;

import com.majm.Solution;

/**
 * 516. 最长回文子序列 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-06 17:36
 * @since
 */
public class LeetCode_0516 implements Solution {

    /**
     * @param s
     * @return
     */
    @Override
    public int longestPalindromeSubseq(String s) {
        return dpSolution(s);
    }


    /**
     * 用二维数组定义状态
     * 1. 定义状态
     * dp[i][j] s[i,j]的 最大最长子序列长度
     * dp[i][i] = 1
     * <p>
     * 2. 状态转移方程
     * dp[i][j] = dp[i+1][j-1] + 2
     * dp[i][j] = max(dp[i+1][j], dp[i][j-1])
     * <p>
     * 3. init
     * dp[i][i] = 1
     * <p>
     * 因为 dp[i][j] 与  dp[i+1][j-1], dp[i+1][j], dp[i][j-1] 有关,
     * 所以遍历顺序是 由下至上，由左至右
     *
     * @param s
     * @return
     */
    private int dpSolution(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        //
        return dp[0][len - 1];
    }
}
