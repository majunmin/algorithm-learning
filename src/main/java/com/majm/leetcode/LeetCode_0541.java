package com.majm.leetcode;

import com.majm.Solution;

/**
 * 541. 反转字符串 II </br>
 * https://leetcode-cn.com/problems/reverse-string-ii/
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-20 22:17
 * @since
 */
public class LeetCode_0541 implements Solution {

    @Override
    public String reverseStr(String s, int k) {
        return iterSolution(s, k);
    }


    private String iterSolution(String s, int k) {
        char[] chars = s.toCharArray();
        for (int l = 0; l < chars.length; l += 2 * k) {
            reverseStr(chars, l, Math.min(l + k, chars.length) - 1);
        }
        return new String(chars);
    }

    private void reverseStr(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }


    /**
     * 递归解法
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param s
     * @param k
     * @return
     */
    private String recurSolution(String s, int k) {
        char[] chars = s.toCharArray();
        reverseStr(chars, 0, Math.min(chars.length, k) - 1, k);
        return new String(chars);
    }

    private void reverseStr(char[] chars, int l, int r, int k) {
        // terminate
        if (l >= r) {
            return;
        }

        int start = l;
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        l = start + k * 2;
        reverseStr(chars, l, Math.min(chars.length, l + k) - 1, k);
    }

    public static void main(String[] args) {
        final Solution leetCode = new LeetCode_0541();
        System.out.println(leetCode.reverseStr("abcdefgh", 2));
        System.out.println(leetCode.reverseStr("abcdefg", 2));
        System.out.println(leetCode.reverseStr("abcdef", 2));
    }
}
