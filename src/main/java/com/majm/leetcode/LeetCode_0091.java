package com.majm.leetcode;

import com.majm.Solution;

/**
 * 91. 解码方法 </br>
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * <p>
 * -------------
 * 根据一个字符串结尾的两个字符,推导状态转译方程(不同规模子问题)
 * - 这一类问题,问方案数,但不问具体方案的,可以用考虑用<动态规划/>完成
 * - <动态规划/> 处理字符串的思想是: 从一个空串开始,一点一点得到大规模问题的解
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-30 19:08
 * @since
 */
public class LeetCode_0091 implements Solution {


    @Override
    public int numDecodings(String s) {
        return solution2(s);
    }

    /**
     * https://leetcode-cn.com/problems/decode-ways/solution/mmplao-niang-zhong-yu-xie-chu-lai-liao-by-vegetabl/
     * 这是我根据自己的想法写的
     * 原始解法,可以优化代码为 soluton2
     */
    private int solution1(String s) {
        final char[] sArr = s.toCharArray();
        if (sArr[0] == '0') {
            return 0;
        }
        int len = sArr.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int num = 10 * (sArr[i - 1] - '0') + (sArr[i] - '0');
            if (sArr[i] == '0') {
                if (num == 10 || num == 20) {
                    if (i == 1) {
                        dp[i] = 1;
                    } else {
                        dp[i] = dp[i - 2];
                    }
                }
            } else if (11 <= num && num <= 26) {
                if (i == 1) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else {
                if (i == 1) {
                    dp[i] = 1;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[len - 1];
    }

    /**
     * https://leetcode-cn.com/problems/decode-ways/solution/mmplao-niang-zhong-yu-xie-chu-lai-liao-by-vegetabl/
     * <p>
     * 1. 定义状态
     * dp[i]: 以s[i] 结尾的前缀子串有多少种解法
     * <p>
     * 2. 状态转移:
     * dp[-1] = 1 (default)
     * dp[i] = dp[i-1]     if s[i] != 0
     * dp[i] += dp[i-2]    if 10 <= int(s[i-1,i]) <= 26 ()
     * <p>
     * s[i-2, i-1,i]
     * dp[i] == dp[i-1]  + dp[i-2] (if 11 <=  s[i-1,1] <= 26 (不包含20))
     * dp[i] == 0        + dp[i-2]      (if s[i] == 0)
     * <p>
     * -----
     *
     * @param s
     * @return
     */
    private int solution2(String s) {
        char[] sArr = s.toCharArray();
        // 以 0 开头的 字符串无解
        if (sArr[0] == '0') {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (sArr[i] != '0') {
                dp[i] = dp[i - 1];
            }
            int num = 10 * (sArr[i - 1] - '0') + sArr[i] - '0';
            if (10 <= num && num <= 26) {
                //边界条件
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }
}
