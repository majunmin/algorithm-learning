package com.majm.offer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/31 10:02 上午
 * @since
 */
public class Offer40 {

    /**
     * 1. 排序后找出  Arrays.sort()   NlogN
     * 2. 堆排序 NlogK
     * <p>
     * 3. quick sort:
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // 因为 结果没有说 要求有序,所以可以利用快排的特性
        int[] result = new int[k];
        quickSort(result, 0, arr.length - 1);
        return result;
    }

    private void quickSort(int[] result, int left, int right) {

    }

    /**
     * 使用 java 的 PriorityQueue
     * 时间复杂度：O(Nlogk)
     * 空间复杂度： O(k)
     *
     * @param arr
     * @param k
     * @return
     */
    private int[] solution1(int[] arr, int k) {
        // 默认为 小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int ele : arr) {
            heap.add(ele);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}
