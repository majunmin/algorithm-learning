package com.majm.graph;

import lombok.Getter;

/**
 * 邻接矩阵 </br>
 * 表示非带权无向图
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-12 10:11
 * @since
 */
@Getter
public class AdjMatrix {

    //    顶点个数
    private int v;

    private boolean[][] matrix;

    public AdjMatrix(int v) {
        this.v = v;
        matrix = new boolean[v][v];
    }

    public void addEdge(int i, int j) {
        matrix[i][j] = true;
        matrix[j][i] = true;
    }


}
