package com.majm.common.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存 </br>
 * 1. 维护一个双向链表
 * 2. Hash表 查询时间复杂度 O(1)
 * 3. 双向链表维护访问顺序, 最新访问的节点放到 头结点 head
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-18 16:58
 * @since
 */
public class LRUCache {

    private Map<Integer, DLinkNode> cache = new HashMap<>();
    private int capacity;
    private int size;

    private DLinkNode head;
    private DLinkNode tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.head = new DLinkNode(-1, -1);
        this.tail = new DLinkNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DLinkNode node = cache.get(key);
        moveToHead(node);
        return node.val;
    }

    private void moveToHead(DLinkNode node) {
        remove(node);
        addToHead(node);
    }

    private void addToHead(DLinkNode node) {
        if (node == null) {
            return;
        }
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        cache.put(node.key, node);
        size++;
    }

    private void remove(DLinkNode node) {
        if (node == null) {
            return;
        }
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // helpGC
        node.next = null;
        node.prev = null;
        size--;
    }

    public void put(int key, int value) {
        DLinkNode node;
        if (cache.containsKey(key)) {
            node = cache.get(key);
            node.val = value;
            moveToHead(node);
            return;
        }
        if (size == capacity) {
            removeOldest();
        }
        node = new DLinkNode(key, value);
        addToHead(node);
    }

    private void removeOldest() {
        remove(tail.prev);
    }


    private static class DLinkNode {
        private int key;
        private int val;
        private DLinkNode prev;
        private DLinkNode next;

        public DLinkNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(2);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
    }
}
