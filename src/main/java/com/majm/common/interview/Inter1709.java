package com.majm.common.interview;

/**
 * 面试题 17.09. 第 k 个数
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 示例 1:
 *
 * 输入: k = 5
 *
 * 输出: 9
 *
 * @author majunmin
 * @description
 * @datetime 2020/11/9 6:06 下午
 * @since
 */
public class Inter1709 implements Interview {



    @Override
    public int getKthMagicNumber(int k) {
        return soluiton1(k);
    }


    /**
     * 不难发现，一个丑数总是由前面的某一个丑数 x3 / x5 / x7 得到。
     * 反过来说也是一样的，一个丑数 x3 / x5 / x7 就会得到某一个更大的丑数。
     *
     * ---> 合并有序线性表的问题
     *
     * 链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci/solution/di-k-ge-shu-jiu-shi-xiang-bu-tong-wei-he-san-zhi-z/
     *
     * @param k
     * @return
     */
    private int soluiton1(int k) {
        int index3 = 0;
        int index5 = 0;
        int index7 = 0;
        int[] ugly = new int[k];
        ugly[0] = 1;
        for (int i = 1; i < k; i++) {
            int uglyp3 = ugly[index3] * 3;
            int uglyp5 = ugly[index5] * 5;
            int uglyp7 = ugly[index7] * 7;

            int curUgly = Math.min(uglyp3, Math.min(uglyp5, uglyp7));
            ugly[i] = curUgly;
            if (curUgly == uglyp3) index3++;
            if (curUgly == uglyp5) index5++;
            if (curUgly == uglyp7) index7++;
        }
        return ugly[k];
    }
}
