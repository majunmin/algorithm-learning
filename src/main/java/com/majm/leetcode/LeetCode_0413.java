package com.majm.leetcode;

import com.majm.Solution;

/**
 * 413. 等差数列划分 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-30 14:31
 * @since
 */
public class LeetCode_0413 implements Solution {


    /**
     * 1 2 3             =>  1
     * 2 4 6 8           =>  3
     * 2 4 6 8 10        =>  6
     * 2 4 6 8 10 12     =>  10
     * 2 4 6 8 10 12 14  =>  15
     * ....
     * 1. res = (L-1)(L-2)  / 2
     * 2. f(l) = f(l-1) + (l - 1)
     *
     * @param nums
     * @return
     */
    @Override
    public int numberOfArithmeticSlices(int[] nums) {
        return solution1(nums);
    }

    /**
     * 动态规划
     * 找到状态转译方程
     * 1 2 3           -> 1
     * 1 2 3 4         -> 1 + 2 = 3
     * 1 2 3 4 5       -> 3 + 3 = 6
     * 1 2 3 4 5 6     -> 6 + 4 = 10
     * 1 2 3 4 5 6 7   -> 10 + 5 =  15
     *
     * @param nums
     * @return
     */
    private int solution2(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        int result = 0;
        //公差
        int d = nums[1] - nums[0];
        int t = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == d) {
                t++;
                result += t;
                continue;
            }
            // reset t = 0
            t = 0;
            d = nums[i] - nums[i - 1];
        }
        return result;
    }


    /**
     * 滑动窗口法
     *
     * @param nums
     * @return
     */
    private int solution1(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int result = 0;
        // 公差 d
        int d = nums[1] - nums[0];
        // init l = 2
        int l = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == d) {
                l++;
                continue;
            }
            d = nums[i] - nums[i - 1];
            // 长度为 l 的 等差数列的可以拆分的个数: (l-1)(l-2)/2
            result += (l - 1) * (l - 2) / 2;
            l = 2;
        }
        result += (l - 1) * (l - 2) / 2;
        return result;
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0413();
        System.out.println(leetCode.numberOfArithmeticSlices(new int[]{1, 3, 5, 7, 9}));
        System.out.println(leetCode.numberOfArithmeticSlices(new int[]{1, 2, 3}));
        System.out.println(leetCode.numberOfArithmeticSlices(new int[]{1, 3, 5, 8, 11}));
    }
}
