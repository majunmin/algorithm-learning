package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/28 12:58 下午
 * @since
 */
public class LeetCode242 implements Solution {

    @Override
    public boolean isAnagram(String s, String t) {
        return solution1(s, t);
    }


    /**
     * 时间复杂度: O(N)
     * 空间复杂度: O(1) (虽然新引入一个数组，但数组大小是常数)
     * @param s
     * @param t
     * @return
     */
    private boolean solution3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            arr[sc - 'a']++;
            arr[tc - 'a']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0){
                return false;
            }
        }
        return true;
    }

    private boolean solution2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            hashMap.put(sc, hashMap.getOrDefault(sc, 0) + 1);
            hashMap.put(tc, hashMap.getOrDefault(tc, 0) - 1);
        }

        for (Integer value : hashMap.values()) {
            if (value != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * Arrays.sort 时间复杂度 是 O(Nlog(N))
     * equals() 时间复杂度 O(N)               -> O(Nlog(N))
     * 空间复杂度  O(1)
     * 1. 排序后比较数组是否相同
     * @param s
     * @param t
     * @return
     */
    private boolean solution1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}
