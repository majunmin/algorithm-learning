package com.majm.sort;

import java.util.Arrays;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-03 16:53
 * @since
 */
public class HeapSort implements Sort {


    @Override
    public void sort(int[] arr) {

        int n = arr.length;
        // 初始化一个大顶堆,这个堆是初始的无序区
        for (int i = parent(n); i >= 0; i--) {
            heapifyDown(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapifyDown(arr, i, 0);
        }

    }

    /**
     * 堆向下化
     *
     * @param arr
     * @param n
     * @param i
     */
    private void heapifyDown(int[] arr, int n, int i) {

        int lChild = leftChild(i);
        int rChild = rightChild(i);
        int largest = i;

        if (lChild < n && arr[lChild] > arr[largest]) {
            largest = lChild;
        }
        if (rChild < n && arr[rChild] > arr[largest]) {
            largest = rChild;
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapifyDown(arr, n, largest);
        }
    }

    private void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int parent(int idx) {
        return (idx - 1) / 2;
    }

    private int leftChild(int idx) {
        return 2 * idx + 1;
    }

    private int rightChild(int idx) {
        return 2 * idx + 2;
    }


    public static void main(String[] args) {
        final Sort mergeSort = new HeapSort();
        int[] nums = new int[]{3, 5, 9, 7, 10, 8};
        mergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }


}
