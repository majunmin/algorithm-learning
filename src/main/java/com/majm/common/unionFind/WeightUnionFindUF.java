package com.majm.common.unionFind;

/**
 * 带权重的 并查集(将小树 挂到 大树上) </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-13 09:01
 * @since
 */
public class WeightUnionFindUF implements UF {

    private int[] elements;
    private int count;
    private int[] weight;  // 记录根节点  对应的元素数是多少

    public WeightUnionFindUF(int size) {
        elements = new int[size];
        weight = new int[size];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = i;
            weight[i] = 1;
        }
        this.count = size;
    }

    @Override
    public int find(int p) {
        // 边界条件
        int curVal = p;
        while (elements[curVal] != curVal) {
            curVal = elements[curVal];
        }
        return curVal;
    }

    @Override
    public int count() {
        return count;
    }

    private int weight(int p) {
        return weight[find(p)];
    }

    @Override
    public void union(int p, int q) {
        int pParent = find(p);
        int qParent = find(q);
        if (pParent == qParent) {
            return;
        }
        if (weight[pParent] < weight[qParent]) {
            elements[pParent] = qParent;
            weight[pParent] += weight[qParent];
        } else {
            elements[qParent] = pParent;
            weight[qParent] += weight[pParent];
        }
        count--;
    }
}
