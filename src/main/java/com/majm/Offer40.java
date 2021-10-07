package com.majm;

import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-29 10:39
 * @since
 */
public class Offer40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int left, int right, int k) {
        // terminate
        if (left >= right) {
            return;
        }
        // find 分区点
        int partition = partition(arr, left, right);
        int pos = partition - left + 1;
        if (pos == k) {
            return;
        } else if (pos > k) {
            quickSort(arr, left, partition - 1, k);
        } else {
            quickSort(arr, partition + 1, right, k - pos);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int cnt = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, cnt, i);
                cnt++;
            }
        }
        swap(arr, cnt, right);
        return cnt;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        final Offer40 offer40 = new Offer40();
        System.out.println(Arrays.toString(offer40.getLeastNumbers(new int[]{3, 5, 9, 1, 4, 6}, 3)));
        System.out.println(Arrays.toString(offer40.getLeastNumbers(new int[]{0, 1, 1, 1, 4, 5, 3, 7, 7, 8, 10, 2, 7, 8, 0, 5, 2, 16, 12, 1, 19, 15, 5, 18, 2, 2, 22, 15, 8, 22, 17, 6, 22, 6, 22, 26, 32, 8, 10, 11, 2, 26, 9, 12, 9, 7, 28, 33, 20, 7, 2, 17, 44, 3, 52, 27, 2, 23, 19, 56, 56, 58, 36, 31, 1, 19, 19, 6, 65, 49, 27, 63, 29, 1, 69, 47, 56, 61, 40, 43, 10, 71, 60, 66, 42, 44, 10, 12, 83, 69, 73, 2, 65, 93, 92, 47, 35, 39, 13, 75}, 75)));
    }
}
