package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索 II </br>
 * https://leetcode-cn.com/problems/word-search-ii/
 * <p>
 * 1. 回溯
 * 2. trieTree
 * 3. 带删除的 TrieTree
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-17 00:18
 * @since
 */
public class LeetCode_0212 implements Solution {

    private int[][] directions = new int[][]{
            {0, 1},
            {0, -1},
            {-1, 0},
            {1, 0},
    };


    @Override
    public List<String> findWords(char[][] board, String[] words) {
        return backTraceSolution2(board, words);
    }

    /**
     * 利用 TrieTree字典树
     *
     * @param board
     * @param words
     * @return
     */
    private List<String> backTraceSolution2(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int rowSize = board.length;
        int colSize = board[0].length;
        boolean[] visited = new boolean[rowSize * colSize];
        Set<String> result = new HashSet<>();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                dfs2(i, j, "", trie, result, board, visited);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs2(int row, int col, String path, Trie trie, Set<String> result, char[][] board, boolean[] visited) {
        // terminate
        int visitedIdx = row * board[0].length + col;
        if (visited[visitedIdx]) {
            return;
        }
        path += board[row][col];

        if (!trie.startsWith(path)) {
            return;
        }

        if (trie.search(path)) {
            result.add(path);
        }

        // flag
        visited[visitedIdx] = true;
        for (int[] direct : directions) {
            int newRow = row + direct[0];
            int newCol = col + direct[1];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
                continue;
            }
            dfs2(newRow, newCol, path, trie, result, board, visited);
        }
        visited[visitedIdx] = false;
    }


    /**
     * 单纯利用回溯解决
     * 1. 怎么进行有效地剪枝
     *
     * @param board
     * @param words
     * @return
     */
    private ArrayList<String> backTraceSolution(char[][] board, String[] words) {
        // 去重
        Set<String> result = new HashSet<>();
        int rowSize = board.length;
        int colSize = board[0].length;
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        boolean[] visited = new boolean[rowSize * colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                dfs(i, j, "", result, board, visited, wordSet);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(int row, int col, String path, Set<String> result, char[][] board, boolean[] visited, Set<String> wordSet) {
        // terminate
        int visitedIdx = row * board[0].length + col;
        if (visited[visitedIdx]) {
            return;
        }
        path += board[row][col];
        // 这里怎么进行优化剪枝
        if (path.length() > 10) {
            return;
        }

        visited[visitedIdx] = true;

        if (wordSet.contains(path)) {
            result.add(path);
        }

        // do choice
        for (int[] direct : directions) {
            int newRow = row + direct[0];
            int newCol = col + direct[1];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
                continue;
            }
            dfs(newRow, newCol, path, result, board, visited, wordSet);
        }
        visited[visitedIdx] = false;
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0212();
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'},
        };
        List<String> result = leetCode.findWords(board, new String[]{"oath", "eat", "pea", "rain"});
        System.out.println(result);
    }
}
