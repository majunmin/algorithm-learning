package com.majm;

import java.util.ArrayList;
import java.util.List;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-22 21:38
 * @since
 */
public class YsfCycle {

    private static class ListNode {
        private Integer val;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(Integer val) {
            this.val = val;
        }
    }

    /**
     * 链表反射i解决
     *
     * @param n
     * @param m
     * @return
     */
    public int ysfListNode(int n, int m) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        for (int i = 1; i <= n; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        head.next = prev.next;

        while (n > 1) {
            for (int i = 1; i <= m - 1; i++) {
                head = head.next;
            }
            head.next = head.next.next;
            n = n - 1;
        }
        return head.val;
    }

    /**
     * 数组实现
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param n
     * @param m
     * @return
     */
    public int ysfArr(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % list.size();
            list.remove(idx);
            n -= 1;
        }

        return list.get(0);
    }
}

