package com.majm.structor.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 * 参考: https://shimo.im/docs/Lw86vJzOGOMpWZz2/read
 *
 *
 * @author majunmin
 * @description
 * @datetime 2020/10/31 10:58 上午
 * @since
 */
public class BinaryHeap {

    private int heapSize;
    private int[] heap;
    // 度
    int d = 2;

    public BinaryHeap(int heapSize) {
        this.heapSize = 0;
        heap = new int[heapSize + 1];
        Arrays.fill(heap, -1);
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
    }

    public void insert(int num) {
        if (isFull()) {
            throw new NoSuchElementException("Heap is Full, No space to insert a new element");
        }
        heap[heapSize++] = num;
        heapifiUp(heapSize - 1);
    }

    /**
     *
     * @param idx 当前索引值
     */
    private void heapifiUp(int idx) {
        int insertVal = heap[idx];
        while (idx > 0 && insertVal > heap[parent(idx)]) {
            heap[idx] = heap[parent(idx)];
            idx = parent(idx);
        }
        heap[idx] = insertVal;
    }

    /**
     * 根据索引删除 元素
     * 1. 将堆尾元素放到当前删除元素的位置{idx}
     * 2. 然后依次向下替换(找左右孩子最大的替换上来)
     *
     * @param idx
     */
    public int delete(int idx) {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty, No element to delete");
        }

        int maxElement = heap[idx];
        heap[idx] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(idx);
        return maxElement;
    }

    private void heapifyDown(int idx) {
        int childMax;
        // 暂存 当前元素值
        int temp = heap[idx];
        while (child(idx, 1) < heapSize) {
            childMax = maxChild(idx);
            if (temp >= heap[childMax]) {
                break;
            }
            heap[idx] = heap[childMax];
            idx = childMax;
        }
        heap[idx] = temp;
    }

    /**
     * find 该节点两个子节点的最大的 索引
     * @param idx
     * @return
     */
    private int maxChild(int idx) {
        int leftChild = child(idx, 1);
        int rightChild = child(idx, 2);

        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }

    public void printHeap() {
        System.out.print("heap = ");
        System.out.println(Arrays.toString(heap));

    }

    public int parent(int idx){
        return (idx - 1) / d;
    }

    /**
     *
     * @param i index
     * @param k child 的 位置 1， 2
     * @return
     */
    public int child(int i, int k){
        return d * i + k;
    }

    public int findMax() {
        return heap[0];
    }

    public static void main(String[] args) {
        System.out.println(-1 / 2);

        BinaryHeap binaryHeap = new BinaryHeap(16);
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