package com.majm.leetcode;


import com.majm.NextGenerateNum;
import com.majm.Solution;
import org.junit.Test;

import java.util.Arrays;


public class LeetCode_0845Test {


    @Test
    public void testLongestMountain() {

        LeetCode_0845 leetcode = new LeetCode_0845();
        System.out.println(leetcode.longestMountain(new int[]{1, 2, 1, 1, 3, 4, 2, 1}));

    }

    @Test
    public void testLongestCommonPrfix() {
        LeetCode_0014 leetcode = new LeetCode_0014();
        System.out.println(leetcode.commonLongestPrefix(new String[]{"flex", "flight", "flap"}));
        System.out.println(leetcode.commonLongestPrefix(new String[]{"flex", "fleght", "f"}));
    }

    @Test
    public void testStack() {
        Solution leetcode = new NextGenerateNum();
        System.out.println(Arrays.toString(leetcode.nextGreaterElement(new int[]{2, 1, 2, 4, 3})));
        System.out.println(Arrays.toString(leetcode.nextGreaterElement(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(leetcode.nextGreaterElement(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(leetcode.nextGreaterElement(new int[]{1, 1, 1})));
    }


    @Test
    public void testTempeature() {
        Solution leetcode = new LeetCode_0739();
        System.out.println(Arrays.toString(leetcode.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }


    @Test
    public void testMiniMoves() {
        //[[0,0,0,0,0,1],[1,1,0,0,1,0],[0,0,0,0,1,1],[0,0,1,0,1,0],[0,1,1,0,0,0],[0,1,1,0,0,0]]
        //[[0,0],[0,0]]
        Solution leetcode = new LeetCode_1210();
        System.out.println(leetcode.minimumMoves(new int[][]{{0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 0, 0}}));
    }
}