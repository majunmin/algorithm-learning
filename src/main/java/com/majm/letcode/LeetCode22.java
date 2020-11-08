package com.majm.letcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/2 6:22 下午
 * @since
 */
public class LeetCode22 implements Solution {

    @Override
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        StringBuilder sBuidler = new StringBuilder();
        generateAll(sBuidler, 0, 0, n, result);
        return result;
    }


    private void generateAll(StringBuilder sBuilder, int left, int right, int n, List<String> result) {
        if (sBuilder.length() == n * 2) {
            result.add(sBuilder.toString());
            return;
        }

        // 左括号随时可以添加 只要  left< n
        if (left < n) {
            sBuilder.append("(");
            generateAll(sBuilder, left + 1, right, n, result);
            sBuilder.deleteCharAt(left + right);
        }

        // 只有 在 right < left 时， 右括号才可以添加
        if (right < left) {
            sBuilder.append(")");
            generateAll(sBuilder, left, right + 1, n, result);
            sBuilder.deleteCharAt(left + right);
        }
    }


    private List<String> solution2(int n) {
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
    public List<String> solution1(int n) {
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


}
