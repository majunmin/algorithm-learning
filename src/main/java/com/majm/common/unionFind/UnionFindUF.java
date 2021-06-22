package com.majm.common.unionFind;

/**
 * UnionFind </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-13 08:44
 * @since
 */
public class UnionFindUF implements UF {

    private int[] elements;

    private int count;

    public UnionFindUF(int size) {
        this.count = size;
        elements = new int[count];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = i;
        }
    }

    @Override
    public int find(int p) {
        // 边界条件判断
        int curVal = p;
        while (curVal != elements[curVal]) {
            curVal = elements[curVal];
        }
        return curVal;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void union(int p, int q) {
        int pParent = find(p);
        int qParent = find(q);
        if (pParent == qParent) {
            return;
        }
        elements[qParent] = elements[pParent];
        count--;
    }
}
