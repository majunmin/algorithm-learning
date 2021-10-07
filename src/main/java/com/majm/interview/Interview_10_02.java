package com.majm.interview;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 10.02. 变位词组 </br>
 * https://leetcode-cn.com/problems/group-anagrams-lcci/
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-18 20:01
 * @since
 */
public class Interview_10_02 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        final Map<String, List<String>> cache = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : count) {
                stringBuilder.append(i);
            }
            final String key = stringBuilder.toString();
            cache.putIfAbsent(key, new ArrayList<>());
            cache.get(key).add(str);
        }


        cache.forEach((key, value) -> result.add(value));
        return result;
    }


    /**
     * hash字典表解法
     *
     * @param strs
     * @return
     */
    private List<List<String>> hashSolution(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        final Map<String, List<String>> cache = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            final List<String> list = cache.getOrDefault(key, new ArrayList<>());
            list.add(str);
            cache.put(key, list);
        }
        cache.forEach((key, value) -> result.add(value));
        return result;
    }

    public static void main(String[] args) {
        final Interview_10_02 interview = new Interview_10_02();
        System.out.println(interview.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
