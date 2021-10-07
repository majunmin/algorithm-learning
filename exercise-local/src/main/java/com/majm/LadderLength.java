package com.majm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-01 22:55
 * @since
 */
public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return bfsSolution2(beginWord, endWord, wordList);
    }

    /**
     * 双向BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private int bfsSolution2(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        if (diffOneChar(beginWord, endWord)) {
            return 2;
        }

        Set<String> words = new HashSet<>(wordList);
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);
//        words.remove(endWord);

        int minStep = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            Set<String> nextLevelWords = new HashSet<>();
            final Iterator<String> it1 = beginVisited.iterator();
            if (it1.hasNext()) {
                String curWord = it1.next();
                Iterator<String> it = words.iterator();
                while (it.hasNext()) {
                    String word = it.next();
                    if (diffOneChar(word, curWord)) {
                        if (endVisited.contains(word)) {
                            return minStep + 1;
                        }
                        nextLevelWords.add(word);
                        it.remove();
                    }
                }
                beginVisited.remove(curWord);
            }
            minStep++;
            beginVisited = nextLevelWords;
            if (endVisited.size() < beginVisited.size()){
                beginVisited = endVisited;
                endVisited = nextLevelWords;
            }
        }
        return 0;
    }

    private int bfsSolution(String beginWord, String endWord, List<String> wordList) {
        int minStep = 0;
        final Deque<String> queue = new ArrayDeque<>();

        Set<String> words = new HashSet<>(wordList);
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                String curWord = queue.poll();
                if (Objects.equals(curWord, endWord)) {
                    return minStep;
                }
                words.remove(curWord);
                for (String word : words) {
                    if (diffOneChar(word, curWord)) {
                        queue.offer(word);
                    }
                }
                minStep++;
            }
        }
        return 0;
    }


    private static Integer minStep = Integer.MAX_VALUE;

    private void dfs(String curWord, String endWord, List<String> wordList, int curLength, Set<String> words) {
        if (Objects.equals(curWord, endWord)) {
            minStep = Math.min(curLength, minStep);
        }

        for (String word : words) {
            if (diffOneChar(word, curWord)) {
                Set<String> nextWords = new HashSet<>(words);
                nextWords.remove(word);
                dfs(word, endWord, wordList, curLength + 1, nextWords);
            }
        }
    }

    private boolean diffOneChar(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff += 1;
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {

        final LadderLength ladderLength = new LadderLength();
        System.out.println(ladderLength.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}
