package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/9 11:42 下午
 * @since
 */
public class LeetCode443 implements Solution {

    private int minStepCount = Integer.MAX_VALUE;

    @Override
    public int minMutation(String start, String end, String[] bank) {

        return solution2(start, end, bank);
    }


    /**
     * 广度优先遍历
     *
     * 时间复杂度:
     * 空间复杂度:
     * @param start
     * @param end
     * @param bank
     * @return
     */
    private int solution2(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)){
            return -1;
        }


        Map<Character, char[]> charMap = new HashMap<>();
        charMap.put('A', new char[]{'T', 'C', 'G'});
        charMap.put('T', new char[]{'A', 'C', 'G'});
        charMap.put('C', new char[]{'A', 'T', 'G'});
        charMap.put('G', new char[]{'A', 'T', 'C'});

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                char[] charArray = queue.poll().toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    char oldChar = charArray[j];
                    char[] choices = charMap.get(charArray[j]);
                    for (char choice : choices) {
                        charArray[j] = choice;
                        String curState = new String(charArray);
                        if (end.equals(curState)) {
                            return step;
                        } else if (bankSet.contains(curState)){
                            bankSet.remove(curState);
                            queue.offer(curState);
                        }
                    }
                    charArray[j] = oldChar;
                }
            }
        }
        return -1;
    }


    /**
     * 深度优先搜索
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int solution1(String start, String end, String[] bank) {
        dfs(new ArrayList<>(), 0, start, end, bank);
        return minStepCount == Integer.MAX_VALUE ? -1 : minStepCount;
    }

    private void dfs(List<String> visited, int depth, String current, String end, String[] bank) {
        if (current.equals(end)) {
            minStepCount = Math.min(minStepCount, depth);
        }


        for (String str : bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) {
                if (current.charAt(i) != str.charAt(i)) {
                    if (++diff > 1) {
                        break;
                    }
                }
            }

            if (diff == 1 && !visited.contains(str)) {
                visited.add(str);
                dfs(visited, depth + 1, str, end, bank);
                visited.remove(str);
            }
        }
    }

}
