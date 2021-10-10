package com.majm.offer;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II </br>
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-10 00:24
 * @since
 */
public class Offer56_2 {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int oneCnt = 0;
            int pos = 1 << i;
            for (int num : nums) {
                if ((num & pos) != 0) {
                    oneCnt++;
                }
            }
            if (oneCnt % 3 != 0) {
                result |= pos;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        final Offer56_2 offer = new Offer56_2();
        System.out.println(offer.singleNumber(new int[]{3, 3, 4, 3}));
    }

}
