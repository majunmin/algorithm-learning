package com.majm;

import com.majm.letcode.LeetCode1;
import com.majm.letcode.LeetCode15;

import java.util.Arrays;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/20 2:37 下午
 * @since
 */
public class App {

    public static void main(String[] args) {
        Solution solution = new LeetCode15();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
