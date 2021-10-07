package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换 </br>
 * ZigZag
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-15 21:38
 * @since
 */
public class LeetCode_0006 implements Solution {

    @Override
    public String convert(String s, int numRows) {

        return solution2(s, numRows);
    }


    /**
     * 这个问题是对 代码功底的一个考验啊
     * 数组索引, 遍历的方向啊,   从上至下，又转向上, 由左至右
     *
     * @param s
     * @param numRows
     * @return
     */
    private String solution2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int len = s.length();
        int cnt = 0;
        int idx = 0;
        while (cnt < len) {
            while (idx < numRows && cnt < len) {
                rows.get(idx++).append(s.charAt(cnt++));
            }
            idx -= 2;
            while (idx >= 0 && cnt < len) {
                rows.get(idx--).append(s.charAt(cnt++));
            }
            idx += 2;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }


    /**
     * 用一个变量标记变向
     *
     * @param s
     * @param numRows
     * @return
     */
    private String solution1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        //从左到右遍历字符串, 将字符 添加到 合适的行, (要考虑一个变向的问题 Z)
        List<StringBuilder> rows = new ArrayList<>();
        // int rows
        int rowSize = Math.min(numRows, s.length());
        for (int i = 0; i < rowSize; i++) {
            rows.add(new StringBuilder());
        }
        int cnt = 0;
        int direct = 1;
        for (char c : s.toCharArray()) {
            rows.get(cnt).append(c);
            cnt += direct;
            // 变向
            if (cnt == s.length() || cnt == 0) {
                direct = (direct == 1) ? -1 : 1;
            }
        }
        // generate result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0006();
        System.out.println(leetCode.convert("PAYPALISHARING", 3));
    }
}
