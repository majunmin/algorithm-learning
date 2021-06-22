package com.majm;

/**
 * 二叉堆实现 </br>
 * (大顶堆)
 *
 * @author majunmin
 * @description
 * @datetime 2021-05-31 22:06
 * @since
 */
public class BinaryHeap {

    private int d = 2;
    private int heapSize;

    private int[] elements;

    public BinaryHeap(int capacity) {
        elements = new int[capacity];
    }

    public void add(int val) {
        int curIndex = heapSize;
        elements[heapSize++] = val;
        heapifyUp(curIndex);
    }

    private void heapifyUp(int curIndex) {
        while (curIndex > 0) {
            if (elements[curIndex] <= elements[parent(curIndex)]) {
                break;
            }
            int temp = elements[curIndex];
            elements[curIndex] = elements[parent(curIndex)];
            elements[parent(curIndex)] = temp;
            curIndex = parent(curIndex);
        }
    }

    /**
     * poll
     *
     * @return
     */
    public int poll() {
        if (heapSize == 0) {
            return -1;
        }
        int result = elements[0];
        int curIndex = 0;
        elements[curIndex] = elements[--heapSize];
        heapifyDown(curIndex);
        return result;

    }

    private void heapifyDown(int curIndex) {
        while (child(curIndex, d) <= heapSize) {
            int maxIndex = curIndex;
            for (int i = 1; i <= d; i++) {
                if (elements[child(curIndex, i)] > elements[maxIndex]) {
                    maxIndex = child(curIndex, i);
                }
            }
            if (maxIndex == curIndex) {
                break;
            }
            int temp = elements[curIndex];
            elements[curIndex] = elements[maxIndex];
            elements[maxIndex] = temp;
            curIndex = maxIndex;
        }
    }

    /**
     * delete by index
     *
     * @param index
     * @return
     */
    public int delete(int index) {
        if (index > heapSize){
            throw new IllegalArgumentException("index larger than  heapSize...");
        }
        int result = elements[index];
        elements[index] = elements[--heapSize];
        heapifyDown(index);
        return result;
    }

    public int parent(int index) {
        return (index - 1) / d;
    }

    public int child(int index, int nth) {
        return index * d + nth;
    }


    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(100);
        binaryHeap.add(10);
        binaryHeap.add(50);
        binaryHeap.add(80);
        binaryHeap.add(65);
        binaryHeap.add(99);
        binaryHeap.add(1);
        binaryHeap.add(45);

        System.out.println(binaryHeap.delete(1));
        System.out.println(binaryHeap.poll());
        System.out.println(binaryHeap.poll());
        System.out.println(binaryHeap.poll());
        System.out.println(binaryHeap.poll());
        System.out.println(binaryHeap.poll());
        System.out.println(binaryHeap.poll());
        System.out.println(binaryHeap.poll());
    }
}
