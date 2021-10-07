package com.majm.graph.dijkstra;

/**
 * 顶点 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-14 18:06
 * @since
 */
public class Vertex {

    private int id; // 顶点id
    private int dist; // 起始顶点到这个顶点的距离

    public Vertex(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }
}
