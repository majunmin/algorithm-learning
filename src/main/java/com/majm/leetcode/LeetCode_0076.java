package com.majm.leetcode;

import com.majm.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 76. 最小覆盖子串  </br>
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-28 00:38
 * @since
 */
public class LeetCode_0076 implements Solution {

    /**
     * @param s
     * @param t
     * @return
     */
    @Override
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int len = s.length();

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        int match = 0; // 优化 判断 合法窗口
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";

        while (right < len) {
            char curChar = s.charAt(right);
            if (need.containsKey(curChar)) {
                window.compute(curChar, (k, v) -> v == null ? 1 : v + 1);
                //
                if (window.get(curChar).equals(need.get(curChar))) {
                    match++;
                }
            }
            right++;

            // 判断是一个 valid 窗口 , 准备 收缩窗口
            while (match == need.size() && left <= right) {
                // 更新结果
                if (right - left < minLen) {
                    result = s.substring(left, right);
                    minLen = right - left;
                }

                char leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    if (need.get(leftChar).equals(window.get(leftChar))) {
                        match--;
                    }
                    window.compute(leftChar, (k, v) -> v == null ? 0 : v - 1);
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : result;
    }

    /**
     * 比较原始的解法
     * 第一版,根据这个进行优化
     *
     * @param s
     * @param t
     * @return
     */
    private String rawSolution(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int len = s.length();
        String result = "";
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        int left = 0;
        int right = 0;
        while (right < len) {
            while (isValid(left, right, s, need)) {
                if ("".equals(result) || right - left + 1 < result.length()) {
                    result = s.substring(left, right + 1);
                }
                left++;
            }
            right++;
        }

        return result;
    }

    private boolean isValid(int left, int right, String s, Map<Character, Integer> need) {
        Map<Character, Integer> map = new HashMap<>();
        int i = left;
        while (i <= right) {
            map.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            i++;
        }
        for (Map.Entry<Character, Integer> entry : need.entrySet()) {
            if (!map.containsKey(entry.getKey()) || entry.getValue() > map.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }


    private String solution2(String s, String t) {
        String result = s;
        // 滑动窗口法
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needWindow = new HashMap<>();
        int match = 0;
        for (Character c : t.toCharArray()) {
            needWindow.compute(c, (key, val) -> val == null ? 1 : val + 1);
        }

        int left = 0;
        int right = 0;
        // 扩展窗口
        while (right < s.length()) {
            char curChar = s.charAt(right);
            window.compute(curChar, (k, v) -> v == null ? 1 : v + 1);
            if (window.get(curChar).equals(needWindow.get(curChar))) {
                match++;
            }
            // 收缩窗口
            while (match == needWindow.size() && left <= right) {
                if (right - left + 1 <= result.length()) {
                    result = s.substring(left, right + 1);
                }
                Character c = s.charAt(left);
                if (window.get(c).equals(needWindow.get(c))) {
                    match--;
                }
                window.computeIfPresent(c, (key, val) -> val - 1);
                left++;
            }
            right++;
        }
        if (left == 0) {
            return "";
        }
        return result;
    }

    private boolean isValid(Map<Character, Integer> window, Map<Character, Integer> needWindow) {
        for (Map.Entry<Character, Integer> entry : needWindow.entrySet()) {
            if (!window.containsKey(entry.getKey()) || needWindow.get(entry.getKey()) > window.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 滑动窗口思想
     *
     * @param s
     * @param t
     * @return
     */
    private String solution1(String s, String t) {
        char[] array = s.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.compute(c, (key, val) -> val == null ? 1 : val + 1);
        }

        int left = 0, right = 0, match = 0;
        String result = s;
        int len = array.length;
        while (right < len) {
            char curChar = array[right];

            window.compute(curChar, (key, value) -> value == null ? 1 : value + 1);
            if (Objects.equals(window.get(curChar), need.get(curChar))) {
                match++;
            }

            while (match == need.size() && left <= right) {
                char c = array[left];
                if (Objects.equals(window.get(c), need.get(c))) {
                    match--;
                }
                window.computeIfPresent(c, (key, val) -> val - 1);
                if (right - left + 1 < result.length()) {
                    result = new String(array, left, right - left + 1);
                }
                left++;
            }
            right++;
        }
        if (left == 0) {
            return "";
        }
        return result;
    }

    public static void main(String[] args) {
        final LeetCode_0076 leetCode = new LeetCode_0076();
        System.out.println(leetCode.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(leetCode.minWindow("A", "A"));
        System.out.println(leetCode.minWindow("AFGHLKJI", "ABC"));
    }
}
