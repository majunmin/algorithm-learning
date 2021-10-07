package com.majm.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/dinner-plate-stacks/ </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-24 20:28
 * @since
 */
public class LeetCode_1172 {


    private static class DinnerPlates {

        private List<Deque<Integer>> stacks = new ArrayList<>();
        private int capacity;
        private int size;
        private int right = -1; // 栈的最右索引

        public DinnerPlates(int capacity) {
            this.capacity = capacity;
        }

        public void push(int val) {
            for (int i = 0; i <= right; i++) {
                if (stacks.get(i).size() < capacity) {
                    stacks.get(i).push(val);
                    size++;
                    return;
                }
            }
            right++;
            Deque<Integer> newStack = new ArrayDeque<>();
            newStack.push(val);
            size++;
            stacks.add(newStack);
        }

        public int pop() {
            if (size == 0) {
                return -1;
            }
            for (int i = right; i >= 0; i--) {
                if (!stacks.get(i).isEmpty()) {
                    size--;
                    return stacks.get(i).pop();
                }
            }
            return -1;
        }

        public int popAtStack(int index) {
            if (index < 0 || index > right) {
                return -1;
            }
            Deque<Integer> stack = stacks.get(index);
            if (stack.isEmpty()) {
                return -1;
            }
            size--;
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        final DinnerPlates dinnerPlates = new DinnerPlates(2);
        dinnerPlates.push(1);
        dinnerPlates.push(2);
        dinnerPlates.push(3);
        dinnerPlates.push(4);
        dinnerPlates.push(5);

        dinnerPlates.popAtStack(0);
        dinnerPlates.push(20);
        dinnerPlates.push(22);
        dinnerPlates.popAtStack(0);
        dinnerPlates.popAtStack(2);
        dinnerPlates.pop();
        dinnerPlates.pop();
        dinnerPlates.pop();
        dinnerPlates.pop();

        System.out.println(dinnerPlates);
    }

}
