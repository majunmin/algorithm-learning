package com.majm.leetcode;

import com.majm.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. 回旋镖的数量 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-13 15:24
 * @since
 */
public class LeetCode_0447 implements Solution {


    /**
     * 如果有m个点 到 points[i] 的距离相等,需要从 m个点中选取两个 点作为回旋镖的两个端点
     * <p>
     * 因此方案数即为在 m 个元素中选出 2 个不同元素的排列数，即: A = m * (m-1)
     *
     * @param points
     * @return
     */
    @Override
    public int numberOfBoomerangs(int[][] points) {
        // cnt 与 个数的映射关系
        int result = 0;
        for (int[] p1 : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] p2 : points) {
                // 避免开根号， dist = x*x + y*y
                int dist = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                map.compute(dist, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
            }
            result += map.values().stream().mapToInt(val -> val * (val - 1)).sum();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0447();
        System.out.println(leetCode.numberOfBoomerangs(new int[][]{{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}}));
    }

}
