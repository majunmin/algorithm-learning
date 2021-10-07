package com.majm.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存换入换出策略 </br>
 * 最近最少使用算法
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-28 09:10
 * @since
 */
public class LRUCache {

    private static class DLinkNode {
        private DLinkNode prev;
        private DLinkNode next;
        private Object data;
    }

    // 容量
    private int capacity;
    // 当前已使用大小
    private int size;

    private DLinkNode head;
    private DLinkNode tail;

    private Map<String, DLinkNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>(capacity + 1);
    }

    public Object get(String key) {
        if (cache.containsKey(key)) {
            final DLinkNode node = cache.get(key);
            addToHead(node);
            return node;
        }
        return null;
    }

    private void addToHead(DLinkNode node) {
        remove(node);
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    public void put(String key, Object value) {
        final DLinkNode node;
        if (cache.containsKey(key)) {
            node = cache.get(key);
            node.data = value;
            addToHead(node);
            return;
        }
        node = new DLinkNode();
        node.data = value;
        cache.put(key, node);
        if (size == capacity) {
            removeOldest();
        } else {
            size++;
        }
        addToHead(node);
    }


    public void remove(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // helpGC
        node.next = null;
        node.prev = null;
    }

    public void removeOldest() {
        DLinkNode evictNode = tail.prev;
        evictNode.prev.next = evictNode.next;
        evictNode.next.prev = evictNode.prev;
        evictNode.next = null;
        evictNode.prev = null;

    }


}
