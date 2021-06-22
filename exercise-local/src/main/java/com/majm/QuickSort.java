package com.majm;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-01 15:48
 * @since
 */
public class QuickSort {

    public void sort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        quickSortHelper(array, left, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivot = right;
        int cnt = left;
        for (int i = left; i < right; i++) {
            if (array[i] < array[pivot]) {
                cnt++;
                continue;
            }
            // swap val
            swapVal(array, cnt, i);
        }
        swapVal(array, cnt, pivot);
        return cnt;
    }

    private void swapVal(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void quickSortHelper(int[] array, int left, int right) {
        // 终止条件
        if (left >= right) {
            return;
        }
        // 找到基准值
        int idx = partition(array, left, right);

        quickSortHelper(array, left, idx - 1);
        quickSortHelper(array, idx + 1, right);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {8, 5, 1, 0, 10, 46, 37, 21};
        quickSort.sort(array);
        printArray(array);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
