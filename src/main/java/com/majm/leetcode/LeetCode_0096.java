package com.majm.leetcode;

import com.majm.Solution;

/**
 * 96. 不同的二叉搜索树 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-31 21:33
 * @since
 */
public class LeetCode_0096 implements Solution {


    @Override
    public int numTrees(int n) {
        return solution2(n);
    }

    /**
     * - 了解
     * 数学的方式
     * 通过解法一的 推导,可以得出这是一个卡塔兰数()
     * <p>
     * C(0) = 1
     * <p>
     * C(n+1)  = 2(2n+1)*C(n)/(n+2)
     *
     * @param n
     * @return
     */
    private int solution2(int n) {
        long C = 1L;
        for (int i = 0; i < n; i++) {
            C = 2 * (2 * i + 1) * C / (i + 2);
        }
        return (int) C;
    }

    /**
     * 一个节点的二叉树的 二叉搜索树个数为 1
     * 两个节点的二叉树的 二叉搜索树个数为 2
     * 计算 n  个节点的二叉搜索树个数, 可以通过 拆分 二叉树的形式
     * 那个 节点的二叉树:
     * 1 ....i, i+1,...n
     * <p>
     * 分解为子问题:
     * 二叉搜索树的种数 = (1,i-1 的种数) * (i+1,n 的二叉搜索树种数)
     * <p>
     * - 找到子问题 (二叉树的分解)
     * - 定义状态
     * g[n] 长度为 的 节点数的二叉搜索树的种数
     * f(n,i) 长度为n 的 并且 以 i 为顶点的 二叉搜索树的种数
     * - 状态转移
     * g[n] = f[1] + f[2]....+f[n]
     * = g[0]*g[n-1] + g[1]*g[n-2]+...+g[n-1]*g[0]
     *
     * @param n
     * @return
     */
    private int solution1(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            int res = 0;
            for (int j = 1; j <= i; j++) {
                res += dp[j - 1] * dp[i - j];
            }
            dp[i] = res;
        }
        return dp[n - 1];
    }
}
