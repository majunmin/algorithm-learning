package com.majm.sort;

import java.util.Arrays;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-03 16:54
 * @since
 */
public class BinaryHeap<T extends Comparable<T>> {

    private T[] array;

    private int heapSize;
    private int d = 2; // 度

    private boolean isMaxHeap; // 是否是大顶堆


    public BinaryHeap() {
        this(100);
    }

    public BinaryHeap(int heapSize) {
        this(heapSize, true);
    }

    public BinaryHeap(int heapSize, boolean isMaxHeap) {
        this(heapSize, isMaxHeap, 2);
    }

    public BinaryHeap(int heapSize, boolean isMaxHeap, int d) {
        this.array = (T[]) new Integer[heapSize];
        this.d = d;
        this.isMaxHeap = isMaxHeap;
    }

    public boolean isFull() {
        return array.length == heapSize;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public void insert(T data) {
        if (isFull()) {
            throw new RuntimeException("heap is full!");
        }
        array[heapSize] = data;
        heapifyUp(heapSize);
        heapSize++;
    }

    private void heapifyUp(int idx) {
        int p = parent(idx);
        if (p >= 0 && ((isMaxHeap && array[p].compareTo(array[idx]) < 0) || (!isMaxHeap && array[p].compareTo(array[idx]) > 0))) {
            swap(idx, p);
            heapifyUp(p);
        }
    }

    public T delete(int idx) {
        if (isEmpty() || idx >= heapSize) {
            throw new RuntimeException("heap is empty!");
        }

        T element = array[idx];
        array[idx] = array[--heapSize];
        heapifyDown(idx);
        return element;
    }

    private void heapifyDown(int idx) {
        int largest = idx;

        for (int i = 0; i < d; i++) {
            int kChild = kthChild(idx, i);
            if (kChild < heapSize && ((isMaxHeap && array[kChild].compareTo(array[idx]) < 0) || (!isMaxHeap && array[kChild].compareTo(array[idx]) > 0))) {
                largest = kChild;
            }
        }

        if (largest != idx) {
            swap(largest, idx);
            heapifyDown(largest);
        }
    }

    /**
     * 索引为 i 的kth子节点的索引
     *
     * @param i
     * @param k
     * @return
     */
    private int kthChild(int i, int k) {
        return d * i + k;
    }

    private int parent(int i) {
        return (i - 1) / d;
    }


    public void printHeap() {
        System.out.print("heap = ");
        System.out.println(Arrays.toString(array));

    }


    private void swap(int j, int i) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        System.out.println(-1 / 2);

        BinaryHeap<Integer> binaryHeap = new BinaryHeap(16, false);
        binaryHeap.insert(0);
        binaryHeap.insert(0);
        binaryHeap.insert(1);
        binaryHeap.insert(3);
        binaryHeap.insert(4);
        binaryHeap.insert(5);
        binaryHeap.insert(0);
        binaryHeap.insert(7);
        binaryHeap.insert(6);
        binaryHeap.insert(7);

        binaryHeap.printHeap();
        System.out.print(binaryHeap.delete(binaryHeap.heapSize - 1));
        System.out.print(binaryHeap.delete(binaryHeap.heapSize - 1));
        System.out.print(binaryHeap.delete(binaryHeap.heapSize - 1));
        System.out.print(binaryHeap.delete(binaryHeap.heapSize - 1));
        System.out.print(binaryHeap.delete(binaryHeap.heapSize - 1));
        System.out.print(binaryHeap.delete(binaryHeap.heapSize - 1));
        System.out.print(binaryHeap.delete(binaryHeap.heapSize - 1));
        System.out.print(binaryHeap.delete(binaryHeap.heapSize - 1));
        System.out.print(binaryHeap.delete(binaryHeap.heapSize - 1));

    }

}
