package com.majm.letcode;

import com.majm.Solution;
import com.majm.common.ListNode;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/24 12:23 上午
 * @since
 */
public class LeetCode21 implements Solution {

        @Override
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 1. 递归
//            if (l1 == null){
//                return l2;
//            }
//            if (l2 == null){
//                return l1;
//            }
//            if (l1.val <= l2.val){
//                l1.next = mergeTwoLists(l1.next, l2);
//                return l1;
//            } else {
//                l2.next = mergeTwoLists(l1.next, l2);
//                return l2;
//            }

            // 2. 迭代， 暴力解法
            if (l1 == null){
                return l2;
            }
            if (l2 == null){
                return l1;
            }
            ListNode dummyHead = new ListNode(-1);
            ListNode preHead = dummyHead;
            while (l1 != null && l2 != null){
                if (l1.val <= l2.val) {
                    preHead.next = l1;
                    l1 = l1.next;
                } else {
                    preHead.next = l2;
                    l2 = l2.next;
                }
                preHead = preHead.next;
            }
            preHead.next = (l1 != null) ? l1 : l2;
            return dummyHead.next;

        }
}
