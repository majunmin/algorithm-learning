package com.majm.structor.union_find;

/**
 * 并查集 </br>
 * 数组实现
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-24 17:23
 * @since
 */
public class ArrayUnionFind {

    private int[] p;

    public ArrayUnionFind(int size) {
        p = new int[size];
        for (int i = 0; i < size; i++) {
            p[i] = i;
        }
    }

    public boolean find(int i, int j) {
        return findP(i) == findP(j);
    }

    public void union(int i, int j) {
        if (find(i, j)) {
            return;
        }
        p[findP(i)] = findP(j);
    }

    public int findP(int i) {
        if (p[i] != i) {
            p[i] = findP(p[i]);
        }
        return p[i];
    }
}