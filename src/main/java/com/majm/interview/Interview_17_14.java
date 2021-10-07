package com.majm.interview;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * 面试题 17.14. 最小K个数 </br>
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-03 10:04
 * @since
 */
public class Interview_17_14 {

    public int[] smallestK(int[] arr, int k) {
        randomSelected(arr, 0, arr.length - 1, k);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;

    }

    /**
     * 从 arr[left, right] 范围中 寻找 最小的 前 k个数
     * 能用 快排优化的原因是  输出结果 不要求有顺序
     *
     * @param arr
     * @param left
     * @param right
     * @param k
     */
    private void randomSelected(int[] arr, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int pos = randomPaitotion(arr, left, right);
        int num = pos - left + 1;
        if (num == k) {
            return;
        } else if (num > k) {
            randomSelected(arr, left, pos - 1, k);
        } else {
            randomSelected(arr, pos + 1, right, k - num);
        }
    }

    private int randomPaitotion(int[] arr, int left, int right) {
        int incr = new Random().nextInt(right - left);
        swap(arr, left + incr, right);
        return partition(arr, left, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = right;
        // cnt 指向 第一个 大于  arr[pivot] 的 index
        int cnt = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, cnt, i);
                cnt++;
            }
        }
        swap(arr, cnt, pivot);
        return cnt;
    }


    /**
     * Java 优先级队列   堆排序
     *
     * @param arr
     * @param k
     * @return
     */
    private int[] heapSolution(int[] arr, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            pq.add(num);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }


    private int[] sortSolution(int[] arr, int k) {
        if (k == 0) {
            return new int[]{};
        }
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    /**
     * quickSort
     *
     * @param arr
     * @param k
     * @return
     */
    private int[] sortSolution2(int[] arr, int k) {
        if (k == 0) {
            return new int[]{};
        }
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOfRange(arr, 0, k);
    }

    private void quickSort(int[] arr, int left, int right) {
        // terminate
        if (left >= right) {
            return;
        }
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid + 1, right);
    }


    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
