package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-25 15:04
 * @since
 */
public class LeetCode_0740 implements Solution {

    /**
     * 类似打家劫舍,不能选择相邻的两个数
     * 1. 种解决思路是 转化为 数组, 点数即为数组下标
     * 2. 如果  是  [1, 10000], 这种就浪费空间, 所以我想到了  用 hash 表 存储点数(合并相同点数的)对应的权重
     * 将点数 排序后放进数组, 相邻关系用  nums[i] - nums[i-1] == 1 表示
     *
     * @param nums
     * @return
     */
    @Override
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        List<Integer> segment = new ArrayList<>();
        segment.add(nums[0]);
        int ret = 0;
        int size = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                segment.set(size - 1, segment.get(size - 1) + nums[i]);
            } else if (nums[i] - nums[i - 1] == 1) {
                segment.add(nums[i]);
                size++;
            } else {
                ret += rob_local(segment);
                segment.clear();
                segment.add(nums[i]);
                size = 1;
            }
        }
        ret += rob_local(segment);
        segment.clear();
        size = 0;
        return ret;
    }

    private int rob_local(List<Integer> points) {
        if (points.size() == 1) {
            return points.get(0);
        }

        int first = 0;
        int second = points.get(0);
        int ret = second;
        for (int i = 2; i <= points.size(); i++) {
            ret = Math.max(second, first + points.get(i - 1));
            first = second;
            second = ret;
        }
        return ret;
    }


    /**
     * 分段连续数组 求和
     *
     * @param nums
     * @return
     */
    private int solution3(int[] nums) {
        Arrays.sort(nums);
        List<Integer> segment = new ArrayList<>();
        int result = 0;
        segment.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                segment.set(segment.size() - 1, nums[i] + segment.get(segment.size() - 1));
            } else if (nums[i] - nums[i - 1] == 1) {
                segment.add(nums[i]);
            } else {
                result += robLocal(segment);
                segment.clear();
                segment.add(nums[i]);
            }
        }
        result += robLocal(segment);
        return result;
    }

    private int robLocal(List<Integer> segment) {
        if (segment.size() == 1) {
            return segment.get(0);
        }
        int p = segment.get(0);
        int q = Math.max(p, segment.get(1));
        int temp = q;
        for (int i = 2; i < segment.size(); i++) {
            temp = Math.max(p + segment.get(i), q);
            p = q;
            q = temp;
        }
        return temp;
    }


    /**
     * 转化为 打家劫舍问题
     * 用数组下标表示 点数, 相邻的点数也就是数组中相邻的两个数
     *
     * @param nums
     * @return
     */
    private int solution2(int[] nums) {
        int maxVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
            }
        }
        int[] tnums = new int[maxVal + 1];
        for (int i = 0; i < nums.length; i++) {
            tnums[nums[i]] += nums[i];
        }

        return robLocal(tnums);
    }

    /**
     * 转化为 打家劫舍问题
     *
     * @param nums
     * @return
     */
    private int robLocal(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        // dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }


    /**
     * hash + 动态规划
     *
     * @param nums
     * @return
     */
    private int solution(int[] nums) {
        Map<Integer, Integer> weight = new HashMap<>();
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            if (!weight.containsKey(num)) {
                nums[cnt++] = num;
            }
            weight.compute(num, (key, val) -> Objects.isNull(val) ? num : val + num);
        }

        if (weight.size() == 1) {
            return weight.get(nums[0]);
        }

        int[] dp = new int[cnt];
        dp[0] = weight.get(nums[0]);

//        if (nums[1] - nums[0] == 1){
//            dp[1] = nums[1];
//        } else {
//            dp[1] = dp[0] + nums[1];
//        }
        int tmp = nums[1] - nums[0] == 1 ? weight.get(nums[1]) : dp[0] + weight.get(nums[1]);
        dp[1] = Math.max(dp[0], tmp);
        for (int i = 2; i < cnt; i++) {
            tmp = nums[i] - nums[i - 1] == 1 ? dp[i - 2] + weight.get(nums[i]) : dp[i - 1] + weight.get(nums[i]);
            dp[i] = Math.max(dp[i - 1], tmp);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        final LeetCode_0740 leetCode = new LeetCode_0740();
//        System.out.println(leetCode.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
//        System.out.println(leetCode.deleteAndEarn(new int[]{3, 4, 2}));
//        System.out.println(leetCode.deleteAndEarn(new int[]{3}));
//        System.out.println(leetCode.deleteAndEarn(new int[]{3, 1}));
        System.out.println(leetCode.deleteAndEarn(new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6}));
        System.out.println(leetCode.deleteAndEarn(new int[]{3, 3, 3, 4, 2}));
    }
}
