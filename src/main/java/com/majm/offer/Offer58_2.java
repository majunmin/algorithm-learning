package com.majm.offer;

/**
 * 剑指 Offer 58 - II. 左旋转字符串 </br>
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-15 09:41
 * @since
 */
public class Offer58_2 {


    public String reverseLeftWords(String s, int n) {
        return solution2(s, n);
    }

    private String solution2(String s, int n) {
        int len = s.length();
        if (n < 0 || n > len) {
            throw new IllegalArgumentException();
        }
        if (n == len || n == 0) {
            return s;
        }
        char[] result = new char[len];
        int idx = 0;
        for (int i = n; i < len + n; i++) {
            result[idx++] = s.charAt(i % len);
        }
        return new String(result);
    }

    private String solution1(String s, int n) {
        int len = s.length();
        if (n < 0 || n > len) {
            throw new IllegalArgumentException();
        }
        if (n == len || n == 0) {
            return s;
        }
        char[] result = new char[len];
        int cnt = 0;
        for (int i = n; i < len; i++) {
            result[cnt++] = s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            result[cnt++] = s.charAt(i);
        }
        return new String(result);
    }
}
