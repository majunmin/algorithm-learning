package com.majm.common;

/**
 * Trie字典树 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-17 10:28
 * @since
 */


public class Trie {
    // 根节点
    private TrieNode root = new TrieNode('/');

    public Trie() {
    }

    public void insert(String word) {
        TrieNode prev = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (prev.child[index] == null) {
                prev.child[index] = new TrieNode(c);
            }
            prev = prev.child[index];
        }
        prev.isEnd = true;
    }

    public boolean find(String searchWord) {
        TrieNode prev = root;
        for (char c : searchWord.toCharArray()) {
            int index = c - 'a';
            if (prev.child[index] == null) {
                return false;
            }
            prev = prev.child[index];
        }
        return prev.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode prev = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (prev.child[index] == null) {
                return false;
            }
            prev = prev.child[index];
        }
        return true;
    }


    static class TrieNode {

        // trieNode 仅由小写字母组成
        private TrieNode[] child;
        private char data;
        private boolean isEnd;

        public TrieNode(char data) {
            this.data = data;
            this.child = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        final Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.find("apple"));
    }
}


