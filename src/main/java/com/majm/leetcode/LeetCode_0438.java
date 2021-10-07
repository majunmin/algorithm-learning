package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        int left = 0;
        int right = 0;
        int[] need = new int[26];
        int[] window = new int[26];
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }

        while (right < l1) {
            char curChar = s.charAt(right);
            window[curChar - 'a']++;
            right++;

            // need[curChar - 'a'] < window[curChar - 'a']  :收缩窗口的条件, window包含有效地  字符
            while (left < right && need[curChar - 'a'] < window[curChar - 'a']) {
                char leftChar = s.charAt(left);
                window[leftChar - 'a']--;
                left++;
            }
            if (right - left == l2) {
                result.add(left);
            }
        }


        return result;
    }

    /**
     * 算是一种比较通用的解法
     *
     * @param s
     * @param p
     * @return
     */
    private List<Integer> commonSolution(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int l1 = s.length();
        int l2 = p.length();
        if (l1 < l2) {
            return result;
        }
        // 需要的窗口
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        int left = 0;
        int right = 0;

        int match = 0;
        while (right < l1) {
            char curChar = s.charAt(right);
            if (need.containsKey(curChar)) {
                window.compute(curChar, (k, v) -> v == null ? 1 : v + 1);
                if (window.get(curChar).equals(need.get(curChar))) {
                    match++;
                }
            }
            right++;

            // 收缩窗口
            while (match == need.size()) {
                // 如果满足长度条件,加入结果集
                if (right - left == l2) {
                    result.add(left);
                }
                char leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    window.compute(leftChar, (k, v) -> v - 1);
                    if (window.get(leftChar) < need.get(leftChar)) {
                        match--;
                    }
                }
                left++;
            }
        }

        return result;
    }


    /**
     * @param s
     * @param p
     * @return
     */
    private List<Integer> solution2(String s, String p) {
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
        System.out.println(leetCode.findAnagrams("baa", "aa"));
        System.out.println(leetCode.findAnagrams("cbaebabacd", "abc"));
        System.out.println(leetCode.findAnagrams("abab", "ab"));
    }
}
