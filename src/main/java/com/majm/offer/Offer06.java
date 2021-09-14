package com.majm.offer;

import com.majm.common.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/4 8:26 下午
 * @since
 */
public class Offer06 {

    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     * <p>
     * <p>
     * 限制：
     * <p>
     * 0 <= 链表长度 <= 10000
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while(head != null){
            result.add(0, head.val);
            head = head.next;
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }


    /**
     * 递归的方式
     * 时间复杂度O(N)
     * 空间复杂度
     *
     * @param head
     * @return
     */
    private int[] solution2(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        reverse(head, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void reverse(ListNode head, List<Integer> result) {
        if (head == null) {
            return;
        }
        reverse(head.next, result);
        result.add(head.val);
    }


    /**
     * 栈是先进后出的数据结构, 很容易想到
     * 时间复杂度 O(N) 遍历链表(N)
     * 空间复杂度 O(N) 辅助栈(N) + 数组(N)
     *
     * @param head
     * @return
     */
    public int[] solution1(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        int size = 0;
        while (head != null) {
            stack.push(head);
            head = head.next;
            size++;
        }

        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop().val;
        }
        return result;
    }
}
