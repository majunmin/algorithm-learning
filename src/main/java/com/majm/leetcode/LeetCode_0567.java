package com.majm.leetcode;

import com.majm.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-09 23:47
 * @since
 */
public class LeetCode_0567 implements Solution {

    @Override
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2) {
            return false;
        }

        int left = 0;
        int right = 0;
        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) {
            cnt[c - 'a']--;
        }
        while (right < l2) {
            char curChar = s2.charAt(right);
            cnt[curChar - 'a']++;
            // 找一个合法的开头 (left)
            while (cnt[curChar - 'a'] > 0) {
                char leftChar = s2.charAt(left);
                cnt[leftChar - 'a']--;
                left++;
            }

            if (right - left + 1 == l1) {
                return true;
            }
            right++;
        }
        return false;
    }


    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0567();
        System.out.println(leetCode.checkInclusion("abb", "eightbabooo"));
    }
}
