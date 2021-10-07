package com.majm;

/**
 * 循环队列 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-04 10:24
 * @since
 */
public class CircularQueue {

    private Object[] items;

    private Integer capacity;

    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }

    public boolean enqueue(Object item) {
        if (isFull()) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % capacity;
        return true;
    }

    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object ret = items[head];
        head = (head + 1) % capacity;
        return ret;
    }

}
