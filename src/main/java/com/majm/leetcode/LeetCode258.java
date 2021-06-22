package com.majm.leetcode;

import com.majm.Solution;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/30 11:47 下午
 * @since
 */
public class LeetCode258 implements Solution {

    @Override
    public int addDigits(int num) {
        return solution2(num);
    }

    /**
     * 递归
     * @param num
     * @return
     */
    private int solution2(int num) {
        if (num < 10){
            return num;
        }
        int sum = 0;
        while (num > 0) {
            num = num /10;
            sum += num % 10;
        }
        return solution2(sum);
    }


    /**
     * 1. 暴力循环
     * 时间复杂度: O()
     * 空间复杂度: O(1)
     * @param num
     * @return
     */
    private int solution1(int num) {
        while(num >= 10){
            int sum = 0;
            while (num > 0){
                int digit = num % 10;
                num = num /10;
                sum += digit;
            }
            num = sum;
        }
        return num;
    }
}
