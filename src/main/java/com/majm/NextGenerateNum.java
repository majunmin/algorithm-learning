package com.majm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://labuladong.gitbook.io/algo-en/v/master/shu-ju-jie-gou-xi-lie/shou-ba-shou-she-ji-shu-ju-jie-gou/dan-tiao-zhan </br>
 * <p>
 * <br/>
 * 给你一个数组，返回一个等长的数组，对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1。
 * 输入一个数组 nums = [2,1,2,4,3]，你返回数组 [4,2,4,-1,-1]。
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-18 08:28
 * @since
 */
public class NextGenerateNum implements Solution {
    //    vector<int> nextGreaterElement(vector<int>& nums);
    @Override
    public int[] nextGreaterElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        if (arr.length == 1) {
            return new int[]{-1};
        }


        int[] result = new int[arr.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);

        }
        return result;
    }

}
