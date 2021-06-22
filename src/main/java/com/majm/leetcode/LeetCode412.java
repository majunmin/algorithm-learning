package com.majm.leetcode;

import com.majm.Solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/29 1:28 下午
 * @since
 */
public class LeetCode412 implements Solution {

    @Override
    public List<String> fizzBuzz(int n) {
        return solution3(n);
    }

    private List<String> solution3(int n) {
        List<String> result = new LinkedList<>();
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "Fizz");
        hashMap.put(5, "Buzz");

        for (int i = 1; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            for (Integer key : hashMap.keySet()) {
                if (i % key == 0) {
                    builder.append(hashMap.get(key));
                }
            }
            if ("".equals(builder.toString())) {
                result.add(String.valueOf(i));
            } else {
                result.add(builder.toString());
            }
        }
        return result;
    }

    private List<String> solution2(int n) {
        List<String> result = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            String str = "";
            if (i % 3 == 0) {
                str += "Fizz";
            }
            if (i % 5 == 0) {
                str += "Buzz";
            }
            if ("".equals(str)) {
                result.add(String.valueOf(i));
            } else {
                result.add(str);
            }
        }
        return result;
    }

    /**
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param n
     * @return
     */
    private List<String> solution1(int n) {
        List<String> result = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

}
