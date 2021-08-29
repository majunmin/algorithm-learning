package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/27 9:05 下午
 * @since
 */
public class LeetCode_0042 implements Solution {

    @Override
    public int trap(int[] height) {

        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[i], height[left]) - height[bottom];
                result += curWidth * curHeight;
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * 双指针解法  也是优化 动态规划解法的空间复杂度
     * <p>
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param height
     * @return
     */
    private int leftRightSolution(int[] height) {
        int len = height.length;
        // 标记一下左右两边的柱子高度(计算你盛水)
        int leftMax = height[0];
        int rightMax = height[len - 1];
        int left = 0;
        int right = len - 1;
        int result = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] <= height[right]) {
                result += leftMax - height[left++];
            }
            if (height[right] < height[left]) {
                result += rightMax - height[right--];
            }
        }
        return result;
    }


    /**
     * 单调栈解法
     * 画图 看题解  😄
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param height
     * @return
     */
    private int stackSolution(int[] height) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int curWidth = i - 1 - left;
                int curHeight = Math.min(height[left], height[i]) - height[top];
                result += curWidth * curHeight;
            }
            stack.push(i);
        }
        return result;

    }

    /**
     * 动态规划:
     * i 位置可以存水量 = min(leftMax  rightMax)  - height[i]
     * <p>
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     */
    private int dpSolution(int[] height) {
        final int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        int max = height[0];
        for (int i = 0; i < len; i++) {
            maxLeft[i] = Math.max(max, height[i]);
            max = maxLeft[i];
        }
        max = height[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            maxRight[i] = Math.max(max, height[i]);
            max = maxRight[i];
        }

        int result = 0;
        for (int i = 1; i < len - 1; i++) {
            result += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return result;
    }


    private int solution1(int[] height) {
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
        int right = len - 1;
        int water = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            int leftHei = height[left];
            int rightHei = height[right];
            if (leftHei < rightHei) {
                if (leftHei > leftMax) {
                    leftMax = leftHei;
                } else {
                    water += leftMax - leftHei;
                }
                left++;
            } else {
                if (rightHei > rightMax) {
                    rightMax = rightHei;
                } else {
                    water += rightMax - rightHei;
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        final LeetCode_0042 leetCode = new LeetCode_0042();
        System.out.println(leetCode.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(leetCode.trap(new int[]{0, 1, 0}));
        System.out.println(leetCode.trap(new int[]{4, 2, 3}));
        System.out.println(leetCode.trap(new int[]{1, 3}));
    }

}
