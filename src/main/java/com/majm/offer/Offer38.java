package com.majm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer 38. 字符串的排列 </br>
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-10 12:51
 * @since
 */
public class Offer38 {
    public String[] permutation(String s) {
        List<String> result = new ArrayList<>();
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        backTrace("", charArr, new boolean[charArr.length], result);
        return result.toArray(new String[0]);
    }

    private void backTrace(String path, char[] charArr, boolean[] visited, List<String> result) {

        // terminate
        if (path.length() == charArr.length) {
            result.add(path);
            return;
        }

        // for choice in choiceList
        for (int i = 0; i < charArr.length; i++) {
            // ** 如果已经访问过 skip
            // 2.
            if (visited[i] ||
                    (i > 0 && !visited[i - 1] && charArr[i] == charArr[i - 1])) {
                continue;
            }
            visited[i] = true;
            backTrace(path + charArr[i], charArr, visited, result);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        final Offer38 offer = new Offer38();
        System.out.println(Arrays.toString(offer.permutation("aab")));
    }
}
