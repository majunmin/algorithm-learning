package com.majm.common.unionFind;

/**
 * 并查集
 */
public interface UF {

    int find(int p);

    int count();

    void union(int p, int q);
}
