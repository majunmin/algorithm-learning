package com.majm.leetcode;

import com.majm.Solution;

import java.util.Random;

/**
 * 470. 用 Rand7() 实现 Rand10() </br>
 * https://leetcode-cn.com/problems/implement-rand10-using-rand7/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-05 11:39
 * @since
 */
public class LeetCode_0470 implements Solution {

    // 拒绝采样法
    public int rand10() {
        return soluiton3();
    }

    /**
     * // (randx - 1) * y + randy == randxy
     * // (rand7 -1) * 5 + rand5 == rand35
     * 优化  减少  rand7() 的次数
     *
     * @return
     */
    private int soluiton3() {
        while (true) {
            int row = rand7();
            int col = rand7();
            int num = (row - 1) * 7 + col; // 随机数  [1-49]
            if (num <= 40) {
                return num % 10 + 1;
            }
            row = num - 40;  // [1-9]
            col = rand7(); //  [1-7]
            num = (row - 1) * 7 + col;
            if (num <= 60) {
                return num % 10 + 1;
            }

            row = num - 60; // [1-3]
            col = rand7();
            num = (row - 1) * 7 + col; // [1-21]
            if (num <= 20) {
                return num % 10 + 1;
            }
        }
    }

    private int soluiton2() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7(); // 等概率生成  [1-49] 范围内的随机数
            if (num <= 40) { // 拒绝采样, 并返回 [1-10] 内的随机数
                return num % 10 + 1;
            }
        }
    }

    private int solution1() {
        int num = 0;
        do {
            int row = rand7();
            int col = rand7();
            num = (row - 1) * 7 + col;
        } while (num > 40);

        return 1 + ((num - 1) % 10);
    }

    private int rand7() {
        return new Random().nextInt(7) + 1;
    }

}
