package com.majm.structor.tree;

/**
 * 线段树 </br>
 * <p>
 * 用来统计区间统计问题(区间的 计数,  区间最大值/最小值, )
 * 线段树是一个完全二叉树,所以可以用 数组表示
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-24 17:42
 * @since
 */
public class SegmentTree {

    private Segment[] segments;
    private int m;

    public SegmentTree(int size) {
        this.m = size;
        this.segments = new Segment[4 * m];
        buildSegmentTreeInternal(1, m, 1);
    }

    /**
     * 构建 线段树
     *
     * @param left
     * @param right
     * @param i
     */
    private void buildSegmentTreeInternal(int left, int right, int i) {
        if (left > right) {
            return;
        }
        segments[i] = new Segment();
        segments[i].left = left;
        segments[i].right = right;

        int mid = left + (right - left) / 2;
        buildSegmentTreeInternal(left, mid, 2 * i + 1);
        buildSegmentTreeInternal(mid + 1, right, 2 * i + 2);
    }

    public void insert(int data) {
        int left = 1;
        int right = m;
        int i = 1;
        while (left != right) {
            Segment segment = segments[i];
            segment.count++;
            int mid = left + (right - left) / 2;
            if (mid > data) {
                i = 2 * i + 1;
                right = mid;
            }
            if (mid < data) {
                i = 2 * i + 2;
                left = mid + 1;
            }
        }
        segments[i].count++;
    }


    public void delete(int data) {
        int left = 1;
        int right = m;
        int i = 1;
        while (left < right) {
            Segment segment = segments[i];
            segment.count--;
            int mid = left + (right - left) / 2;
            if (mid < data) {
                i = 2 * i + 1;
                left = mid + 1;
            } else {
                i = 2 * i;
                right = mid;
            }
        }
        segments[i].count--;
    }

    private int count(int left, int right) {
        return countInternal(left, right, 1);
    }

    private int countInternal(int left, int right, int i) {
        // terminate
        if (segments[i].left == left && segments[i].right == right) {
            return segments[i].count;
        }

        int mid = segments[i].left + (segments[i].right - segments[i].left) / 2;
        if (left > mid) {
            return countInternal(left, right, 2 * i + 1);
        } else if (right <= mid) {
            return countInternal(left, right, 2 * i);
        } else {
            return countInternal(left, mid, 2 * i)
                    + countInternal(mid + 1, right, 2 * i + 1);
        }
    }


    private class Segment {
        private int left; // 区间 左边界
        private int right;// 区间 右边界
        private int count;// 统计值
    }

}
