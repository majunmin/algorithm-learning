package com.majm.offer;

import com.majm.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字 </br>
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-23 14:34
 * @since
 */
public class Offer62 {

    /**
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        return arrSolution(n, m);
    }

    private int arrSolution(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (list.size() != 1) {
            idx = (idx + m - 1) % list.size();
            list.remove(idx);
        }
        return list.get(0);
    }

    /**
     * 链表解法
     *
     * @param n
     * @param m
     * @return
     */
    private int listSolution(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException();
        }
        ListNode head = new ListNode();
        // build cycle list
        ListNode prev = head;
        for (int i = 0; i < n; i++) {
            prev.next = new ListNode(i);
            prev = prev.next;
        }
        prev.next = head.next;

        // remove
        while (prev.next != prev) {
            for (int i = 0; i < m; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
        }
        return prev.val;
    }

    public static void main(String[] args) {
        final Offer62 offer = new Offer62();
        System.out.println(offer.listSolution(5, 3));
    }


}
