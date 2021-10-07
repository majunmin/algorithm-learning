package com.majm.leetcode;

import com.majm.Solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 443. 压缩字符串 </br>
 * https://leetcode-cn.com/problems/string-compression/
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-21 11:07
 * @since
 */
public class LeetCode_0443 implements Solution {

    /**
     * 返回压缩后 字符串的长度
     *
     * @param chars
     * @return
     */
    @Override
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;
        int left = -1;
        for (int read = 0; read < chars.length; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];

                int num = read - left;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) ((num % 10) + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read;
            }
        }
        return write;
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 时间复杂度:
     * 空间复杂度: O(2N)
     *
     * @param chars
     * @return
     */
    private int stackSolution(char[] chars) {
        Deque<Character> stack = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        int cnt = 0;
        for (char aChar : chars) {
            if (stack.isEmpty()) {
                stack.push(aChar);
                cnt++;
                continue;
            }

            if (stack.peek() == aChar) {
                cnt++;
                continue;
            }
            result.append(stack.pop());
            result.append(cnt);
            stack.push(aChar);
            cnt++;
        }
        result.append(stack.pop());
        if (cnt > 1) {
            result.append(cnt);
        }
        return result.length();
    }

    public static void main(String[] args) {
        final Solution leetCode = new LeetCode_0443();
        System.out.println(leetCode.compress("aabbccc".toCharArray()));
        System.out.println(leetCode.compress("aabbbbbbbbbbbb".toCharArray()));
    }

}
