package com.majm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符 </br>
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-17 20:47
 * @since
 */
public class Offer50 {

    public char firstUniqChar(String s) {
        Map<Character, Integer> cache = new HashMap<>();
        for (char c : s.toCharArray()) {
            cache.compute(c, (k, v) -> v == null? 1: v+1);
        }
        for (char c : s.toCharArray()) {
            if (cache.get(c) != null &&cache.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }
}
