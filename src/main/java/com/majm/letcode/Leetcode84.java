package com.majm.letcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/26 8:47 下午
 * @since
 */
public class Leetcode84 implements Solution {

    @Override
    public int largestRectangleArea(int[] heights) {
        // 1. 暴力求解法 通过固定高度，枚举宽度
//        if (heights.length <= 0){
//            return 0;
//        }
//
//        int maxArea = 0;
//        int len = heights.length;
//        int left, right;
//        for (int i = 0; i < len; i++) {
//            left = i;
//            right = i;
//            int height = heights[i];
//            while(left >= 1 && heights[left-1] >= height){
//                left--;
//            }
//            while(right <= len-2 && heights[right + 1] >= height){
//                right++;
//            }
//            maxArea = Math.max((right - left + 1)*height, maxArea);
//        }
//        return maxArea;


        // 2. 利用栈的操作
//        if (heights.length <= 0) {
//            return 0;
//        }
//        if (heights.length == 1) {
//            return heights[0];
//        }
//        Deque<Integer> stack = new ArrayDeque<>();
//        int maxArea = 0;
//        int len = heights.length;
//
//        for (int i = 0; i < len; i++) {
//            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
//                int height = heights[stack.pop()];
//                while (!stack.isEmpty() && heights[stack.peek()] == height) {
//                    stack.pop();
//                }
//                int width;
//                if (stack.isEmpty()) {
//                    width = i;
//                } else {
//                    width = i - stack.peek() - 1;
//                }
//                maxArea = Math.max(maxArea, width * height);
//            }
//            stack.push(i);
//        }
//
//        while (!stack.isEmpty()) {
//            int height = heights[stack.pop()];
//            while (!stack.isEmpty() && heights[stack.peek()] == height) {
//                stack.pop();
//            }
//            int width;
//            if (stack.isEmpty()) {
//                width = len;
//            } else {
//                width = len - stack.peek() - 1;
//            }
//            maxArea = Math.max(maxArea, width * height);
//        }
//
//        return maxArea;

        // 3. 2的代码优化，通过增加哨兵节点 头尾节点)
        if (heights.length <= 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int len = heights.length;
        int[] newHeight = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeight[i+1] = heights[i];
        }
        heights = newHeight;
        len = len+2;
        stack.push(0);
        for (int i = 1; i < len; i++) {
            while (heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
