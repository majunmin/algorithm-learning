package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-01 09:31
 * @sincehash
 */
public class LeetCode_0119 implements Solution {

    @Override
    public List<Integer> getRow(int rowIndex) {

        if (rowIndex == 0) {
            return Arrays.asList(1);
        }
        if (rowIndex == 1) {
            return Arrays.asList(1, 1);
        }
        // init
        List<Integer> path = Arrays.asList(1, 1);
        List<Integer> prev;
        for (int i = 2; i <= rowIndex; i++) {
            prev = path;
            path = new ArrayList<>();
            path.add(1);
            path.add(1);
            for (int j = 1; j < i; j++) {
                path.add(j, prev.get(j - 1) + prev.get(j));
            }
        }
        return path;
    }
}
