package com.majm.leetcode;

import com.majm.Solution;

/**
 * 326. 3的幂 </br>
 * https://leetcode-cn.com/problems/power-of-three/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-23 23:53
 * @since
 */
public class LeetCode_0326 implements Solution {

    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
