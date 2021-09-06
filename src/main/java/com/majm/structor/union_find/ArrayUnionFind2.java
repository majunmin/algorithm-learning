package com.majm.structor.union_find;

/**
 * 数组实现的  unionFind 并查集 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-24 17:31
 * @since
 */
public class ArrayUnionFind2 {

    private int[] p;
    private int[] rank; // 节点的树的秩

    public ArrayUnionFind2(int size) {
        this.p = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            p[i] = i;
            rank[i] = 1;
        }
    }

    public void union(int i, int j) {
        if (find(i, j)) {
            return;
        }
        if (rank[i] > rank[j]) {
            p[j] = i;
        } else if (rank[i] < rank[j]) {
            p[i] = j;
        } else {
            p[i] = j;
            rank[j]++;
        }

    }

    public boolean find(int i, int j) {
        return findP(i) == findP(j);
    }

    private int findP(int i) {
        //为更新秩, 不影响结果正确性
        if (i != p[i]) {
            p[i] = findP(p[i]);
        }
        return p[i];
    }
}
