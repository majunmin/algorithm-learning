package com.majm.sort;

import java.util.Arrays;

/**
 * 快拍 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-03 15:46
 * @since
 */
public class QuickSort implements Sort {


    @Override
    public void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        quickSortHelper(arr, left, right);
    }

    private void quickSortHelper(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition2(arr, left, right);

        quickSortHelper(arr, left, mid - 1);
        quickSortHelper(arr, mid + 1, right);
    }

    // 返回一个索引 , 值为 x,索引左边的数都小于 x, 索引优点的值都大于 x
    private int partition(int[] arr, int left, int right) {
        int pivot = right;
        int cnt = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < arr[pivot]) {
                // swap arr i <-> cnt
                swapVal(arr, cnt, i);
                cnt++;
            }

        }
        // swap  arr cnt - pivot
        swapVal(arr, pivot, cnt);
        return cnt;
    }


    // 返回一个索引 , 值为 x,索引左边的数都小于 x, 索引优点的值都大于 x
    private int partition2(int[] arr, int left, int right) {
        int pivot = left;
        int cnt = right;
        for (int i = right; i > left; i--) {
            if (arr[i] > arr[pivot]) {
                // swap arr i <-> cnt
                swapVal(arr, cnt, i);
                cnt--;
            }

        }
        // swap  arr cnt - pivot
        swapVal(arr, pivot, cnt);
        return cnt;
    }

    private void swapVal(int[] arr, int pivot, int cnt) {
        int temp = arr[cnt];
        arr[cnt] = arr[pivot];
        arr[pivot] = temp;
    }

    public static void main(String[] args) {
        final QuickSort quickSort = new QuickSort();
        int[] nums = new int[]{3, 5, 9, 7, 10, 8};
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
