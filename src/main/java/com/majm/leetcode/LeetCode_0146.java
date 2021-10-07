package com.majm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * https://leetcode-cn.com/problems/lru-cache/ </br>
 * <p>
 * HashMap + LinkedList  => lru 保证 O(1)的查询时间复杂度
 * <p>
 * 146. LRU 缓存机制
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-21 00:06
 * @since
 */
public class LeetCode_0146 {

    private static class LRUCache<Key, Value> {

        private class Node {
            private final Key key;
            private Value value;

            public Node(Key key, Value value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Key, Node> cache; //  保证O(1)的时间复杂度
        private LinkedList<Node> list; // 维护最新访问节点

        private int size;
        private int capacity;

        private BiConsumer<Key, Value> onEvict;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>(capacity);
            this.list = new LinkedList<>();
            onEvict = (k, v) -> {
            };
        }

        public LRUCache(int capacity, BiConsumer<Key, Value> onEvict) {
            this.capacity = capacity;
            this.cache = new HashMap<>(capacity);
            this.list = new LinkedList<>();
            this.onEvict = onEvict;
        }

        public Value get(Key key) {
            if (cache == null) {
                throw new IllegalArgumentException();
            }

            if (!cache.containsKey(key)) {
                return null;
            }
            final Node node = cache.get(key);
            moveToHead(node);
            return node.value;
        }

        private void moveToHead(Node node) {
            list.remove(node);
            list.addFirst(node);
        }

        private void removeLatest() {
            final Node node = list.getLast();
            remove(node.key);
        }

        public void put(Key key, Value value) {
            if (cache.containsKey(key)) {
                final Node node = cache.get(key);
                node.value = value;
                moveToHead(node);
                return;
            }

            final Node node = new Node(key, value);
            cache.put(key, node);
            list.addFirst(node);
            if (cache.size() > capacity) {
                removeLatest();
            }
        }

        public void remove(Key key) {
            final Node node = cache.remove(key);
            if (node == null) {
                return;
            }
            if (onEvict != null) {
                onEvict.accept(node.key, node.value);
            }
            size--;
            list.remove(node);
        }
    }


    public static void main(String[] args) {
        final LRUCache<Integer, Integer> cache = new LRUCache<>(2);
        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(2));
        cache.put(3, 3);
        System.out.println(cache.get(2));

        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}

//class LRUCache extends LinkedHashMap<Integer, Integer> {
//
//    private int capacity;
//
//    public LRUCache(int capacity) {
//        super(capacity, 0.75f, true);
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        return super.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        super.put(key, value);
//    }
//
//    @Override
//    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//        return this.size() > capacity;
//    }
//}


/**
 * HashMap + LikedList  实现LRUCache, 超出时间限制
 *
 * @param <Key>
 * @param <Value>
 */
//class LRUCache<Key, Value> {
//
//    private static class Node<Key, Value> {
//        private Key key;
//        private Value value;
//
//        public Node(Key key, Value value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public Key getKey() {
//            return key;
//        }
//
//        public void setKey(Key key) {
//            this.key = key;
//        }
//
//        public Value getValue() {
//            return value;
//        }
//
//        public void setValue(Value value) {
//            this.value = value;
//        }
//    }
//
//    private LinkedList<Node<Key, Value>> list;
//    private Map<Key, Node<Key, Value>> cache;
//    private int CAPACITY;
//
//    public LRUCache(int capacity) {
//        CAPACITY = capacity;
//        cache = new HashMap<>();
//        list = new LinkedList<>();
//    }
//
//    public Value get(Key key) {
//        if (!cache.containsKey(key)) {
//            return null;
//        }
//        Node<Key, Value> valueNode = cache.get(key);
//        list.remove(valueNode);
//        list.addFirst(valueNode);
//        return valueNode.getValue();
//    }
//
//    public void put(Key key, Value value) {
//        if (!cache.containsKey(key)) {
//            final Node<Key, Value> node = new Node<>(key, value);
//            cache.put(key, node);
//            list.addFirst(node);
//            if (cache.size() > CAPACITY) {
//                removeOldest();
//            }
//        } else {
//            final Node<Key, Value> node = cache.get(key);
//            node.value = value;
//            list.remove(node);
//            list.addFirst(node);
//        }
//    }
//
//
//    public void remove(Node<Key, Value> node) {
//        cache.remove(node.getKey());
//        list.remove(node);
//    }
//
//    private void removeOldest() {
//        if (list.size() == 0) {
//            return;
//        }
//        final Node<Key, Value> node = list.removeLast();
//        cache.remove(node.getKey());
//    }
//}

class LRUCache<Key, Value> {

    private static class Node<Key, Value> {
        private Key key;
        private Value value;
        private Node<Key, Value> next;
        private Node<Key, Value> prev;

        public Node() {
        }

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public Key getKey() {
            return key;
        }

        public Value getValue() {
            return value;
        }
    }

    private Node<Key, Value> list;
    private Map<Key, Node<Key, Value>> cache;
    private Node<Key, Value> head;
    private Node<Key, Value> tail;
    private int CAPACITY;

    public LRUCache(int capacity) {
        CAPACITY = capacity;
        cache = new HashMap<>();
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
    }

    public Value get(Key key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        final Node<Key, Value> node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(Node<Key, Value> node) {
        // 双线链表的删除操作
        remove(node);

        // 添加到头部
        addToHead(node);
    }

    public void put(Key key, Value value) {
        final Node<Key, Value> node;

        if (!cache.containsKey(key)) {
            node = new Node<>(key, value);
            addToHead(node);
            cache.put(key, node);
            if (cache.size() > CAPACITY) {
                removeOldest();
            }
        } else {
            node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
    }


    public void remove(Node<Key, Value> node) {
        if (node == null) {
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;
    }

    private void removeOldest() {
        // 空链表
        if (tail.prev == head) {
            return;
        }
        Node<Key, Value> node = tail.prev;
        cache.remove(node.getKey());
        remove(node);
    }

    private void addToHead(Node<Key, Value> node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
    }
}
