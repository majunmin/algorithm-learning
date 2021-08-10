package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-10 08:09
 * @since
 */
public class LeetCode_0438 implements Solution {

    @Override
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int l1 = s.length();
        int l2 = p.length();
        if (l1 < l2) {
            return result;
        }
        int[] need = new int[26];
        int[] window = new int[26];
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        while (right < l1) {
            char curChar = s.charAt(right);
            window[curChar - 'a']++;
            right++;

            while (need[curChar - 'a'] < window[curChar - 'a'] && left < right) {
                char leftChar = s.charAt(left);
                window[leftChar - 'a']--;
                left++;
            }
            // 符合条件 加入
            if (right - left == l2) {
                result.add(left);
            }
        }
        return result;
    }


    /**
     * 解法一:
     * 1.利用窗口的固定大小
     * 2. Arrays.equals() 判断两个数组相等
     *
     * @param s
     * @param p
     * @return
     */
    private List<Integer> solution1(String s, String p) {
        // 边界条件
        int l1 = s.length();
        int l2 = p.length();
        List<Integer> result = new ArrayList<>();

        if (l1 < l2) {
            return result;
        }

        // need Window
        int[] need = new int[26];
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }

        int[] window = new int[26];
        int left = 0;
        int right = 0;
        while (right < l1) {
            char curChar = s.charAt(right);
            window[curChar - 'a']++;
            right++;

            // 收缩窗口
            while (left < right && right - left == l2) {
                // 判断是否是异位词 (相同字母的排列)
                if (Arrays.equals(need, window)) {
                    result.add(left);
                }
                char leftChar = s.charAt(left);
                window[leftChar - 'a']--;
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        final Solution leetCode = new LeetCode_0438();
//        System.out.println(leetCode.findAnagrams("cbaebabacd", "abc"));
        System.out.println(leetCode.findAnagrams("abab", "ab"));
    }
}
