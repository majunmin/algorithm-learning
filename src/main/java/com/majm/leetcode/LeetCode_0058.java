package com.majm.leetcode;

import com.majm.Solution;

/**
 * 58. 最后一个单词的长度 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-21 20:03
 * @since
 */
public class LeetCode_0058 implements Solution {

    @Override
    public int lengthOfLastWord(String s) {
        int result = 0;
        if (s == null) {
            return result;
        }

        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' '){
                break;
            }
            result++;
        }
        return result;
    }

}
