package com.majm.offer;

/**
 * 剑指 Offer 11. 旋转数组的最小数字 </br>
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-17 19:59
 * @since
 */
public class Offer11 {


    /**
     * 基准数 需要是  nums[right]
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            // 使用 numbers[right] 作为基准值 方便判断哪
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                // 最小值在 (mid, right] 之间
                left = mid + 1;
            } else if (numbers[mid] == numbers[right]) {
                // 不确定最小值在哪里
                right--;
            } else {
                // 最小值 在  [left, mid]
                right = mid;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        Offer11 offer = new Offer11();
        System.out.println(offer.minArray(new int[]{10,1,10,10,10}));
    }
}

