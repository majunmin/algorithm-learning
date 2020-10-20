package com.majm.letcode;

import com.majm.Solution;

/**
 *
 * @author majunmin
 * @description
 * @datetime 2020/10/20 2:35 下午
 * @since
 */
public class LetCode66 implements Solution {

    @Override
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
