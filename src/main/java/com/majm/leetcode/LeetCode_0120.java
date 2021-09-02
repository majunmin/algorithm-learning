package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-02 23:12
 * @since
 */
public class LeetCode_0120 implements Solution {


    /**
     * dp[i][j] = min(dp[i-1][j] dp[i-1][j-1]) + nums[i][j];
     *
     * @param triangle
     * @return
     */
    @Override
    public int minimumTotal(List<List<Integer>> triangle) {
        return dpSolution(triangle);
    }


    /**
     * 动态规划解法
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(N)
     * <p>
     * 因为  每一层的 数结果 仅依赖于 下一层的结果,所以可以用一个以为数组 表示 之前的结果
     *
     * @param triangle
     * @return
     */
    private int dpSolution(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len + 1];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }


    /**
     * 递归解法
     *
     * @param triangle
     * @return
     */
    private int recurSolution(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int r, int c) {
        if (r == triangle.size()) {
            return 0;
        }
        return triangle.get(r).get(c) + Math.min(dfs(triangle, r + 1, c), dfs(triangle, r + 1, c + 1));
    }


    /**
     * 自底向上 dp
     *
     * @param triangle
     * @return
     */
    private int solution2(List<List<Integer>> triangle) {
        //边界条件
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        List<Integer> curPath = triangle.get(triangle.size() - 1);
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> upPath = triangle.get(i);
            for (int j = 0; j < upPath.size(); j++) {
                upPath.set(j, upPath.get(j) + Math.min(curPath.get(j), curPath.get(j + 1)));
            }
            curPath = upPath;
        }
        return triangle.get(0).get(0);
    }


    /**
     * 自顶向下  dp
     *
     * @param triangle
     * @return
     */
    private int solution1(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }

        List<Integer> prevPath = triangle.get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> path = triangle.get(i);
            // fill first and last
            path.set(0, prevPath.get(0) + path.get(0));
            path.set(path.size() - 1, prevPath.get(prevPath.size() - 1) + path.get(path.size() - 1));

            for (int j = 1; j < i; j++) {
                path.set(j, path.get(j) + Math.min(prevPath.get(j - 1), prevPath.get(j)));
            }
            prevPath = path;
        }

        int result = prevPath.get(0);
        for (int i = 1; i < prevPath.size(); i++) {
            result = Math.min(result, prevPath.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0120();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(leetCode.minimumTotal(list));
    }

}
