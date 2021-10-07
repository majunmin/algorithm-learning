package com.majm;

/**
 * 有界数组队列  </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-04 10:13
 * @since
 */
public class ArrayQueue {
    private Object[] items;

    private int head;
    private int tail;

    public void enque(Object item) {
        if (tail == items.length - 1) {//
            if (head == 0) {
                throw new RuntimeException("queue is empty!");
            }
            System.arraycopy(items, head, items, 0, tail - head);
            // update tail head
            tail = tail - head;
            head = 0;

        }
        items[tail++] = item;
        if (tail == items.length) {

        }

    }

    public Object deque() {
        if (isEmpty()) {
            return null;
        }

        return items[head++];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return tail - head + 1 == items.length;
    }
}
