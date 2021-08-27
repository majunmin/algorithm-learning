package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 121. 买卖股票的最佳时机 </br>
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-01 14:38
 * @since
 */
public class LeetCode_0121 implements Solution {

    /**
     * 这个问题 解法感觉是就是要
     * 存储 最小价格 和 最大收益
     *
     * @param prices
     * @return
     */
    @Override
    public int maxProfit(int[] prices) {
        // 单调栈解法
        // 单调栈存储最小price, 遍历后面的值(计算最大收益)
        int maxProfit = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(prices[0]);
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - stack.peek());
            if (stack.peek() > prices[i]) {
                stack.pop();
                stack.push(prices[i]);
            }
        }
        return maxProfit;
    }

    /**
     * 单调栈解决
     * (相对麻烦了一些, 也可以解决)
     *
     * @param prices
     * @return
     */
    private int stackSolution(int[] prices) {
        int maxProfit = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(prices[0]);
        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < stack.peek()) {
                stack.pop();
            }
            stack.push(prices[i]);
            if (stack.size() > 1) {
                maxProfit = Math.max(maxProfit, stack.peek() - stack.getLast());
            }
        }
        return maxProfit;
    }

    /**
     * 第i天卖出的最大收益 = max(第i天的价格 - 前几天的最小价格)
     * <p>
     * 复杂度分析:
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param prices
     * @return
     */
    private int dpSolution(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }


    /**
     * 自己写的(第一个思路,后序优化)
     * <p>
     * left 表示之前的最小买入价格
     * right 卖出的价格
     *
     * @param prices
     * @return
     */
    private int solution1(int[] prices) {
        int maxProfit = 0;
        int left = 0;
        int right = 1;
        for (int i = right; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                right = i;
            }
            if (prices[i] < prices[left]) {
                left = i;
            }
            if (left < right) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        final LeetCode_0121 leetCode = new LeetCode_0121();
        System.out.println(leetCode.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(leetCode.maxProfit(new int[]{7, 6, 3, 2, 1}));
    }
}
