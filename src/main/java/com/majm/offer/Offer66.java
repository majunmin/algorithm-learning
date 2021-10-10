package com.majm.offer;

/**
 * 剑指 Offer 66. 构建乘积数组 </br>
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-10 16:06
 * @since
 */
public class Offer66 {

    /**
     * 前缀积
     * nums = [1, 2, 3, 4, 5]
     * a = [1, 1, 3, 6, 24]
     * b = [120, 60, 20, 5, 1]
     *
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int len = a.length;

        int[] result = new int[len];
        result[0] = 1;
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * a[i - 1];
        }

        int rPrefix = 1;
        for (int i = len - 2; i >= 0; i--) {
            result[i] = result[i + 1] * rPrefix;
            rPrefix *= a[i + 1];
        }
        return result;
    }


    /**
     * 解法一 比较容易理解, 可以进一步优化, 合并两次 遍历
     *
     * @param a
     * @return
     */
    private int[] solution1(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] result = new int[len];

        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = a[i - 1] * left[i - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            right[i] = a[i + 1] * right[i + 1];
        }
        for (int i = 0; i < len; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
