package com.majm.common.unionFind;

/**
 * QuickFind </br>
 * <p>
 * 将联通的节点 的数字 保持是一样的
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-13 08:28
 * @since
 */
public class QuickFindUF implements UF {

    private int[] elements;

    private int count;

    public QuickFindUF(int size) {
        this.elements = new int[size];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = i;
        }
        this.count = size;
    }


    @Override
    public int find(int p) {
        return elements[p];
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void union(int p, int q) {
        if (find(p) == find(q)) {
            return;
        }
        // 遍历 与 q相连通的节点 , 将其值修改为  与  p相连
        // O(N)  -- 需要改进
        for (int i = 0; i < elements.length; i++) {
            int val = find(q);
            if (elements[i] == val) {
                elements[i] = find(p);
            }
        }
        count--;
    }
}
