package com.majm.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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


    public int[] singleNumbers(int[] nums) {
        return hashSolution(nums);
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
}
