package com.majm.leetcode;

import com.majm.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 两数之和的  进阶版本 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-07 21:57
 * @since
 */
public class LeetCode_1711 implements Solution {

    /**
     * 1. 0 <= deliciousness[i] <= 2^20
     * 2的幂是有限的 {2^0, 2^1, ....2^22}
     * 2. 相同的数字: 根据排列组合公式, 餐品的组合数是  n(n-1)/2
     * 3. 不同的数字:  餐品组合数(出现的次数)  乘积/2
     *
     * @param deliciousness
     * @return
     */
    @Override
    public int countPairs(int[] deliciousness) {
        return solution3(deliciousness);
    }
    /**
     * 边遍历 边统计
     *
     * @param deliciousness
     * @return
     */
    private int solution3(int[] deliciousness) {

        int MOD = (int) 1e9 + 7;
        int max = 1 << 22;
        int result = 0;
        Map<Integer, Integer> cache = new HashMap<>();
        for (int x : deliciousness) {
            for (int i = max; i >= 1; i >>= 1) {
                if (cache.containsKey(i - x)) {
                    result += cache.get(i - x);
                    if (result > MOD) {
                        result -= MOD;
                    }
                }
            }
            cache.put(x, cache.getOrDefault(x, 0) + 1);
        }
        return result;
    }


    /**
     * 时间复杂度:   O(NlogN)
     * 空间复杂度:   O(N)
     *
     * @param deliciousness
     * @return
     */
    private int solution2(int[] deliciousness) {
        int MOD = (int) 1e9 + 7;
        Map<Integer, Integer> cache = new HashMap<>();
        // 统计每一个数出现的次数
        for (int x : deliciousness) {
            cache.put(x, cache.getOrDefault(x, 0) + 1);
        }

        // 枚举所有 2 的幂
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= 22; i++) {
            set.add(1 << i);
        }

        long result = 0;
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            for (Integer pow : set) {
                if (cache.containsKey(pow - key)) {
                    if (pow - key == key) {
                        result += (long) val * (val - 1);
                    } else {
                        result += (long) val * cache.get(pow - key);
                    }
                }
            }
        }
        // 最后结果 /2
        return (int) ((result >> 1) % MOD);
    }

    private boolean powerOfTwo(int x) {
        return x != 0 && (x & (x - 1)) == 0;
    }


    /**
     * 朴素算法
     * 比较容易想到,时间复杂度 O(n^2)
     * <p>
     * 遍历 deliciousness 数组,
     *
     * @param deliciousness
     * @return
     */
    private int solution1(int[] deliciousness) {

//        int MOD = 1_000_000_007;
//        int length = deliciousness.length;
//        Map<Integer, Integer> cache = new HashMap<>();
//        long result = 0;
//        for (int i = 0; i < length; i++) {
//            int x = deliciousness[i];
//            for (Integer other : cache.keySet()) {
//                if (powerOfTwo(x + other)) {
//                    result += cache.get(other);
//                }
//            }
//            cache.put(x, cache.getOrDefault(x, 0) + 1);
//        }
//        return (int) (result % MOD);


        int MOD = 1_000_000_007;

        // cache 减少重新计算
        Map<Integer, Boolean> cache = new HashMap<>();

        int result = 0;
        for (int i = 0; i < deliciousness.length - 1; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                // judge is power of 2
                int delicious = deliciousness[i] + deliciousness[j];
                if (cache.containsKey(delicious)) {
                    result++;
                    continue;
                }
                int modDelicious = delicious % MOD;
                if (modDelicious != 0 && (modDelicious & (modDelicious - 1)) == 0) {
                    cache.put(delicious, Boolean.TRUE);
                    result++;
                }
            }
        }
        return result;


    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_1711();
        System.out.println(leetCode.countPairs(new int[]{1, 3, 5, 7}));
    }
}
