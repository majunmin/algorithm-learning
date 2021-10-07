package com.majm.offer;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数 </br>
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-29 22:38
 * @since
 */
public class Offer41 {

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(4);
        System.out.println(obj.findMedian());
        obj.addNum(5);
        System.out.println(obj.findMedian());
    }


}

/**
 * 用堆 来维护  中位数
 * <p>
 * 1. 建立两个  堆 heap
 * 左边是一个大顶堆A, 右边是一个 小顶堆B
 * 2. 大顶堆保存较小的一半, 长度 = N/2(N偶数) or length = (N + 1)/ 2(N 是奇数)
 * 3. 小顶堆保存较大的一半, 长度 = N/2(N偶数) or length = (N + 1)/ 2(N 是奇数)
 * <p>
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
 */
class MedianFinder {

    // 大顶堆
    private PriorityQueue<Integer> leftHeap;
    // 小顶堆
    private PriorityQueue<Integer> rightHeap;
    private int leftSize;
    private int rightSize;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        this.leftSize = 0;
        this.rightSize = 0;
        this.leftHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
        this.rightHeap = new PriorityQueue<>();
    }

    /**
     * 1. m == n : 向leftHeap 添加 num,
     * - 将num 插入 rightHeap,  将rightHeap 堆顶元素插入 leftHeap
     * 2. m != n: 想 rightHeap 添加num,
     * - 将num插入 leftHeap, 将 leftHeap 堆顶元素插入 rightHeap
     *
     * @param num
     */
    public void addNum(int num) {
        if (leftSize == rightSize) {
            rightHeap.offer(num);
            leftHeap.add(rightHeap.poll());
            leftSize++;
        } else {
            leftHeap.offer(num);
            rightHeap.add(leftHeap.poll());
            rightSize++;
        }
    }

    public double findMedian() {
        if (leftSize == 0) {
            return -1;
        }
        if (leftSize == rightSize) {
            return (leftHeap.peek().doubleValue() + rightHeap.peek().doubleValue()) / 2;
        }
        return leftHeap.peek().doubleValue();
    }
}
