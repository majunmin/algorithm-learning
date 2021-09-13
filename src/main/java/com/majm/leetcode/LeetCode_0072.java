package com.majm.leetcode;

import com.majm.Solution;

/**
 * 72. 编辑距离 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-09 00:56
 * @since
 */
public class LeetCode_0072 implements Solution {

    private int minDist = Integer.MAX_VALUE;


    /**
     * @param word1
     * @param word2
     * @return
     */
    @Override
    public int minDistance(String word1, String word2) {
        return recurSolution(word1, word2);
    }


    /**
     * 递归 算是比较简单的 解法
     * (大量重复计算, 会超时)
     *
     * @param word1
     * @param word2
     * @return
     */
    private int recurSolution(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        if (word1.charAt(word1.length() - 1) == word2.charAt(word2.length() - 1)) {
            return recurSolution(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1));
        }

        int result = Integer.MAX_VALUE;
        result = Math.min(result, recurSolution(word1.substring(0, word1.length() - 1), word2));
        result = Math.min(result, recurSolution(word1, word2.substring(0, word2.length() - 1)));
        result = Math.min(result, recurSolution(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1)));
        return result + 1;
    }

    private int dpSolution(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0 || len2 == 0) {
            return Math.max(len1, len2);
        }
        int[][] dp = new int[len1][len2];
        // init
        for (int i = 0; i < len2; i++) {
            if (chars1[0] == chars2[i]) {
                dp[0][i] = i;
            } else if (i != 0) {
                dp[0][i] = dp[0][i - 1] + 1;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < len1; i++) {
            if (chars1[i] == chars2[0]) {
                dp[i][0] = i;
            } else if (i != 0) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }

    private int backTraceSolution(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        return backTrace(chars1, chars2, 0, 0, 0);
    }

    /**
     * 回溯是一个递归处理的过程。如果 a[i]与 b[j]匹配，我们递归考察 a[i+1]和 b[j+1]。
     * 如果 a[i]与 b[j]不匹配，那我们有多种处理方式可选：
     * <ol>
     *     <li>可以删除 a[i]，然后递归考察 a[i+1]和 b[j];</li>
     *     <li>可以删除 b[j]，然后递归考察 a[i]和 b[j+1];</li>
     *     <li>可以在 a[i]前面添加一个跟 b[j]相同的字符，然后递归考察 a[i]和 b[j+1];</li>
     *     <li>可以在 b[j]前面添加一个跟 a[i]相同的字符，然后递归考察 a[i+1]和 b[j];</li>
     *     <li>可以将 a[i]替换成 b[j]，或者将 b[j]替换成 a[i]，然后递归考察 a[i+1]和 b[j+1]</li>
     * </ol>
     *
     * @param chars1
     * @param chars2
     * @param idx1
     * @param idx2
     * @param edist  当前的编辑距离
     * @return
     */
    private int backTrace(char[] chars1, char[] chars2, int idx1, int idx2, int edist) {
        int len1 = chars1.length;
        int len2 = chars2.length;
        // terminate
        if (idx1 == len1 || idx2 == len2) {
            if (idx1 < len1) {
                edist += (len1 - idx1);
            }
            if (idx2 < len2) {
                edist += (len2 - idx2);
            }
            return Math.min(edist, minDist);
        }
        if (chars1[idx1] == chars2[idx2]) {
            minDist = Math.min(minDist, backTrace(chars1, chars2, idx1 + 1, idx2 + 1, edist));
        } else { // 不匹配
            // del a[i] 或者 在 b[j] 前 添加一个  与a[i] 相同的字符
            minDist = Math.min(minDist, backTrace(chars1, chars2, idx1 + 1, idx2, edist + 1));
            // del b[j] 或者 在 a[i] 前 添加一个  与b[j] 相同的字符
            minDist = Math.min(minDist, backTrace(chars1, chars2, idx1, idx2 + 1, edist + 1));
            // 将 a[i] (b[j]) 替换为 b[j](a[i])
            minDist = Math.min(minDist, backTrace(chars1, chars2, idx1 + 1, idx2 + 1, edist + 1));
        }
        return minDist;
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0072();
        System.out.println(leetCode.minDistance("zoologicoarchaeologist", "zoogeologist"));
    }

}
