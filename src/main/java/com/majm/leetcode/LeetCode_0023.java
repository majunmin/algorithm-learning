package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * </br>
 * <p>
 * <p>
 * 1.先把最小化问题找出来  合并两个有序链表
 * <p>
 * 方法一  逐个迭代:  如果有 n个链表,合并n次
 * 方法二:  分支合并,  合并次数为 n /2
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-30 21:14
 * @since
 */
public class LeetCode_0023 implements Solution {

    @Override
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        return mergeKLists(lists, 0, len - 1);
    }


    /**
     * 利用最小堆的思想
     * - 取出 前十名...
     *
     * @param lists
     * @return
     */
    private ListNode priorityQueueSolution(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode dummyNode = new ListNode();
        ListNode prev = dummyNode;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
            prev.next = minNode;
            prev = prev.next;
        }
        return dummyNode.next;
    }

    /**
     * 方法三 利用优先级队列(最小堆)
     * 这种思想还是比较常见的
     *
     * @param lists
     * @return
     */
    private ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        final Queue<Pair> pq = new PriorityQueue<>();
        for (ListNode node : lists) {
            pq.offer(new Pair(node.val, node));
        }

        final ListNode dummyNode = new ListNode();
        ListNode prev = dummyNode;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            ListNode curNode = pair.node;
            prev.next = curNode;
            prev = prev.next;
            if (curNode.next != null) {
                curNode = curNode.next;
                pq.offer(new Pair(curNode.val, curNode));
            }
        }
        return dummyNode.next;
    }

    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;


        ListNode l1 = mergeKLists(lists, left, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, right);
        return mergeHelper(l1, l2);
    }

    private ListNode mergeHelper(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val >= l2.val) {
            l2.next = mergeHelper(l1, l2.next);
            return l2;
        }
        l1.next = mergeHelper(l1.next, l2);
        return l1;
    }

    private static class Pair implements Comparable<Pair> {
        private Integer val;
        private ListNode node;

        public Pair(Integer val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        @Override
        public int compareTo(Pair p) {
            return this.val - p.val;
        }
    }
}
