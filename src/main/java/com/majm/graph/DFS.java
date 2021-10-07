package com.majm.graph;

import java.util.Arrays;
import java.util.List;

/**
 * 深度优先搜索 </br>
 * 利用回溯的技巧
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-12 12:43
 * @since
 */
public class DFS {

    private List<Integer>[] adjList;

    public DFS(AdjList adjList) {
        this.adjList = adjList.getList();
    }

    public void search(int s, int t) {
        if (s == t) {
            return;
        }

        boolean[] visited = new boolean[adjList.length];
        int[] prev = new int[adjList.length];
        Arrays.fill(prev, -1);
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private boolean found;

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {

        // 剪枝条件， 如果找到了,就直接返回
        if (found) {
            return;
        }
        visited[w] = true;
        // terminate
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adjList[w].size(); i++) {
            int vertex = adjList[w].get(i);
            if (!visited[vertex]) {
                prev[vertex] = w;
                recurDfs(vertex, t, visited, prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        // terminate
        if (s == t || t == -1) {
            System.out.print(t + " ");
            return;
        }

        print(prev, s, prev[t]);
        System.out.print(t + " ");
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

        DFS dfs = new DFS(adjList);
        dfs.search(0, 7);
    }

}
