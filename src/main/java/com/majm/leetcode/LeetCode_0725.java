package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.ListNode;

import java.util.List;

/**
 * 725. 分隔链表 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-22 09:45
 * @since
 */
public class LeetCode_0725 implements Solution {

    /**
     * @param head
     * @param k
     * @return
     */
    @Override
    public ListNode[] splitListToParts(ListNode head, int k) {
        //  计算出 链表长度 len
        // quotient = len/k
        // reminder = len % k, 前 reminder 个 链表长度 = quotient + 1
        ListNode curNode = head;
        int len = 0;
        while (curNode != null) {
            len++;
            curNode = curNode.next;
        }
        ListNode[] result = new ListNode[k];
        int quotient = len / k;
        int reminder = len % k;
        curNode = head;
        for (int i = 0; i < k; i++) {
            if (curNode == null) {
                break;
            }
            result[i] = curNode;
            int partSize = quotient + ((i < reminder) ? 1 : 0);
            ListNode prev = null;
            for (int j = 0; j < partSize; j++) {
                prev = curNode;
                curNode = curNode.next;
            }
            // 断开链表
            prev.next = null;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0725();
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(leetCode.splitListToParts(node, 5));
    }

}
