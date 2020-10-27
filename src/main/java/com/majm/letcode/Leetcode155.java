package com.majm.letcode;

import com.majm.Solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * @author majunmin
 * @description
 * @datetime 2020/10/26 8:35 下午
 * @since
 */
public class Leetcode155 implements Solution {



    // 1.
//    public static class MinStack {
//        private Deque<Integer> stack;
//        private Deque<Integer> minStack;
//
//        /**
//         * initialize your data structure here.
//         */
//        public MinStack() {
//            stack = new LinkedList<>();
//            minStack = new LinkedList<>();
//            minStack.push(Integer.MAX_VALUE);
//        }
//
//        public void push(int x) {
//            stack.push(x);
//            minStack.push(Math.min(x, minStack.peek()));
//        }
//
//        public void pop() {
//            stack.pop();
//            minStack.pop();
//        }
//
//        public int top() {
//            return stack.peek();
//        }
//
//        public int getMin() {
//            return minStack.peek();
//        }
//    }


    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */


    /**
     * 使用一个辅助栈
     */
    public static class MinStack {
        private Deque<Integer> stack;
        private Deque<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.peek() == null || minStack.peek() >= x)
                minStack.push(x);
        }

        public void pop() {
            Integer popNum = stack.pop();
            if (minStack.peek().equals(popNum))
                minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}


