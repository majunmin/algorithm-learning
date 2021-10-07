package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 678. 有效的括号字符串 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-12 17:18
 * @since
 */
public class LeetCode_0678 implements Solution {


    /**
     * @param s
     * @return
     */
    @Override
    public boolean checkValidString(String s) {
        return greedySolution(s);
    }

    /**
     * 贪心算法
     * 计数解法
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * {@link LeetCode_0020}
     * <p>
     * <p>
     * 从左到右遍历字符串，遍历过程中，未匹配的左括号数量可能会出现如下变化：
     * 如果遇到左括号，则未匹配的左括号数量加 11；
     * 如果遇到右括号，则需要有一个左括号和右括号匹配，因此未匹配的左括号数量减 11；
     * 如果遇到星号，由于星号可以看成左括号、右括号或空字符串，因此未匹配的左括号数量可能加 11、减 11 或不变.
     * <p>
     * 基于上述结论，可以在遍历过程中维护未匹配的左括号数量可能的最小值和最大值，根据遍历到的字符更新最小值和最大值:
     * <p>
     * 如果遇到左括号，则将最小值和最大值分别加 11；
     * 如果遇到右括号，则将最小值和最大值分别减 11；
     * 如果遇到星号，则将最小值减 11，将最大值加 11。
     * <p>
     *
     * @param s
     * @return
     */
    private boolean greedySolution(String s) {
        int len = s.length();
        int minCnt = 0;
        int maxCnt = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                minCnt++;
                maxCnt++;
            } else if (c == ')') {
                minCnt = Math.max(minCnt - 1, 0);
                maxCnt--;
                if (maxCnt < 0) {
                    return false;
                }
            } else {
                minCnt = Math.max(minCnt - 1, 0);
                maxCnt++;
            }
        }
        return minCnt == 0;
    }

    /**
     * 验证括号匹配,一般都可以使用栈来解决
     * <p>
     * 如果 没有 '*', 只用 一个栈 来做就可以了, 复杂就复杂在 多了一个  '*'
     * <p>
     * 这时可以使用 两个 栈 来解决,从左到右遍历字符串,作如下操作:
     * <ol>
     *     <li>如果遇到左括号，则将当前下标存入左括号栈。</li>
     *     <li>如果遇到星号，则将当前下标存入星号栈。</li>
     *     <li>如果遇到右括号，则需要有一个左括号或星号和右括号匹配，由于星号也可以看成右括号或者空字符串，因此当前的右括号应优先和左括号匹配，没有左括号时和星号匹配：</li>
     *     <ol>
     *          <li>如果左括号栈不为空，则从左括号栈弹出栈顶元素;</li>
     *          <li>如果左括号栈为空且星号栈不为空，则从星号栈弹出栈顶元素;</li>
     *          <li>如果左括号栈和星号栈都为空，则没有字符可以和当前的右括号匹配，返回 false.</li>
     *     </ol>
     * <ol/>
     * <p>
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * <p>
     *
     * @param s
     * @return
     */
    private boolean stackSolution(String s) {
        Deque<Integer> leftStack = new ArrayDeque<>();
        Deque<Integer> asteriskStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
            }
            if (c == '*') {
                asteriskStack.push(i);
            }
            if (c == ')') {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }
        // check leftStack and asterStack
        // 比较剩余的  leftStack and asteriskStack,  根据 index 进行比较
        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
            int leftIdx = leftStack.pop();
            int rightIdx = asteriskStack.pop();
            if (leftIdx > rightIdx) {
                return false;
            }
        }
        // - 如果 到最后 leftStack 不为空, 说明有未匹配的 左括号, 返货false
        // - 如果 asterislkStack 不为空, 可以把 '*' 看做是 '',不影响结果
        return leftStack.isEmpty();
    }


    /**
     * 这个题目的解法有点像 Floyd 算法
     */
    private boolean dpSolution(String s) {
        // dpSolution
        // 定义状态
        // dp[i][j] 字符串s 从下标 i 到 下标 j 是否为有效地 括号字符串  0 <= i < j < n
        // 状态转移
        // dp[i][j] = dp[i][k] && dp[k+1][j]   0 <= i <= k < j
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = s.charAt(i) == '*';
        }
        for (int i = 1; i < len; i++) {
            char lChar = s.charAt(i - 1);
            char rChar = s.charAt(i);
            if ((lChar == '*' || lChar == '(') && (rChar == '*' || rChar == ')')) {
                dp[i - 1][i] = true;
            }
        }

        for (int i = len - 3; i >= 0; i--) {
            char lChar = s.charAt(i);
            for (int j = i + 2; j < len; j++) {
                char rChar = s.charAt(j);
                if ((lChar == '*' || lChar == '(') && (rChar == '*' || rChar == ')')) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                for (int k = i; k < j && !dp[i][j]; k++) {
                    dp[i][j] = dp[i][k] && dp[k + 1][j];
                }
            }
        }

        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0678();
        System.out.println(leetCode.checkValidString("((****))"));
    }
}
