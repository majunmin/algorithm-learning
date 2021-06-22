package com.majm.leetcode;

import com.majm.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/31 2:13 下午
 * @since
 */
public class LeetCode347 implements Solution {


    @Override
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        if (len == 1){
            return nums;
        }
        // key: frequency  value: set<num>
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getKey();
        }

        return result;
    }
}
