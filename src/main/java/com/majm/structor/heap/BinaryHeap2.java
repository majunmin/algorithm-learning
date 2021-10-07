package com.majm.structor.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * exercise </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-04 10:07
 * @since
 */
public class BinaryHeap2 {

    private int size;
    private int[] heap;
    // 度
    private int d;

    public BinaryHeap2(Integer capacity, int d) {
        this.heap = new int[capacity];
        Arrays.fill(this.heap, -1);
        this.d = d;
    }

    public BinaryHeap2(Integer capacity) {
        this(capacity, 2);
    }

    public boolean isFull() {
        return this.size == heap.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void insert(int num) {
        if (isFull()) {
            throw new NoSuchElementException("Heap is Full, No  space to insert new element!");
        }
        this.heap[size++] = num;
        heapifyUp(size - 1);
    }

    private void heapifyUp(int idx) {
        while (true) {
            if (idx == 0 || heap[parent(idx)] <= heap[idx]) {
                break;
            }
            swap(idx, parent(idx));
            idx = parent(idx);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * 根据索引删除元素
     */
    public int delete(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty, no element to delete!");
        }

        // find element
        int val = heap[index];
        heap[index] = heap[--size];
        heapifyDown(index);
        return val;
    }

    private void heapifyDown(int index) {
        while (true) {
            int child = findMinChild(index);
            if (heap[index] <= heap[child]) {
                break;
            }
            swap(index, child);
            index = child;
        }
    }

    private int findMinChild(int p) {
        // self
        int minPos = p;
        int child = p;
        for (int i = 1; i <= d; i++) {
            if ((child = kthChild(p, i)) >= size) {
                break;
            }
            if (heap[child] < heap[minPos]) {
                minPos = child;
            }
        }
        return minPos;
    }

    public int findMax() {
        return heap[0];
    }

    public int parent(int child) {
        return (child - 1) / d;
    }

    public int kthChild(int p, int k) {
        return p * d + k;
    }

    public static void main(String[] args) {

        BinaryHeap2 binaryHeap = new BinaryHeap2(16);
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

        System.out.print(binaryHeap.delete(binaryHeap.size - 1));
        System.out.print(binaryHeap.delete(binaryHeap.size - 1));
        System.out.print(binaryHeap.delete(binaryHeap.size - 1));
        System.out.print(binaryHeap.delete(binaryHeap.size - 1));
        System.out.print(binaryHeap.delete(binaryHeap.size - 1));
        System.out.print(binaryHeap.delete(binaryHeap.size - 1));
        System.out.print(binaryHeap.delete(binaryHeap.size - 1));
        System.out.print(binaryHeap.delete(binaryHeap.size - 1));
        System.out.print(binaryHeap.delete(binaryHeap.size - 1));

    }


}
