package com.majm.leetcode;

import com.majm.Solution;

/**
 * 1014. 最佳观光组合 </br>
 * <p>
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * https://leetcode-cn.com/problems/best-sightseeing-pair/
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-01 14:05
 * @since
 */
public class LeetCode_1014 implements Solution {


    public int maxScoreSightseeingPair(int[] values) {
        int mx = values[0] + 0;
        int result = Integer.MIN_VALUE;
        // i 和 j两个景点的 分数 = values[i] + values[j] + i - j (i < j)
        // 对于当前位置j 前面能贡献最大的 values[i] + i
        for (int j = 1; j < values.length; j++) {
            result = Math.max(result, mx + values[j] - j);
            mx = Math.max(mx, values[j] + j);
        }
        return result;
    }

    /**
     * 这里优化  暴力解法
     * 有如下公式:
     * max = values[i] + values[j] + i -j  (i < j)
     * = (values[i] + i + values[j] - j)
     * values[i] + i 是固定的,求其最大值,在余下的里面 找到  values[j] - j 的最大值
     * <p>
     * (对于当前位置j 前面能贡献最大的 values[i] + i)
     * mx(values[i] + i):[8,8,8,8,8]
     * 数组:             [8,1,5,2,6]
     * values[j] - j:   [8,0,3,-1,2]
     * <p>
     * https://leetcode-cn.com/problems/best-sightseeing-pair/solution/zui-jia-guan-guang-zu-he-by-leetcode-solution/ (这里面的动图讲的非常好)
     *
     * @param values
     * @return
     */
    private int solution2(int[] values) {
        int result = 0;
        int maxLeft = values[0] + 0;
        for (int j = 1; j < values.length; j++) {
            result = Math.max(result, maxLeft + values[j] - j);
            maxLeft = Math.max(maxLeft, values[j] + j);
        }
        return result;
    }

    /**
     * 暴力解法
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(1)
     *
     * @param values
     * @return
     */
    private int solution1(int[] values) {
        int max = 0;
        int N = values.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                max = Math.max(max, values[i] + values[j] + i - j);
            }
        }
        return max;
    }
}
