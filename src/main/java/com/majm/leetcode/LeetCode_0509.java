package com.majm.leetcode;

import com.majm.Solution;

/**
 * 509. 斐波那契数 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-22 00:14
 * @since
 */
public class LeetCode_0509 implements Solution {


    @Override
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        // dp[n] = dp[n-1] + dp[n-2]
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 对解法2的优化,仅记忆之前的 两个状态 (状态压缩)
     * dp的解法,优化空间(一维)
     *
     * @param n
     * @return
     */
    private int dpSolution3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int p = 0;
        int q = 1;
        int ret = q;
        for (int i = 2; i <= n; i++) {
            ret = p + q;
            p = q;
            q = ret;
        }
        return ret;
    }


    /**
     * 动态规划,记忆化搜索, 通用做法是用一个 map 做记忆化,这里用一个数组
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * <p>
     * (空间复杂度可以进一步优化为O(1))
     * 用两个变量替代 数组的记忆
     *
     * @param n
     * @return
     */
    private int dpSolution2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        // dp[n] = dp[n-1] + dp[n-2];
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * 递归解法,时间复杂度可以优化
     * 时间复杂度 O(N)
     * 空间复杂度 O(N): 递归的深度
     *
     * @param n
     * @return
     */
    private int recurSolution1(int n) {
        // terminate
        if (n == 1 || n == 0) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0509();
        System.out.println(leetCode.fib(1));
        System.out.println(leetCode.fib(3));
        System.out.println(leetCode.fib(5));
    }
}
