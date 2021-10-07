package com.majm.leetcode;

import com.majm.Solution;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. 杨辉三角 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-31 08:57
 * @since
 */
public class LeetCode_0118 implements Solution {

    /**
     * @param numRows
     * @return
     */
    @Override
    public List<List<Integer>> generate(int numRows) {
        return solution2(numRows);
    }

    private List<List<Integer>> solution2(int numRows) {
        if (numRows < 1) {
            throw new IllegalArgumentException("param error");
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        if (numRows == 1) {
            return result;
        }
        result.add(Arrays.asList(1, 1));
        if (numRows == 2) {
            return result;
        }

        List<Integer> prev = result.get(1);
        // a[i][k] = a[i-1][k-1] + a[i-1][k]
        for (int i = 2; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(prev.get(j - 1) + prev.get(j));
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }


    /**
     * @param numRows
     * @return
     */
    private List<List<Integer>> solution1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        if (numRows == 1) {
            return result;
        }
        result.add(Arrays.asList(1, 1));
        if (numRows == 2) {
            return result;
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            temp.add(1);
            List<Integer> prev = result.get(i - 1);
            for (int j = 1; j < prev.size(); j++) {
                temp.add(j, prev.get(j) + prev.get(j - 1));
            }
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0118();
        leetCode.generate(5);
    }
}
