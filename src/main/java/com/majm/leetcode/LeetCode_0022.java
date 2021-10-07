package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/2 6:22 下午
 * @since
 */
public class LeetCode_0022 implements Solution {


    /**
     * @param n
     * @return
     */
    @Override
    public List<String> generateParenthesis(int n) {
        // 1. 定义状态
        // dp[i] : i 个括号 可以生成的组合
        // 状态转移
        //

        List<List<String>> dp = new ArrayList<>();
        dp.add(0, Arrays.asList(""));
//        dp.add(1, Arrays.asList("()"));
        for (int i = 1; i <= n; i++) {
            List<String> res = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> left = dp.get(j);
                List<String> right = dp.get(i - j - 1);
                for (String s1 : left) {
                    for (String s2 : right) {
                        res.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(res);
        }
        return dp.get(dp.size() - 1);
    }


    private void dfs(String path, int n, List<String> result) {
        // termiante
        if (path.length() == 2 * n) {
            if (isValid(path)) {
                result.add(path);
            }
            return;
        }
        dfs(path + "(", n, result);
        dfs(path + ")", n, result);
    }

    private boolean valid(String path) {
        return false;
    }


    /**
     * 动态规划问题 总是忘记,不不如这一次好好总结一下,花费点精力,之后也好弄
     * <p>
     * 1. dp[0] = [""]
     * 2. dp[1] = ["()"]
     * 3. dp[2] = (+dp[0]+) + dp[1]
     * + (+dp[1]+) + dp[0]
     * <p>
     * dp[n] = (+dp[p]+) + dp[q] : p+q = n-1, p:1-n的枚举
     *
     * @param n
     * @return
     */
    private List<String> dpSolution(int n) {
        Map<Integer, List<String>> dp = new HashMap<>();
        dp.put(0, Arrays.asList(""));
        dp.put(1, Arrays.asList("()"));

        for (int i = 2; i <= n; i++) {
            List<String> curRes = new ArrayList<>();
            dp.put(i, curRes);
            for (int j = 0; j < i; j++) {
                // j+k = i-1;
                int k = i - 1 - j;
                List<String> list1 = dp.get(j);
                List<String> list2 = dp.get(k);
                for (String s1 : list1) {
                    for (String s2 : list2) {
                        curRes.add("(" + s1 + ")" + s2);
                    }
                }
            }
        }
        return dp.get(n);
    }


    /**
     * 回溯算法
     * 在 dfs解法上加上剪枝
     *
     * @param n
     * @return
     */
    private List<String> BackTraceSolution(int n) {
        List<String> result = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n, result);
        return result;
    }

    /**
     * 如果右括号 已使用个数 > 左括号已使用个数 --> 已经是有问题的了(return)
     * <p>
     * 这种方法和 dfs思想类似 详见题解: https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
     *
     * @param sBuilder
     * @param left     左括号已使用个数
     * @param right    右括号已使用个数
     * @param max      括号对数
     * @param result   结果集
     */
    private void backtrack(StringBuilder sBuilder, int left, int right, int max, List<String> result) {
        if (sBuilder.length() == 2 * max) {
            result.add(sBuilder.toString());
        }
        if (left < max) {
            backtrack(sBuilder.append('('), left + 1, right, max, result);
            sBuilder.deleteCharAt(sBuilder.length() - 1);
        }
        if (right < left) {
            backtrack(sBuilder.append(')'), left, right + 1, max, result);
            sBuilder.deleteCharAt(sBuilder.length() - 1);
        }
    }


    /**
     * 暴力解法
     * 通过递归列出所有可能的结果， 然后判断每个结果是否有效
     * 时间复杂度: O(2^(2n)n)
     * 空间复杂度: O(N)
     *
     * @param n
     * @return
     */
    public List<String> dfs1(int n) {
        List<String> result = new ArrayList<>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }

    /**
     * @param
     * @param pos    当前生成位置
     * @param result 用来存储结果集
     */
    private void generateAll(char[] chars, int pos, List<String> result) {
        if (chars.length == pos) {
            if (isValid(chars)) {
                result.add(new String(chars));
            }
        } else {
            chars[pos] = '(';
            generateAll(chars, pos + 1, result);
            chars[pos] = ')';
            generateAll(chars, pos + 1, result);
        }
    }

    private boolean isValid(char[] chars) {
        int balance = 0;
        for (int i = 0; i < chars.length; i++) {
            char ac = chars[i];
            if (ac == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        final LeetCode_0022 leetCode = new LeetCode_0022();
        System.out.println(leetCode.generateParenthesis(2));
        System.out.println(leetCode.generateParenthesis(3));
    }


}
