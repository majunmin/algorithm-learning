package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/14 2:56 下午
 * @since
 */
public class LeetCode_0055 implements Solution {


    @Override
    public boolean canJump(int[] nums) {
        final int len = nums.length;
        boolean[] visited = new boolean[len];
        //存储索引下标
        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer idx = queue.pop();
            if (idx >= len - 1) {
                return true;
            }
            visited[idx] = true;
            for (int i = idx + 1; i <= idx + nums[idx]; i++) {
                if (!visited[i]) {
                    queue.add(i);
                }
            }
        }
        return visited[len - 1];
    }


    private boolean bfsSolution(int[] nums) {
        // BFS
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            final Integer curIdx = queue.poll();
            visited.add(curIdx);
            if (curIdx >= nums.length - 1) {
                return true;
            }
            for (int i = curIdx + 1; i <= curIdx + nums[curIdx]; i++) {
                if (!visited.contains(i)) {
                    queue.add(i);
                }
            }
        }
        return false;
    }


    /**
     * 贪心算法比较简单(算法比较巧妙，比较不容易想到)
     * <p>
     * 时间复杂度 O(N)
     * 空间复杂度 O(1
     *
     * @param nums
     * @return
     */
    public boolean solution1(int[] nums) {
        int len = nums.length;
        int canReachable = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] + i >= canReachable) {
                canReachable = i;
            }
        }
        return canReachable == 0;
    }

    public static void main(String[] args) {
        final Solution leetCode = new LeetCode_0055();
        System.out.println(leetCode.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(leetCode.canJump(new int[]{1, 2, 2, 6, 3, 6, 1, 8, 9, 4, 7, 6, 5, 6, 8, 2, 6, 1, 3, 6, 6, 6, 3, 2, 4, 9, 4, 5, 9, 8, 2, 2, 1, 6, 1, 6, 2, 2, 6, 1, 8, 6, 8, 3, 2, 8, 5, 8, 0, 1, 4, 8, 7, 9, 0, 3, 9, 4, 8, 0, 2, 2, 5, 5, 8, 6, 3, 1, 0, 2, 4, 9, 8, 4, 4, 2, 3, 2, 2, 5, 5, 9, 3, 2, 8, 5, 8, 9, 1, 6, 2, 5, 9, 9, 3, 9, 7, 6, 0, 7, 8, 7, 8, 8, 3, 5, 0}));
    }
}
