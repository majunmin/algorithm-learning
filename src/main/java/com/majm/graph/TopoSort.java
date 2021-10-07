package com.majm.graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 拓扑排序(有向图) </br>
 * 一种图排序方式,一般有两种方式
 * <p>
 * - DFS
 * - Khan算法
 * <p>
 * Khan算法采用贪心算法思想,在定义数据结构的时候, s先于t执行, 就构建一个 s指向t的边,因此每个顶点的入度表示这个顶点依赖了多少个其他顶点
 * <p>
 * 1. 找到图中 所有 入度为0的顶点, 加入到 队列中
 * 2. 遍历队列中的vertex, 将其加入到  拓扑排序结果集中
 * 3. 依赖该顶点的 顶点的入度 -1,并将 入度为0的顶点 加入到  队列中
 * <p>
 * ## DFS
 * <p>
 * 1.
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-12 14:46
 * @since
 */
public class TopoSort {

    private List<Integer>[] adjList;

    public TopoSort(AdjList adjList) {
        this.adjList = adjList.getList();
    }

    public void topoSortByKahn() {
        // 统计每个 vertex 的入度
        int[] inDegree = new int[adjList.length];
        for (int i = 0; i < adjList.length; i++) {
            for (int j = 0; j < adjList[i].size(); j++) {
                Integer w = adjList[i].get(j); // i -> w
                inDegree[w]++;
            }
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer w = queue.pop();
                System.out.println("->" + w);
                for (int j = 0; j < adjList[w].size(); j++) {
                    int vertex = adjList[w].get(j);
                    inDegree[vertex]--;
                    if (inDegree[vertex] == 0) {
                        queue.offer(vertex);
                    }
                }
            }
        }

    }

    /**
     *
     */
    public void topoSortByDfs() {
        // 构造一个逆邻接表
        AdjList inverseAdj = new AdjList(this.adjList.length);
        for (int i = 0; i < adjList.length; i++) {
            for (int j = 0; j < adjList[i].size(); j++) {
                Integer k = adjList[i].get(j); // i-> k
                inverseAdj.addEdge(k, i);
            }
        }

        boolean[] visited = new boolean[this.adjList.length];
        for (int i = 0; i < this.adjList.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                recurDfs(i, inverseAdj, visited);
            }
        }

    }

    private void recurDfs(int vertex, AdjList inverseAdj, boolean[] visited) {
        List<Integer> list = inverseAdj.getList()[vertex];
        for (int i = 0; i < list.size(); i++) {
            Integer w = list.get(i);
            if (visited[w]) {
                continue;
            }
            recurDfs(w, inverseAdj, visited);
        }
        // 先把 vertex 依赖的顶点都输出,在输出  vertex
        System.out.println("-> " + vertex);
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

        final TopoSort topoSort = new TopoSort(adjList);
        topoSort.topoSortByKahn();

        System.out.println("===========");
        topoSort.topoSortByDfs();
    }


}
