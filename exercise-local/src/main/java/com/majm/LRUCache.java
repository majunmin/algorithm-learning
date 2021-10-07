package com.majm;

import java.util.HashMap;
import java.util.Map;

/**
 * lru 缓存 </br>
 * 缓存换入换出策略
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-03 23:55
 * @since
 */
public class LRUCache<K, V> {

    private Map<K, DLinkNode> cache;

    private class DLinkNode {
        private V data;
        private DLinkNode prev;
        private DLinkNode next;
    }

    private int capacity;
    private int size;

    private DLinkNode head;
    private DLinkNode tail;

    public LRUCache() {
        this(10);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        this.head = new DLinkNode();
        this.tail = new DLinkNode();
        this.head.next = tail;
        this.tail.prev = head;
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        final DLinkNode node = cache.get(key);
        moveToHead(node);
        return node.data;
    }

    private void moveToHead(DLinkNode node) {
        remove(node);
        addToHead(node);
    }

    private void addToHead(DLinkNode node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    public void put(K key, V value) {
        DLinkNode node;
        if (cache.containsKey(key)) {
            node = cache.get(key);
            node.data = value;
            moveToHead(node);
            return;
        }
        if (cache.size() == capacity) {
            removeLatest();
        } else {
            size++;
        }
        node = new DLinkNode();
        node.data = value;
        cache.put(key, node);
        addToHead(node);
    }

    public void remove(DLinkNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        // helpGC
        node.next = null;
        node.prev = null;
    }

    /**
     * 移除最早被访问的
     */
    public void removeLatest() {
        final DLinkNode evictNode = tail.prev;
        remove(evictNode);
    }
}
