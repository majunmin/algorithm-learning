package com.majm.leetcode;

import com.majm.Solution;

/**
 * 152. 乘积最大子数组 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-26 16:54
 * @since
 */
public class LeetCode_0152 implements Solution {


    @Override
    public int maxProduct(int[] nums) {
        return dpSolution3(nums);
    }

    /**
     * 优化空间的写法,  用两个变量 表示 dpMax, dpMin
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    private int dpSolution3(int[] nums) {
        int Fmax = nums[0];
        int Fmin = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int preFmax = Fmax;
            int preFmin = Fmin;
            Fmax = Math.max(preFmax * nums[i], Math.max(preFmin * nums[i], nums[i]));
            Fmin = Math.min(preFmax * nums[i], Math.min(preFmin * nums[i], nums[i]));
            result = Math.max(result, Fmax);
        }
        return result;
    }

    /**
     * 时间复杂度: O(2N)
     * 空间复杂度: O(N)
     *
     * @param nums
     * @return
     */
    private int dpSolution1(int[] nums) {
        // 思路1 遍历 数组, 寻找状态关系, 以当前 idx 结尾的乘积值 dp[i]  = max(dp[i-1] * nums[i], i)
        // 但是这样的思路是不对的, 这个思路忽略了   正负数的 关系
        // 正负数 需要 分情况讨论
        // 分别计算  最大乘积值, 和最下乘积值
        // dpmax[i] = max(dpmax[i-1] * nums[i], dpmin[i-1] * nums[i], nums[i])
        // dpmin[i] = min(dpmax[i-1] * nums[i], dpmin[i-1] * nums[i], nums[i]])
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(dpMin[i - 1] * nums[i], nums[i]));
        }
        int ret = nums[0];
        for (int i = 0; i < dpMax.length; i++) {
            ret = Math.max(ret, dpMax[i]);
        }
        return ret;
    }


    /**
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param nums
     * @return
     */
    private int dpSolution2(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int ret = 0;
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(dpMin[i - 1] * nums[i], nums[i]));
            ret = Math.max(ret, dpMax[i]);
        }
        return ret;
    }

    public static void main(String[] args) {

        final Solution leetCode = new LeetCode_0152();
        System.out.println(leetCode.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(leetCode.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(leetCode.maxProduct(new int[]{4, -2, 3, 2}));
    }
}
