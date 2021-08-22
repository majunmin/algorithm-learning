package com.majm.leetcode;

import com.majm.Solution;

/**
 * 789. 逃脱阻碍者 </br>
 * https://leetcode-cn.com/problems/escape-the-ghosts/
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-22 14:32
 * @since
 */
public class LeetCode_0789 implements Solution {


    /**
     * 曼哈顿距离
     *
     * @param ghosts
     * @param target
     * @return
     */
    @Override
    public boolean escapeGhosts(int[][] ghosts, int[] target) {

        int[] source = new int[]{0, 0};
        int distance = manhatanDistance(source, target);

        for (int[] ghost : ghosts) {
            if (manhatanDistance(ghost, target) <= distance) {
                return false;
            }
        }

        return true;
    }

    private int manhatanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
