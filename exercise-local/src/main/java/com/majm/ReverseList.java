package com.majm;


/**
 * 一句话功能简述 </br>
 * <p>
 * 反转链表：
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 交换次数  = (n - m +1)/ 2
 * <p>
 * <p>
 * prev lNode  rNode  end
 * <p>
 * end = rNode.next
 * rNode.next = lNode.next
 * lNode.next = end
 * prev.next = rNode
 * <p>
 * <p>
 * <p>
 * lNode.next
 * prev.next = rNode
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-23 20:37
 * @since
 */
public class ReverseList {

    private static class ListNode {
        private Integer val;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(Integer val) {
            this.val = val;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }


    public ListNode reverseList(ListNode head, int m, int n) {
        if (m <= 0 || m > n) {
            throw new IllegalArgumentException();
        }
        if (m == n) {
            return head;
        }
        ListNode prev = new ListNode(-1);
        prev.next = head;
        for (int i = 0; i < m-1; i++) {
            prev = prev.next;
        }

        ListNode nextNode = prev.next;
        ListNode lNode = prev.next;
        for (int i = 0; i < n - m; i++) {
            ListNode tempNode = lNode.next;
            lNode.next = lNode.next.next;
            tempNode.next = nextNode;
            prev.next = tempNode;
            nextNode = prev.next;
        }


        if (m == 1) {
            return prev.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);

        ReverseList reverseList = new ReverseList();
        final ListNode result = reverseList.reverseList(listNode1, 1, 5);
        System.out.println(result);


    }
}
