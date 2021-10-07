package com.majm.leetcode;

import com.majm.Solution;

/**
 * 189. 旋转数组 </br>
 * https://leetcode-cn.com/problems/rotate-array/
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-24 00:50
 * @since
 */
public class LeetCode_0189 implements Solution {

    @Override
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int x = gcd(n, k);

        for (int i = 0; i < x; i++) {
            int current = i;
            int prev = nums[i];
            do {
                current = (current + k) % n;
                int curVal = nums[current];
                nums[current] = prev;
                prev = curVal;
            } while ((current % n) != i);
        }
    }

    /**
     * 最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {
        final LeetCode_0189 leetCode = new LeetCode_0189();
        int[] nums =  new int[]{1,2,3,4,5,6};
        leetCode.rotate(nums, 3);
        System.out.println(nums);
    }
}
