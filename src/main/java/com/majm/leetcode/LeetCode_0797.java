package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 797. 所有可能的路径 </br>
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 * <p>
 * 有向无环图
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-25 22:25
 * @since
 */
public class LeetCode_0797 implements Solution {

    @Override
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return bfsSolution(graph);
    }


    /**
     * dfs 解法
     * 需要记忆 之前遍历过得节点
     *
     * @param graph
     * @return
     */
    private List<List<Integer>> bfsSolution(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        int target = graph.length - 1;
        Deque<Node> queue = new LinkedList<>();
        queue.add(new Node(0));

        while (!queue.isEmpty()) {
            Node curNode = queue.pop();
            if (curNode.getIdx() == target) {
                result.add(curNode.getPath());
                continue;
            }
            for (int nextIdx : graph[curNode.getIdx()]) {
                queue.add(new Node(nextIdx, curNode.getPath()));
            }
        }
        return result;

    }


    /**
     * dfs 解法
     * 时间复杂度: O()
     * 空间复杂度: O(2^n * n)
     *
     * @param graph
     * @return
     */
    private List<List<Integer>> dfsSolution(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfsSolutionHelper(0, graph.length - 1, graph, path, result);
        return result;
    }

    private void dfsSolutionHelper(int curNode, int target, int[][] graph, List<Integer> path, List<List<Integer>> result) {
        // terminate
        if (curNode == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        // for choice in choiceList
        for (int nextNode : graph[curNode]) {
            path.add(nextNode);
            dfsSolutionHelper(nextNode, target, graph, path, result);
            // revert
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0797();
        System.out.println(leetCode.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
    }

    static class Node {
        private List<Integer> path;
        private Integer idx;

        public Node(Integer idx) {
            this.idx = idx;
            this.path = new ArrayList<>();
            this.path.add(idx);
        }

        public Node(Integer idx, List<Integer> path) {
            this.idx = idx;
            this.path = new ArrayList<>(path);
            this.path.add(idx);
        }

        public List<Integer> getPath() {
            return path;
        }

        public Integer getIdx() {
            return idx;
        }
    }
}

