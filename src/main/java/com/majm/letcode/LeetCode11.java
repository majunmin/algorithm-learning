package com.majm.letcode;

import com.majm.Solution;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/20 11:31 下午
 * @since
 */
public class LeetCode11 implements Solution {

    @Override
    public int maxArea(int[] height) {

        // solution1 炒鸡笨 (～￣(OO)￣)ブ
        if (height == null || height.length == 1) {
            return 0;
        }

//        int maxArea = 0;
//        int len = height.length;
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int area = (j-i) * Math.min(height[i], height[j]);
//                if (maxArea < area){
//                    maxArea = area;
//                }
//            }
//        }
//
//        return maxArea;

        // solution 2
        // 从两边向中间收敛
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++ ] : height[j--];
            int area = (j - i + 1) * minHeight;
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;

    }
}
