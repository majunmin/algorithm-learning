package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/14 12:47 下午
 * @since
 */
public class LeetCode_0455 implements Solution {

    @Override
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gIdx = 0;
        int sIdx = 0;
        // 分两部
        // 1. 满足 : gIdx++ sIdx++ result++
        // 2. 不满足: sIdx++
        while (sIdx < s.length && gIdx < g.length) {
            if (g[gIdx] <= s[sIdx]) {
                ++gIdx;
                ++result;
            }
            sIdx++;
        }
        return result;
    }


    /**
     * 双指针算法
     *
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
            if (g[gIdx] <= s[sIdx]) {
                result++;
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
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                result++;
                index--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        final LeetCode_0455 leetCode = new LeetCode_0455();
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{1, 2};
        System.out.println(leetCode.findContentChildren(g, s));
    }
}
