package com.majm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数 </br>
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-14 16:11
 * @since
 */
public class Offer56_1 {


    /**
     * 位运算
     * 需要前置知识:
     * a ^ a = 0
     * a ^ b ^ c = (a ^ b) ^ c = a ^ (b ^ c) // 组合律
     * a ^ b ^ c = a ^ c ^ b = b ^ c ^ a  // 交换律
     * <p>
     * 可以得出: 2 ^ 7 ^ 7 = 2
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException();
        }
        // 全员异或
        int pivot = 0;
        for (int num : nums) {
            pivot ^= num;
        }
        // 将  两个不同的数组分组
        // 找到 pivot 第一个 1 的位置根据 m 区分两个 不同的数字 x y
        // pivot 第一个1 的位置: 意味着 x  and y 在该位上 不同,以此来区分
        int x = 0;
        int y = 0;
        int m = pivot & -pivot;
        // a ^ a = 0
        //
        for (int item : nums) {
            if ((item ^ m) == 1) {
                x ^= item;
            } else {
                y ^= item;
            }
        }
        return new int[]{x, y};
    }

    private int[] hashSolution(int[] nums) {
        // 用一个 hash 计数, 出现两次 +1 -1, 最后map里面剩下的就是result
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(i -> {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        });
        return set.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        final Offer56_1 offer = new Offer56_1();
        System.out.println(offer.singleNumbers(new int[]{4, 1, 6, 4}));
    }
}
