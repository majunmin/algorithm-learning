package com.majm.structor.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存实现</br>
 * 1. 双向链表 + hash表
 * 2.
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-06 22:09
 * @since
 */
public class LRUCache<Key, Value> {

    private Integer capacity;

    private Map<Key, DLinkNode> cache = new HashMap<>();

    public LRUCache(Integer capacity) {
        this.capacity = capacity;
        this.head = new DLinkNode();
        this.tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }


    private DLinkNode head;
    private DLinkNode tail;

    private class DLinkNode {
        private Key key;
        private Value value;
        private DLinkNode prev;
        private DLinkNode next;

        private DLinkNode() {
        }

        public DLinkNode(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(Key key, Value value) {
        DLinkNode node = null;
        if (cache.containsKey(key)) {
            node = cache.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }

        node = new DLinkNode(key, value);
        cache.put(key, node);
        addToHead(node);
        if (capacity == cache.size()) {
            removeOldest();
        }
    }


    public Value get(Key key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        DLinkNode node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void remove(Key key) {
        if (cache.containsKey(key)) {
            removeElement(cache.get(key));
        }

    }

    private void removeElement(DLinkNode evictNode) {
        cache.remove(evictNode.key);
        evictNode.prev.next = evictNode.next;
        evictNode.next.prev = evictNode.prev;
        // helpGC
        evictNode.prev = null;
        evictNode.next = null;
    }

    private void removeOldest() {
        if (tail.prev != head) {
            DLinkNode delNode = tail.prev;
            removeElement(delNode);
        }
    }

    private void addToHead(DLinkNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;

    }

    private void moveToHead(DLinkNode node) {
        removeElement(node);
        addToHead(node);
        cache.put(node.key, node);
    }

}
