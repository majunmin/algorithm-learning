package com.majm.offer;

/**
 * 剑指 Offer 63. 股票的最大利润 </br>
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-21 00:15
 * @since
 */
public class Offer63 {

    /**
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

}
