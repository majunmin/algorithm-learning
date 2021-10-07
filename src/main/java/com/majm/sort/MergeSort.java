package com.majm.sort;

import java.util.Arrays;

/**
 * 归并排序 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-03 16:32
 * @since
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        mergeSortHelper(arr, left, right);
    }

    private void mergeSortHelper(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSortHelper(arr, left, mid);
        mergeSortHelper(arr, mid + 1, right);
        // 合并两个有序数组  left - mid,  mid+1 -> right
        merge(arr, left, mid, right);
    }


    /**
     * mergeSort 合并两个有序数组
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private void merge(int[] arr, int left, int mid, int right) {
        int l1 = left;
        int l2 = mid + 1;

        int tempLen = right - left + 1;
        int[] temparr = new int[tempLen];
        int idx = 0;
        while (l1 <= mid && l2 <= right) {
            temparr[idx++] = arr[l1] <= arr[l2] ? arr[l1++] : arr[l2++];
        }

        if (l1 <= mid) {
            System.arraycopy(arr, l1, temparr, idx, mid - l1 + 1);
        }
        if (l2 <= right) {
            System.arraycopy(arr, l2, temparr, idx, right - l2 + 1);
        }
        System.arraycopy(temparr, 0, arr, left, tempLen);
    }

    public static void main(String[] args) {
        final Sort mergeSort = new MergeSort();
        int[] nums = new int[]{3, 5, 9, 7, 10, 8};
        mergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
