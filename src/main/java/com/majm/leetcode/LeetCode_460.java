package com.majm.leetcode;

import com.majm.Solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

/**
 * 460. LFU 缓存 </br>
 * https://leetcode-cn.com/problems/lfu-cache/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-18 17:40
 * @since
 */
public class LeetCode_460 implements Solution {

    public static void main(String[] args) {
        LFUCache2 lfuCache = new LFUCache2(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));

        System.out.println("============");

        LFUCache2 cache = new LFUCache2(3);
        cache.put(2, 2);
        cache.put(1, 1);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));

        System.out.println("============");

        LFUCache2 cache3 = new LFUCache2(2);
        cache3.get(2);
        cache3.put(2, 6);
        cache3.get(1);
        cache3.put(1, 5);
        cache3.put(1, 2);
        System.out.println(cache3.get(1));
        System.out.println(cache3.get(2));
    }
}

/**
 * 解法一
 * TreeSet  记录  count 与时间的排序,
 * - TreeSet修改值后 想要重新排序 需要 删除该节点,之后 再添加
 * - LRU值 time 通过一个全局计数器 time 来表示访问时间先后
 * <p>
 * cache hash表来做 查询 O(1)
 */
class LFUCache {
    // 缓存容量
    private int capacity;
    // 时间戳 全局的, 用于计算  最近访问的
    private int time;
    private Map<Integer, Node> cache;
    private TreeSet<Node> set;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.time = 0;
        this.cache = new HashMap<>();
        this.set = new TreeSet<>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        set.remove(node);
        node.time = time++;
        node.count++;
        set.add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            set.remove(node);
            node.count++;
            node.time = time++;
            node.val = value;
            set.add(node);
            return;
        }
        if (cache.size() == capacity) {
            removeOldest();
        }
        Node node = new Node(key, value);
        node.time = time++;
        node.count++;
        set.add(node);
        cache.put(key, node);
    }

    private void removeOldest() {
        if (set.size() < 1) {
            return;
        }
        Node node = set.pollFirst();
        cache.remove(node.key);
    }

    private static class Node implements Comparable<Node> {
        // 访问次数
        private int count;
        // 上移访问时间
        private int time;
        private int key;
        private int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return count == node.count && time == node.time;
        }


        @Override
        public int hashCode() {
            return Objects.hash(count, time);
        }

        /**
         * 从小到大排序  this.val - other.val
         *
         * @param o
         * @return
         */
        @Override
        public int compareTo(Node o) {
            return this.count == o.count ? this.time - o.time : this.count - o.count;
        }
    }
}

/**
 * 解法二
 * cache 用一个map 做 key value 映射, 查询效率 O(1)
 * freqMap  用来映射 频率 key: freq value： nodeList
 * - nodeList 头部是新加入节点，
 * 当缓存满了的时候, 删除频率最低的那个节点
 */
class LFUCache2 {
    // 缓存容量
    private int capacity;
    private Map<Integer, Node> cache;
    private Map<Integer, LinkedList<Node>> freqMap;

    public LFUCache2(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        freqMap.get(node.frequency).remove(node);
        node.frequency++;
        if (!freqMap.containsKey(node.frequency)) {
            freqMap.put(node.frequency, new LinkedList<>());
        }
        freqMap.get(node.frequency).addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            freqMap.get(node.frequency).remove(node);
            node.frequency++;
            if (!freqMap.containsKey(node.frequency)) {
                freqMap.put(node.frequency, new LinkedList<>());
            }
            freqMap.get(node.frequency).addFirst(node);
            return;
        }
        // capacity
        if (capacity == cache.size()) {
            removeOldest();
        }
        if (!freqMap.containsKey(1)) {
            freqMap.put(1, new LinkedList<>());
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        freqMap.get(1).addFirst(node);
    }

    private void removeOldest() {
        for (int i = 1; i <= freqMap.size(); i++) {
            LinkedList<Node> nodeList = freqMap.get(i);
            if (!nodeList.isEmpty()){
                Node node = nodeList.removeLast();
                cache.remove(node.key);
                break;
            }
        }
    }

    private static class Node {
        private int key;
        private int val;
        private int frequency;

        public Node(int key, int val) {
            this(key, val, 1);
        }

        public Node(int key, int val, int frequency) {
            this.key = key;
            this.val = val;
            this.frequency = frequency;
        }
    }
}
