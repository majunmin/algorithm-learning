package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;

/**
 * 392. 判断子序列 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-08 23:24
 * @since
 */
public class LeetCode_0392 implements Solution {

    @Override
    public boolean isSubsequence(String s, String t) {
        return dpSolution2(s, t);
    }


    /**
     * 动态规划
     * https://leetcode-cn.com/problems/is-subsequence/solution/pan-duan-zi-xu-lie-by-leetcode-solution/
     * (进阶)
     * 1. 定义状态
     * 2. 状态转移
     *
     * @param s
     * @param t
     * @return
     */
    private boolean dpSolution2(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        int[][] f = new int[tl + 1][26];
        // init f[i][j] (预处理数组): 记录每一个字母在 t[i]之后出现的位置
        Arrays.fill(f[tl], tl);
        for (int i = tl - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == 'a' + j) {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }

        int step = 0;
        for (int i = 0; i < sl; i++) {
            // 说明 没有找到匹配的
            if (f[step][s.charAt(i) - 'a'] == tl) {
                return false;
            }
            step = f[step][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    /**
     * 二维表 动态规划解法
     *
     * @param s
     * @param t
     * @return
     */
    private boolean dpSolution1(String s, String t) {
        // 1. 定义状态
        // dp[i][j] : 表示以 s 以  i-1 为结尾的 和 t 以 j-1 为结尾的最长子序列的长度
        //
        // 2. 状态转移
        // dp[i][j] = dp[i-1][j-1] + 1  if s[i] == t[j]
        // dp[i][j] = dp[i][j-1]        if s[i] != t[j]
        final int sLen = s.length();
        final int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[sLen][tLen] == sLen;
    }


    /**
     * 双指针解法
     *
     * @param s
     * @param t
     * @return
     */
    private boolean solution1(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0392();
        System.out.println(leetCode.isSubsequence("abc", "ahgbdc"));
    }
}
