package com.majm.letcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/28 5:28 下午
 * @since
 */
public class LeetCode49 implements Solution {

    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
        return solution3(strs);
    }

    /**
     * 时间复杂度 O(NK)
     * 空间复杂度 O(NK)
     * @param strs
     * @return
     */
    private List<List<String>> solution3(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List<String>> res = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sBuilder = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sBuilder.append('#');
                sBuilder.append(count[i]);
            }

            String convertStr = sBuilder.toString();
            res.putIfAbsent(convertStr, new ArrayList<>());
            res.get(convertStr).add(str);
        }
        return new ArrayList<>(res.values());
    }

    /**
     * hash 表
     * 时间复杂度: O(NKlog(K)) N：strs长度  K:strs中最长的字符串长度
     * 空间复杂度: O(NK)
     * @param strs
     * @return
     */
    private List<List<String>> solution2(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            // O(NlogN)
            Arrays.sort(chars);
            String sortedStr = Arrays.toString(chars);
            if (!res.containsKey(sortedStr)){
                res.put(sortedStr, new ArrayList<>());
            }
            res.get(sortedStr).add(str);

        }
        return new ArrayList<>(res.values());
    }


    private List<List<String>> solution1(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            if (result.isEmpty()) {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                result.add(strList);
                continue;
            }
            boolean find = false;
            for (List<String> strList : result) {
                if (isAnagrams(str, strList.get(0))) {
                    strList.add(str);
                    find = true;
                    break;
                }
            }
            if (!find) {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                result.add(temp);
            }
        }
        return result;
    }
    public boolean isAnagrams(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 字母对应索引的计数
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            nums[sc - 'a']++;
            nums[tc - 'a']--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
