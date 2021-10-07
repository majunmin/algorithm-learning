package com.majm.graph;

import java.util.List;

/**
 * 图的表示方式 </br>
 * 邻接矩阵
 * 邻接表
 * 逆邻接表
 * <p>
 * vertex
 * edge
 * degree
 * <p>
 * 有向图
 * 无向图
 *
 *
 * <code>
 * procedure DFS(G, V) is
 * Label v as discovered
 * for all directes edges from v to w that are in G,adjacentEdges(V) do
 * if vertex w is not labeled as discovered then
 * recursively call DFS(G,W)
 * </code>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-06 19:10
 * @since
 */
public class Graph {

    private List<String> vertexs;

    private int[][] edges;

    private int numOfEdges;

    private int[][] visited;


    public Graph() {
        // 初始化一张图

    }

    public void insertVertex(String vertex) {
        //
        vertexs.add(vertex);
    }

    public void insertEdge(int v, int w, int weight) {
        edges[v][w] = 1;
        edges[w][v] = 1;

    }
}
