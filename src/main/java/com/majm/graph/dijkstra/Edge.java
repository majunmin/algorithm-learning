package com.majm.graph.dijkstra;

/**
 * 边 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-14 18:03
 * @since
 */
public class Edge {

    private int weight;
    private int sid;
    private int tid;

    public Edge(int sid, int tid, int weight) {
        this.sid = sid;
        this.tid = tid;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
}
