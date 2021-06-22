package com.majm.leetcode;

/**
 * 字符串 </br>
 * 最长公共前缀
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-09 18:27
 * @since
 */


public class LeetCode_0014 {

    public String commonLongestPrefix(String[] arr) {
        if (arr.length == 0) {
            return "";
        }
        if (arr.length == 1) {
            return arr[0];
        }

        StringBuilder prefix = new StringBuilder();
        for (int j = 0; j < arr[0].length(); j++) {
            boolean isPrefix = true;
            char c = arr[0].charAt(j);
            for (int i = 0; i < arr.length; i++) {
                if (j < arr[i].length() && arr[i].charAt(j) == c) {
                    continue;
                }
                isPrefix = false;
                break;
            }
            if (!isPrefix) {
                break;
            }
            prefix.append(c);
        }
        return prefix.toString();
    }
}












