package com.majm.offer;

/**
 * 剑指 Offer 46. 把数字翻译成字符串 </br>
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-22 23:56
 * @since
 */
public class Offer46 {

    public int translateNum(int num) {
        return dpSolution3(num);
    }

    private int dpSolution3(int num) {
        return 0;
    }

    /**
     * 这里有一点需要理解
     * dfsSolution
     *
     * @param num
     * @return
     */
    private int dfs(int num) {
        if (num < 10) {
            return 1;
        }
        if (num % 100 <= 25 && num % 100 >= 10) {
            return dfs(num / 100) + dfs(num / 10);
        } else {
            return dfs(num / 10);
        }
    }

    /**
     * 优化空间的写法
     *
     * @param num
     * @return
     */
    private int dpSolution2(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int p = 1;
        int q = 1;
        int result = 0;
        for (int i = 1; i < len; i++) {
            result = (s.substring(i - 1, i + 1).compareTo("10") >= 0
                    && s.substring(i - 1, i + 1).compareTo("25") <= 0) ? (p + q) : q;
            p = q;
            q = result;
        }
        return result;
    }


    private int dpSolution(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < len; i++) {
            String curStr = s.substring(i - 2, i);
            if (curStr.compareTo("10") >= 0 && curStr.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }
}
