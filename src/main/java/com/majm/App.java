package com.majm;

import com.majm.letcode.LetCode66;

import java.util.Arrays;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/20 2:37 下午
 * @since
 */
public class App {

    public static void main(String[] args) {
        Solution solution = new LetCode66();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9, 9, 9})));
    }
}
