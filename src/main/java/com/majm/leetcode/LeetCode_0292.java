package com.majm.leetcode;

import com.majm.Solution;

/**
 * 292. Nim 游戏 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-18 16:45
 * @since
 */
public class LeetCode_0292 implements Solution {

    @Override
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
