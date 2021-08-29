package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-29 10:42
 * @since
 */
public class LeetCode_0139 implements Solution {


    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        return bfsSolution2(s, wordDict);
    }


    /**
     * bfs优化, 记忆化
     *
     * @param s
     * @param wordDict
     * @return
     */
    private boolean bfsSolution2(String s, List<String> wordDict) {
        Deque<String> queue = new ArrayDeque<>();
        // 记忆已访问的 单词集合
        Set<String> visited = new HashSet<>();
        visited.add(s);
        queue.push(s);
        while (!queue.isEmpty()) {
            String curStr = queue.poll();
            for (String word : wordDict) {
                if (curStr.startsWith(word)) {
                    String leftStr = curStr.substring(word.length());
                    if ("".equals(leftStr)) {
                        return true;
                    }
                    if (visited.contains(leftStr)) {
                        continue;
                    }
                    queue.push(leftStr);
                    visited.add(leftStr);
                }
            }
        }
        return false;
    }

    private boolean bfsSolution(String s, List<String> wordDict) {

        Deque<Integer> queue = new ArrayDeque<>();
        queue.push(0);
        // 开始 查找的索引
        while (!queue.isEmpty()) {
            int index = queue.pop();
            // terminate
            if (index == s.length()) {
                return true;
            }
            for (int i = index + 1; i <= s.length(); i++) {
                String candidate = s.substring(index, i);
                if (wordDict.contains(candidate)) {
                    queue.push(index + candidate.length());
                }
            }
        }
        return false;
    }


    /**
     * dpSolution 优化
     *
     * @param s
     * @param wordDict
     * @return
     */
    private boolean dpSolution3(String s, List<String> wordDict) {
        return false;
    }


    /**
     * https://leetcode-cn.com/problems/word-break/solution/shou-hui-tu-jie-san-chong-fang-fa-dfs-bfs-dong-tai/
     *
     * @param s
     * @param wordDict
     * @return
     */
    private boolean dpSolution2(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i < len + 1; i++) {
            for (int j = i; j >= 0; j--) { // 用 j 去 划分子串
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    // 说明  i  之前的可以被划分为子串了,不需要在划分了
                    break;
                }
            }
        }
        return dp[len];
    }


    /**
     * 01背包问题,动态规划解法
     *
     * @param s
     * @param wordDict
     * @return
     */
    private boolean dpSolution(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[s.length() + 1];
        // 1. 定义状态
        // if dp[i] == true : 表示  dp[x:i) 在 wordDict里面
        // 2. 状态转移
        // dp[i] = dp[x] && wordDict.contains(s[x:i))
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length + 1; j++) {
                if (dp[i] && wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[length];
    }


    /**
     * dfs解法优化,加入记忆化搜索
     *
     * @param s
     * @param wordDict
     * @return
     */
    private boolean dfsSolution2(String s, List<String> wordDict) {
        Set<String> visited = new HashSet<>();
        return dfsSolutionHelper(s, wordDict, visited);
    }


    /**
     * @param leftStr
     * @param wordDict
     * @param set      记忆化结果(leftStr 不能被拆分)
     * @return
     */
    private boolean dfsSolutionHelper(String leftStr, List<String> wordDict, Set<String> set) {
        // terminate
        if (set.contains(leftStr)) {
            return false;
        }
        if ("".equals(leftStr)) {
            return true;
        }
        for (String word : wordDict) {
            if (leftStr.startsWith(word) && dfsSolutionHelper(leftStr.substring(word.length()), wordDict, set)) {
                return true;
            }
        }
        //
        set.add(leftStr);
        return false;
    }

    /**
     * dfsSolution
     * 超时
     *
     * @param s
     * @param wordDict
     * @return
     */
    private boolean dfsSolution(String s, List<String> wordDict) {
        if ("".equals(s)) {
            return true;
        }
        for (String span : wordDict) {
            if (s.startsWith(span) && wordBreak(s.substring(span.length()), wordDict)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0139();
        System.out.println(leetCode.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(leetCode.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(leetCode.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }
}
