package com.majm.offer;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序 </br>
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-25 16:16
 * @since
 */
public class Offer58_1 {

    /**
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] eles = s.trim().split(" ");
        StringBuilder sBuilder = new StringBuilder();
        for (int i = eles.length - 1; i >= 0; i--) {
            if (eles[i].length() > 0) {
                sBuilder.append(eles[i]);
                if (i != eles.length - 1) {
                    sBuilder.append(" ");
                }
            }
        }
        return sBuilder.toString();
    }
}
