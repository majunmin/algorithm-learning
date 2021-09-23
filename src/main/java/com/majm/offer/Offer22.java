package com.majm.offer;

import com.majm.common.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点 </br>
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-14 15:48
 * @since
 */
public class Offer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                throw new IllegalArgumentException();
            }
            fast = fast.next;
        }
        // 移动指针
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 快慢指针解法
     *
     * @param head
     * @param k
     * @return
     */
    private ListNode solution(ListNode head, int k) {
        // 异常处理
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i <= k; i++) {
            if (fast == null) {
                throw new IllegalArgumentException();
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}