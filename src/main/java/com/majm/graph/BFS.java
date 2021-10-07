package com.majm.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 搜索算法 </br>
 * 广度优先搜索,
 * 利用一个 队列 queue, visited, prev
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-12 10:44
 * @since
 */
public class BFS {

    private List<Integer>[] matrix;

    public BFS(AdjList adjList) {
        this.matrix = adjList.getList();
    }

    public void search(int s, int t) {
        if (s == t) {
            return;
        }

        // visited 记录已经访问过的节点
        boolean[] visited = new boolean[matrix.length];
        visited[s] = true;
        int[] prev = new int[matrix.length];
        Arrays.fill(prev, -1);

        Deque<Integer> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int i = 0; i < matrix[w].size(); i++) {
                int q = this.matrix[w].get(i);
                // 剪枝 ,不需要再次访问已经访问过的
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    queue.add(q);
                    visited[q] = true;
                }
            }
        }


    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.println(t + " ");
    }

    public static void main(String[] args) {
        AdjList adjList = new AdjList(8);
        adjList.addEdge(0, 1);
        adjList.addEdge(0, 3);
        adjList.addEdge(1, 2);
        adjList.addEdge(1, 4);
        adjList.addEdge(2, 5);
        adjList.addEdge(3, 4);
        adjList.addEdge(4, 5);
        adjList.addEdge(4, 6);
        adjList.addEdge(5, 7);
        adjList.addEdge(6, 7);

        final BFS bfs = new BFS(adjList);
        bfs.search(0, 6);
    }
}
