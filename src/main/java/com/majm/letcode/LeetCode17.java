package com.majm.letcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/7 11:45 上午
 * @since
 */
public class LeetCode17 implements Solution {

    public static Map<Character, char[]> map = new HashMap<>();

    static {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    @Override
    public List<String> letterCombinations(String digits) {

        return solution3(digits);
    }

    /**
     * 递归的方式
     *
     * 时间复杂度: O()
     * 空间复杂度: O()
     *
     * @param digits
     * @return
     */
    private List<String> solution3(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList();
        }
        List<String> result = new ArrayList<>();
        dfs("", digits, result, 0);
        return result;
    }

    private void dfs(String path, String digits, List<String> result, int idx) {
        // terminate
        if (idx == digits.length()) {
            result.add(path);
            return;
        }
        char[] chars = map.get(digits.charAt(idx));
        for (char c : chars) {
            dfs(path + c, digits, result, idx + 1);
        }
    }

    /**
     * 队列的方式 解决 类似 广度优先遍历
     * 时间复杂度:   O(3^m * 4^n)
     * 空间内复杂度: O(3^m * 4^n)
     *
     * @param digits
     * @return
     */
    private List<String> solution2(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        for (char numsChar : digits.toCharArray()) {
            int size = queue.size();
            while (size-- > 0) {
                String s = queue.poll();
                for (char c : map.get(numsChar)) {
                    queue.offer(s + c);
                }
            }
        }
        return new ArrayList<>(queue);
    }


    /**
     * 时间复杂度 O(3^m * 4^n)
     * 空间复杂度 O(m + n)   (递归调用的层数)
     * (m: 3 个字母的数字个数 n: 4个字母的数字个数)
     */
    public List<String> solution1(String digits) {
        List<String> result = new ArrayList<>();
        char[] numsChar = digits.toCharArray();
        backtrace(numsChar, new StringBuilder(), 0, result);
        return result;
    }

    /**
     * @param numsChar
     * @param sBuilder
     * @param depth
     * @param result
     */
    private void backtrace(char[] numsChar, StringBuilder sBuilder, int depth, List<String> result) {
        int len = numsChar.length;
        // terminate
        if (depth == len) {
            if (depth != 0) {
                result.add(sBuilder.toString());
            }
            return;
        }

        char[] choiceList = map.get(numsChar[depth]);
        for (char c : choiceList) {
            sBuilder.append(c);
            backtrace(numsChar, sBuilder, depth + 1, result);
            sBuilder.deleteCharAt(depth);
        }
    }
}
