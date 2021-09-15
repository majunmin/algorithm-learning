package com.majm.offer;


/**
 * 剑指 Offer 05. 替换空格 </br>
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-15 09:24
 * @since
 */
public class Offer05 {


    public String replaceSpace(String s) {
        return solution4(s);
    }

    /**
     * 数组
     * 1. 先遍历一遍 找到 ' ' 的数量 n， 可以计算出 结果的 长度 = s.length + n * 2
     * 2. 字符拼接
     *
     * @param s
     * @return
     */
    private String solution4(String s) {
        final char[] chars = s.toCharArray();
        int cnt = 0;
        for (char c : chars) {
            if (c == ' ') {
                cnt++;
            }
        }
        char[] result = new char[s.length() + cnt * 2];
        cnt = 0;
        for (char c : chars) {
            if (c == ' ') {
                result[cnt++] = '%';
                result[cnt++] = '2';
                result[cnt++] = '0';
            } else {
                result[cnt++] = c;
            }
        }
        return new String(result);
    }

    /**
     * 优点浪费空间
     * 时间复杂度O(N)
     * 空间复杂度 O(N)
     * <p>
     * 因为 StringBuilder 的 方式有扩容，可能会浪费些许性能
     * 所以 这里使用数组优化
     *
     * @param s
     * @return
     */
    private String solution3(String s) {
        char[] result = new char[s.length() * 3];
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (' ' == c) {
                result[cnt++] = '%';
                result[cnt++] = '2';
                result[cnt++] = '0';
            } else {
                result[cnt++] = c;
            }
        }
        return new String(result, 0, cnt);
    }

    private String solution2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (' ' == c) {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
