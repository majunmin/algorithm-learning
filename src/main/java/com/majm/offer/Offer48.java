package com.majm.offer;


import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串 </br>
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-23 18:05
 * @since
 */
public class Offer48 {

    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        return solution2(s);
    }

    /**
     * 对于 "a"     这种场景的特殊考虑
     *
     * @param s
     * @return
     */
    private int solution2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int end = 0; end < len; end++) {
            char curChar = chars[end];
            if (map.containsKey(curChar)) {
                start = Math.max(start, map.get(curChar) + 1);
            }
            map.put(curChar, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }

    private int solution1(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int len = s.length();
        int right = 0;
        int left = 0;
        int maxLen = 0;
        while (right < len) {
            // 移动右指针
            char curChar = s.charAt(right);
            if (!map.containsKey(curChar)) {
                map.put(curChar, right);
                right++;
                // update result
                maxLen = Math.max(maxLen, right - left);
                continue;
            }
            Integer rdx = map.get(curChar);
            while (left <= rdx) {
                map.remove(s.charAt(left++));
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        Offer48 offer48 = new Offer48();
        System.out.println(offer48.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(offer48.lengthOfLongestSubstring("a"));
    }
}
