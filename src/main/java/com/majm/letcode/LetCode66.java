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

    /**
     * 从右往左遍历
     * 1. 如果当前位置 != 9， 则 当前位置 +1 返回
     * 2. 如果当前位置 = 9，将当前位置 = 0,遍历下一位置
     * 3. 如果遍历到头, 则将重新建一个数组,首位=1
     * @param digits
     * @return
     */
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
