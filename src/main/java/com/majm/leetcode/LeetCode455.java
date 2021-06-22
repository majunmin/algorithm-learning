package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/14 12:47 下午
 * @since
 */
public class LeetCode455 implements Solution {

    @Override
    public int findContentChildren(int[] g, int[] s) {
        return solution2(g, s);
    }

    /**
     * 双指针算法
     * @param g
     * @param s
     * @return
     */
    private int solution2(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }

        int gIdx = 0;
        int sIdx = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        while (sIdx < s.length && gIdx < g.length) {
            if (g[gIdx] <= s[sIdx]){
                result ++;
                ++gIdx;
            }
            ++sIdx;
        }
        return result;
    }

    public int solution1(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length - 1; // 饼干数组下标
        int result = 0;
        for (int i = g.length- 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]){
                result ++;
                index--;
            }
        }
        return result;
    }
}
