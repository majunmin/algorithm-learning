package com.majm.offer;

import com.majm.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点 </br>
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-24 08:39
 * @since
 */
public class Offer52 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode slow = solution2(headA, headB);
        if (slow == null) return null;
        return slow;
    }


    /**
     * 快慢指针解法
     * len(headA) = m  len(headB) = n
     * <p>
     * 时间复杂度: O(m + n)
     * 空间复杂度: O(1)
     *
     * @param headA
     * @param headB
     * @return
     */
    private ListNode solution2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 快慢指针解法
        ListNode fast = headA;
        ListNode slow = headB;
        // 终止条件 是 headA == headB 有交点,
        // 无焦点: headA == headB == null
        while (fast != slow) {
            fast = (fast == null) ? headB : fast.next;
            slow = (slow == null) ? headA : slow.next;
        }
        return slow;
    }

    /**
     * 双指针 + hash表解法
     * len(headA) = m  len(headB) = n
     * <p>
     * 时间复杂度: O(m + n)
     * 空间复杂度: O(m)
     */
    private ListNode hashSolution(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode l1 = headA;
        while (l1 != null) {
            set.add(l1);
            l1 = l1.next;
        }
        ListNode l2 = headB;
        while (l2 != null) {
            if (set.contains(l2)) {
                return l2;
            }
            l2 = l2.next;
        }
        return null;
    }
}
