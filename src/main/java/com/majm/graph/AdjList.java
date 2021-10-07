package com.majm.graph;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

/**
 * 邻接表 表示的非带权无向图 </br>
 * <p>
 * 数组拉一个链表的形式
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-12 10:13
 * @since
 */
@Getter
public class AdjList {

    // 顶点个数
    private int v;

    private List<Integer>[] list;

    public AdjList(int v) {
        this.v = v;
        list = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int i, int j) {
        list[i].add(j);
        list[j].add(i);
    }
}
