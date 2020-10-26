package com.majm.letcode;

import com.majm.Solution;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/24 7:53 下午
 * @since
 */
public class LeetCode299 implements Solution {

    @Override
    public String getHint(String secret, String guess) {

        // 数组缓存法 (或者用 Map缓存)
//        if (secret == null || guess == null){
//            return null;
//        }
//
//        int x =0;
//        int y =0;
//        int len = secret.length();
//        int[] cache = new int[10]; // 保存 索引 1-10 (数字) 到 数组中的值 (出现的频率) 的映射
//        for (int i = 0; i < len; i++) {
//            char sc = secret.charAt(i);
//            char gc = guess.charAt(i);
//            if (sc == gc){
//                x++;
//            } else {
//                if (cache[sc - '0']++ < 0) y++;
//                if (cache[gc - '0']-- > 0) y++;
//            }
//        }

        int x = 0;
        int len = secret.length();
        int[] bucket = new int[10];
        for (int i = 0; i < len; i++) {
            char sc = secret.charAt(i);
            char gc = guess.charAt(i);
            if (sc == gc) {
                x++;
            }
            bucket[sc - '0']++;
            bucket[gc - '0']--;
        }
        int notMatch = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 0) {
                notMatch += bucket[i];
            }
        }

        int y = len - x - notMatch;
        return x + "A" + y + "B";
    }

}
