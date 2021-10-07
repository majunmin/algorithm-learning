package com.majm.graph.dijkstra;

import java.util.LinkedList;
import java.util.List;

/**
 * 有向有权图的表示 </br>
 * <p>
 * 单元最短路径 算法  Dijkstra 算法
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-14 18:02
 * @since
 */
public class Graph {

    private List<Edge>[] adj;

    private int v; // 顶点个数

    public Graph(int v) {
        this.v = v;
        this.adj = new List[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int weight) {
        this.adj[s].add(new Edge(s, t, weight));
    }

    public int dijkstra(int s, int t) {
        int[] predecessor = new int[this.v];
        Vertex[] vertexs = new Vertex[this.v];
        //  init vertex
        for (int i = 0; i < v; i++) {
            vertexs[i] = new Vertex(i, Integer.MAX_VALUE);
        }

        PriorityQueue pq = new PriorityQueue(this.v);
        boolean[] inQueue = new boolean[this.v];
        // 起始定点的距离是 0
        vertexs[s].setDist(0);
        pq.add(vertexs[s]);
        while (!pq.isEmpty()) {
            final Vertex minVertex = pq.poll();
            //最短路径产生
            if (minVertex.getId() == t) {
                break;
            }
            List<Edge> edges = adj[minVertex.getId()];
            for (int i = 0; i < edges.size(); i++) {
                final Edge edge = edges.get(i);
                Vertex nextVertex = vertexs[edge.getTid()];
                if (minVertex.getDist() + edge.getWeight() < nextVertex.getDist()) {
                    nextVertex.setDist(minVertex.getDist() + edge.getWeight()); // 更新 nextVertex .dist
                    predecessor[nextVertex.getId()] = minVertex.getId();
                    if (inQueue[nextVertex.getId()]) {
                        pq.update(nextVertex); //更新队列中   dist值
                    } else {
                        //记录 已经被访问过
                        inQueue[nextVertex.getId()] = true;
                        pq.add(nextVertex);
                    }
                }
            }
        }
        // 打印最短路径
        final Vertex minVertex = pq.poll();
        System.out.println(minVertex.getDist());
        print(predecessor, s, t);
        return minVertex.getDist();
    }

    private void print(int[] predecessor, int s, int t) {
        //terminate
        if (s == t) {
            return;
        }
        print(predecessor, s, predecessor[t]);
        System.out.print("->" + t);
    }
}

/**
 * 自定义实现的的 优先级队列 </br>
 * 由于 java提供的  优先级队列 不支持 更新操作,所以这里 自定义了一个
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-14 18:10
 * @since
 */
class PriorityQueue {//构建一个小顶堆
    private Vertex[] nodes;

    private int count;

    public PriorityQueue(int v) {
        this.nodes = new Vertex[v];
        this.count = 0;
    }

    public Vertex poll() {
        Vertex minVertex = nodes[0];
        swap(nodes, 0, --count);
        heapifyDown(nodes, 0);
        return minVertex;
    }

    private void heapifyDown(Vertex[] nodes, int idx) {
        int minIdx = idx;
        if (leftChild(idx) < count && nodes[leftChild(idx)].getDist() < nodes[idx].getDist()) {
            minIdx = leftChild(idx);
        }
        if (rightChild(idx) < count && nodes[rightChild(idx)].getDist() < nodes[idx].getDist()) {
            minIdx = rightChild(idx);
        }
        // terminate
        if (minIdx == idx) {
            return;
        }
        swap(nodes, idx, minIdx);
        heapifyDown(nodes, minIdx);
    }

    public void add(Vertex vertex) {
        if (count == 0) {
            nodes[count++] = vertex;
            return;
        }
        nodes[count++] = vertex;
        heapifyUp(count, vertex);
    }

    private void heapifyUp(int idx, Vertex vertex) {
        if (idx <= 0 || nodes[parent(idx)].getDist() < vertex.getDist()) {
            return;
        }
        swap(nodes, idx, parent(idx));
        heapifyUp(parent(idx), vertex);
    }

    private void swap(Vertex[] nodes, int i, int j) {
        Vertex temp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = temp;
    }

    public void update(Vertex vertex) {

    }

    public int parent(int idx) {
        return (idx - 1) / 2;
    }

    public int leftChild(int idx) {
        return idx * 2 + 1;
    }

    public int rightChild(int idx) {
        return idx * 2 + 2;
    }

    public boolean isEmpty() {
        return nodes != null && nodes.length > 0;
    }
}

