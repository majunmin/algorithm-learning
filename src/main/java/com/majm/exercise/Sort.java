package com.majm.exercise;

import java.util.Arrays;

/**
 * 堆排序练习 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-24 12:13
 * @since
 */
public class Sort {

    /**
     * 快排序
     *
     * @param arr
     */
    public void quickSort(int[] arr) {
        // 分治思想
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private void quickSortHelper(int[] arr, int left, int right) {
        // terminate
        if (left >= right) {
            return;
        }
        // 寻找基准位置
        int pivot = partition(arr, left, right);

        quickSortHelper(arr, left, pivot - 1);
        quickSortHelper(arr, pivot + 1, right);
    }

    /**
     * 返回 pivot,
     * pivot 左边的值 都小于  pivot 的值
     * pivot 右边的值 都大于  pivot 的值
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        // cnt 指向 第一个大于 pivot的值
        int cnt = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, cnt++);
            }
        }
        swap(arr, cnt, right);
        return cnt;
    }


    /**
     * 堆排序
     *
     * @param arr
     */
    public void heapSort(int[] arr) {
        int n = arr.length;
        // 1. init a heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(arr, n, i);
        }
        // swap
        for (int i = n; i > 0; i--) {
            swap(arr, 0, i - 1);
            heapifyDown(arr, i - 1, 0);
        }


        // retrurn result

    }

    private void heapifyDown(int[] arr, int n, int i) {
        while (true) {
            int maxPos = i;
            int lChild = lChild(i);
            int rChild = rChild(i);
            if (lChild < n && arr[lChild] > arr[maxPos]) {
                maxPos = lChild;
            }
            if (rChild < n && arr[rChild] > arr[maxPos]) {
                maxPos = rChild;
            }
            // terminate
            if (maxPos == i) {
                return;
            }
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    private int rChild(int i) {
        return i * 2 + 2;
    }

    private int lChild(int i) {
        return i * 2 + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = {1, 6, 9, 2, 4, 6, 9, 4, 1};
        sort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序
     *
     * @param arr
     */
    private void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private void mergeSortHelper(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSortHelper(arr, left, mid);
        mergeSortHelper(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * 合并两个有有序数组
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[cnt++] = arr[i++];
            } else {
                temp[cnt++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[cnt++] = arr[i++];
        }
        while (j <= right) {
            temp[cnt++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, left, right - left + 1);
    }

}
