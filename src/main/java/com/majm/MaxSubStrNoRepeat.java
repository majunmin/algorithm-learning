package com.majm;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-01-23 21:20
 * @since
 */
public class MaxSubStrNoRepeat {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }

    /**
     *
     * asdfgteq
     */
    public static int lengthOfLongestSubstring(String str) {
        char[] chars = str.toCharArray();
        int maxLen = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j <= chars.length; j++) {
                if (isAllUnique(chars, i , j)) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }

    private static boolean isAllUnique(char[] chars, int i, int j) {
        Set<Character> set = new HashSet<Character>();
        for (int k = i; k < j; k++) {
             set.add(chars[k]);
        }
        return set.size() == j - i;
    }



    public static int lengthOfLongestSubstring1(String str) {
        char[] chars = str.toCharArray();
        int maxLen = 0;
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j <= chars.length - i; j++) {
                if (isAllUnique(chars, j, j + i)){
                    maxLen = Math.max(maxLen, i);
                }

            }
        }
        return maxLen;
    }


    /**
     * 滑动窗口
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring2(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        int i = 0;
        int j = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<Character>();
        while(i < len && j < len){
            if (!set.contains(chars[j])){
                set.add(chars[j]);
                j++;
                maxLen = Math.max(j - i, maxLen);
            } else {
                set.remove(chars[i++]);
            }
        }
        return maxLen;
    }
}
