package com.majm.niuke;

import java.util.Random;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/8cc4f31432724b1f88201f7b721aa391
 * 来源：牛客网
 * <p>
 * 给定一个无序数组arr, 找到数组中未出现的最小正整数
 * <p>
 * 例如:
 * arr = [-1, 2, 3, 4]  return 1
 * arr = [1, 2, 3, 4]  return 5
 * <p>
 * 【要求】: 时间复杂度为O(n)，空间复杂度为O(1)
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-28 23:01
 * @since
 */
public class NiuKe_MinNumDisAppear {

    /**
     * return the min number
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int minNumberdisappered(int[] arr) {
        // write code here
//        Arrays.sort(arr);
//        int min = 1;
//        int l = 0;
//        while (arr[l] < 0) {
//            l++;
//        }
//        while (l < arr.length) {
//            if (min == arr[l]) {
//                min++;
//            } else {
//                return min;
//            }
//            l++;
//        }
//        return min;

        int length = arr.length;

        for (int i = 0; i < length; i++) {
            if (arr[i] <= 0) {
                arr[i] = length + 1;
            }
        }

        //step 2 出现过的在对应的数组下标置负-

        for (int i = 0; i < length; i++) {
            int num = Math.abs(arr[i]);
            if (num <= length) {

                arr[num - 1] = -Math.abs(arr[num - 1]);

            }

        }
        ///step3  数组下标由小到大遍历出现第一个大于0 即未出现过的，即为最小数

        for (int i = 0; i < length; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;



}

    public static void main(String[] args) {
        final Random random = new Random();
        System.out.println(random.nextInt());
        final NiuKe_MinNumDisAppear demo = new NiuKe_MinNumDisAppear();
        System.out.println(demo.minNumberdisappered(new int[]{-1, 2, 3, 4}));
        System.out.println(demo.minNumberdisappered(new int[]{-1, 2, 3, 4}));
        System.out.println(demo.minNumberdisappered(new int[]{-1, 1, 2, 4}));
        System.out.println(demo.minNumberdisappered(new int[]{-1, 1, 2, 3, 4}));
    }
}
