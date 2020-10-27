package com.majm;

import com.majm.letcode.LeetCode1;
import com.majm.letcode.LeetCode15;
import com.majm.letcode.LeetCode26;
import com.majm.letcode.LeetCode42;
import com.majm.letcode.Leetcode155;
import com.majm.letcode.Leetcode84;

import java.util.Arrays;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/20 2:37 下午
 * @since
 */
public class App {

    public static void main(String[] args) {
        Solution solution = new LeetCode42();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
