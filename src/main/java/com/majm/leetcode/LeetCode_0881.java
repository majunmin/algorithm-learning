package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;

/**
 * 881. 救生艇 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-07 14:51
 * @since
 */
public class LeetCode_0881 implements Solution {

    @Override
    public int numRescueBoats(int[] people, int limit) {
        return solution1(people, limit);
    }


    /**
     * 贪心算法
     *
     * @param people
     * @param limit
     * @return
     */
    private int solution2(int[] people, int limit) {
        int result = 0;
        Arrays.sort(people);
        int len = people.length;
        int left = 0;
        int right = len - 1;
        // 最后 只剩下一个人  left == right,独自坐一条船
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;

            }
            right--;
            result++;

        }
        return result;
    }


    /**
     * 后序怎么解?
     *
     * @param people
     * @param limit
     * @return
     */
    private int solution1(int[] people, int limit) {
        Arrays.sort(people);
        int midVal = (limit + 1) / 2;
        int r = 0;
        int len = people.length;
        for (int i = 0; i < len; i++) {
            r = i;
            if (people[i] >= midVal) {
                break;
            }
        }

        int result = 0;
        int l = r - 1;
        while (l >= 0 && r < len) {
            if (people[l] + people[r] > limit) {
                break;
            }
            l--;
            r++;
        }
        result = (r - l + 1) / 2;
        if (l > 0) {
            result += l / 2;
        }
        if (r < len - 1) {
            result += len - 1 - r;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0881();
        System.out.println(leetCode.numRescueBoats(new int[]{1, 2}, 5));
    }
}
