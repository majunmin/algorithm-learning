package com.majm.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 30. 包含min函数的栈 </br>
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-13 16:02
 * @since
 */
public class Offer30 {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min()); // -3
        minStack.pop();
        System.out.println(minStack.top()); // 0
        System.out.println(minStack.min()); // -2
    }
}

class MinStack {

    // 完成主逻辑
    private Deque<Integer> mainStack;
    // 单调栈递减,用于 保存最小值
    private Deque<Integer> supportStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        mainStack = new ArrayDeque<>();
        supportStack = new ArrayDeque<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (supportStack.isEmpty() || x < supportStack.peek()) {
            supportStack.push(x);
        }
    }

    public void pop() {
        if (mainStack.isEmpty()) {
            return;
        }
        int delVal = mainStack.pop();
        if (delVal == supportStack.peek()) {
            supportStack.pop();
        }
    }

    public int top() {
        if (mainStack.isEmpty()) {
            return -1;
        }
        return mainStack.peek();
    }

    public int min() {
        if (supportStack.isEmpty()) {
            return -1;
        }
        return supportStack.peek();
    }
}
