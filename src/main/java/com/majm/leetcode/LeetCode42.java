package com.majm.leetcode;

import com.majm.Solution;
import netscape.security.UserTarget;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/27 9:05 下午
 * @since
 */
public class LeetCode42 implements Solution {

    @Override
    public int trap(int[] height) {

        int len = height.length;
        if (len < 3) {
            return 0;
        }

        // 暴力求解法
        // 时间复杂度 O(n^2)
        // 空间复杂度 O(1)
//        int maxWater = 0;
//        for (int i = 1; i < len - 1; ++i) {
//            int maxLeft = 0;
//            int maxRight = 0;
//            for (int j = i - 1; j >= 0; j--) {
//                maxLeft = Math.max(height[j], maxLeft);
//            }
//            for (int j = i + 1; j < len; j++) {
//                maxRight = Math.max(height[j], maxRight);
//            }
//            int minHeight = Math.min(maxLeft, maxRight);
//            if (minHeight > height[i]) {
//                maxWater += Math.min(maxLeft, maxRight) - height[i];
//            }
//
//        }
//        return maxWater;


        // 2. 动态规划
        // 时间复杂度 O(n)
        // 空间复杂度 O(n)
        // https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
//        int[] leftMaxArr = new int[len];
//        int[] rightMaxArr = new int[len];
//
//        int maxWater = 0;
//        leftMaxArr[0] = height[0];
//        rightMaxArr[len - 1] = height[len - 1];
//        for (int i = 1; i < len; ++i) {
//            leftMaxArr[i] = Math.max(height[i], leftMaxArr[i - 1]);
//        }
//
//        for (int i = len - 2; i >= 0; --i) {
//            rightMaxArr[i] = Math.max(height[i], rightMaxArr[i + 1]);
//        }
//
//        for (int i = 0; i < len; i++) {
//            maxWater += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
//        }
//        return maxWater;


        // 3. 单调递减栈
        // 时间复杂度 O(n)
        // 空间复杂度 O(n)
//        Deque<Integer> stack = new ArrayDeque<>();
//        int water = 0;
//        int cur = 0;
//        while (cur < height.length){
//            int h = height[cur];
//            while (!stack.isEmpty() && h > height[stack.peek()]){
//                Integer top = stack.pop();
//                if (stack.isEmpty()) {
//                    break;
//                }
//                int hei = Math.min(height[stack.peek()], h) - height[top];
//                water += hei * (cur - 1 - stack.peek());
//            }
//            stack.push(cur++);
//
//        }
//        return water;

        // 双指针法
        // 时间复杂度 O(n)
        // 空间复杂度 O(1)
        int left = 0;
        int right = len -1;
        int water = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right){
            int leftHei = height[left];
            int rightHei = height[right];
            if (leftHei < rightHei) {
                if (leftHei > leftMax){
                    leftMax = leftHei;
                } else {
                    water += leftMax - leftHei;
                }
                left++;
            } else {
                if (rightHei > rightMax){
                    rightMax = rightHei;
                } else {
                    water += rightMax - rightHei;
                }
                right--;
            }
        }
        return water;

    }

}
