package com.mjm;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-01-21 21:46
 * @since
 */
public class TwoNumAdd {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3, temp;

        int val = l1.val + l2.val;
        l3 = new ListNode(val % 10);
        temp = l3;
        int carry = val / 10;

        while (l1.next != null || l2.next != null) {
            l1 = l1.next == null ? new ListNode(0) : l1.next;
            l2 = l2.next == null ? new ListNode(0) : l2.next;
            val = l1.val + l2.val + carry;
            l3.next = new ListNode(val % 10);
            l3 = l3.next;
            carry = val / 10;
        }
        if (carry != 0) {
            l3.next = new ListNode(carry);
        }
        return temp;
    }

    public ListNode addTwoNumbers_stand(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {

    }
}
