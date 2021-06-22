package com.majm;

import org.apache.commons.lang3.StringUtils;

/**
 * 堆排序 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-01 15:30
 * @since
 */
public class HeapSort {

    public void sort(int[] array) {
        int n = array.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapifyDown(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapifyDown(array, i, 0);
        }
    }

    private void heapifyDown(int[] array, int n, int i) {
        int largest = i; // init largest is root
        int l = i * 2 + 1;
        int r = i * 2 + 2;

        if (l < n && array[l] > array[largest]) {
            largest = l;
        }

        if (r < n && array[r] > array[largest]) {
            largest = r;
        }

        // swap  ensure  root val is largest than child
        if (largest != i) {
            int temp = array[largest];
            array[largest] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 12, 11, 13, 5, 6, 7 };
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
