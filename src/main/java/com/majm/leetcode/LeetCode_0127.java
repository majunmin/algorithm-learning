package com.majm.leetcode;

import com.majm.Solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/12 12:09 上午
 * @since
 */
public class LeetCode_0127 implements Solution {


    @Override
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return solution3(beginWord, endWord, wordList);
    }

    /**
     * 双向 BFS 遍历
     * 时间复杂度 O()
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private int solution3(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // 第 2 步：已经访问过的 word 添加到 visited 哈希表里
        Set<String> visited = new HashSet<>();

        // 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列，它们在双向 BFS 的过程中交替使用
        Set<String> beginVisited = new HashSet<>();
        Set<String> endVisited = new HashSet<>();

        beginVisited.add(beginWord);
        endVisited.add(endWord);
        wordSet.remove(beginWord);

        // 第 3 步：执行双向 BFS，左右交替扩散的步数之和为所求
        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // 优先选择小的哈希表进行扩散，考虑到的情况更少
            if (beginVisited.size() > endVisited.size()) {
                // exchange ?
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                if (changeWordEveryOneLetter2(word, endVisited, visited, wordSet, nextLevelVisited)) {
                    return step + 1;
                }
            }
            beginVisited = nextLevelVisited;
            step++;
        }
        return 0;
    }

    private boolean changeWordEveryOneLetter2(String word, Set<String> endVisited, Set<String> visited, Set<String> wordSet, Set<String> nextLevelVisited) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char originChar = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (originChar == c) {
                    continue;
                }
                charArray[i] = c;
                String nextWord = new String(charArray);
                if (wordSet.contains(nextWord)) {
                    // 对面哪一层(endVisited) 包含了nextWord, 则退出循环
                    if (endVisited.contains(nextWord)) {
                        return true;
                    }
                    // 去重
                    if (!visited.contains(nextWord)) {
                        nextLevelVisited.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            // 恢复，下次再用
            charArray[i] = originChar;
        }
        return false;
    }


    /**
     * 广度优先遍历 (BFS)
     * 1. 无向图中两个顶点之间的最短路径的长度，可以通过广度优先遍历得到；
     * 2. 为什么 BFS 得到的路径最短？可以把起点和终点所在的路径拉直来看，两点之间线段最短；
     * 3. 已知目标顶点的情况下，可以分别从起点和目标顶点（终点）执行广度优先遍历，直到遍历的部分有交集，这是双向广度优先遍历的思想。
     * -- https://leetcode-cn.com/problems/word-ladder/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you-2/
     *
     * 时间复杂度: O(26*wordLen)
     * 空间复杂度: O()
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private int solution2(String beginWord, String endWord, List<String> wordList) {

        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // 2. 图的广度优先遍历 必须使用队列和 表示是否访问过的 visited(Set)
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord);

        int wordLen = beginWord.length();
        Set<String> visited = new HashSet<>();

        // 3. begin BFS (contains beginWord)
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            ++step;
        }
        return 0;
    }

    /**
     * 尝试对 currentWord 修改每一个字符，看看是不是能与 endWord 匹配
     *
     * @param currentWord
     * @param endWord
     * @param queue
     * @param visited     (防止死循环)
     * @param wordSet
     * @return
     */
    private boolean changeWordEveryOneLetter(String currentWord, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet) {

        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char originChar = charArray[i];
            for (char ci = 'a'; ci <= 'z'; ci++) {
                if (originChar == ci) {
                    continue;
                }
                charArray[i] = ci;
                String nextWord = new String(charArray);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        // 注意：添加到队列以后，必须马上标记为已经访问
                        visited.add(nextWord);
                    }
                }
            }
            // reset
            charArray[i] = originChar;
        }
        return false;
    }

    private int minStep = Integer.MAX_VALUE;

    /**
     * dfs (超时)
     * 时间复杂度
     * 空间复杂度
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private int solution1(String beginWord, String endWord, List<String> wordList) {
        if (wordList.isEmpty() || !wordList.contains(endWord)) {
            return -1;
        }

        dfs(0, beginWord, endWord, new HashSet<>(wordList));
        return minStep == Integer.MAX_VALUE ? 0 : minStep;
    }

    private void dfs(int step, String curWord, String endWord, Set<String> wordSet) {
        if (curWord.equals(endWord)) {
            minStep = Math.min(step, minStep);
        }
        for (String word : wordSet) {
            if (countDiff(curWord, word) == 1) {
                Set<String> set = new HashSet<>(wordSet);
                set.remove(word);
                dfs(step + 1, word, endWord, set);
            }
        }
    }

    private int countDiff(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}
