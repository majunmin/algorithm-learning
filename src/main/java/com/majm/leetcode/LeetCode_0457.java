package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 环形数组是否存在循环 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-07 08:08
 * @since
 */
public class LeetCode_0457 implements Solution {


    /**
     * nextIdx = (idx + nums[idx]) % nums.length;
     * 1. 循环数组长度  > 1
     * 2. 循环数组   元素 要么全正 要么全负
     * <p>
     * -- 检测链表是否存在环,一般使用快慢指针
     *
     * @param nums
     * @return
     */
    @Override
    public boolean circularArrayLoop(int[] nums) {
        /**
         * 判断是否存在环  快慢指针
         *  将已访问过得 路径  标记为 0
         */
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int slow = i;
            int fast = next(i, nums);
            // 循环  方向相同 && 不为 0()
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(fast, nums)] > 0) {
                // 发现环
                if (slow == fast) {
                    // 判断是否是合法的环
                    if (slow != next(slow, nums)) {
                        return true;
                    }
                    break;
                }
                slow = next(slow, nums);
                fast = next(next(fast, nums), nums);
            }
            // 标记已经访问过得节点
            while (nums[slow] != 0) {
                nums[slow] = 0;
                slow = next(slow, nums);
            }
        }

        return false;
    }

    private int next(int idx, int[] nums) {
        int len = nums.length;
//        idx = (idx + nums[idx]) % nums.length;
//        return idx >= 0 ? idx : idx + nums.length;
         return ((idx + nums[idx]) % len + len) % len;
    }

    /**
     * @param nums
     * @return
     */
    private boolean solution1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (existCircular(i, nums)) {
                return true;
            }
        }
        return false;
    }


    /**
     * X
     * nums从下标索引 0 开始是否是一个循环数组
     *
     * @param nums
     * @return
     */
    private boolean existCircular(int idx, int[] nums) {
        // 存放已访问过的索引下标
        List<Integer> visited = new ArrayList<>();

        while (!visited.contains(idx)) {
            visited.add(idx);
            idx = (idx + nums[idx]) % nums.length;
            idx = idx >= 0 ? idx : idx + nums.length;
        }
        int num = nums[idx];
        int cnt = 0;
        for (int i = visited.size() - 1; i < visited.size(); i--) {
            int tmpIdx = visited.get(i);
            if (num * nums[tmpIdx] < 0) {
                return false;
            }
            cnt++;
            if (tmpIdx == idx) {
                break;
            }
        }
        return cnt > 1;
    }

    public static void main(String[] args) {
        final Solution leetCode = new LeetCode_0457();
        System.out.println(leetCode.circularArrayLoop(new int[]{3, 1, 2}));
        System.out.println(leetCode.circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
        System.out.println(leetCode.circularArrayLoop(new int[]{-1, 2}));
    }
}
