package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Note:
 * 独一无二的出现次数
 *
 * @author majunmin
 * @description
 * @datetime 2020/10/28 3:52 下午
 * @since
 */
public class LeetCode1207 implements Solution {

    @Override
    public boolean uniqueOccurrences(int[] arr) {
        return solution3(arr);
    }

    private boolean solution3(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            while (i < arr.length - 1) {
                if (arr[i+1] == arr[i]) {
                    i++;
                    count++;
                } else {
                    break;
                }
            }
            if (set.contains(count)){
                return false;
            }
            set.add(count);
        }
        return true;
    }

    private boolean solution2(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i+1] == arr[i]) {
                count++;
                continue;
            }
            if (set.contains(count)){
                return false;
            }
            set.add(count);
            count = 1;
        }
        if (set.contains(count)){
            return false;
        }
        return true;
    }

    /**
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * @param arr
     * @return
     */
    private boolean solution1(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return map.values().size() == new HashSet(map.values()).size();
    }
}
