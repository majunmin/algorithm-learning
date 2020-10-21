package com.majm;

import com.majm.letcode.LeetCode1;

import java.util.Arrays;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/20 2:37 下午
 * @since
 */
public class App {

    public static void main(String[] args) {
        Solution solution = new LeetCode1();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6)));
    }
}
