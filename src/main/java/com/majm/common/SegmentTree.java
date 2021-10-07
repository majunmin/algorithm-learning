package com.majm.common;

/**
 * 线段树 </br>
 * SegmentTree
 * 用于高效的做区间统计
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-21 10:42
 * @since
 */
public class SegmentTree {

    private int m;
    private Segment[] segments;

    public SegmentTree(int m) {
        this.m = m;
        this.segments = new Segment[4 * m];
        buildSegmentTree(1, m, 1);

    }

    private void buildSegmentTree(int left, int right, int idx) {

        Segment root = new Segment(left, right);
        segments[idx] = root;
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        buildSegmentTree(left, mid, 2 * idx);
        buildSegmentTree(mid + 1, right, 2 * idx + 1);
    }

    // query
    public int count(int left, int right) {
        return countInternal(left, right, 1);
    }

    private int countInternal(int left, int right, int idx) {
        // terminate
        if (segments[idx].left == left && segments[idx].right == right) {
            return segments[idx].count;
        }
        int mid = left + (right - left) / 2;
        if (left > mid) {
            return countInternal(left, right, 2 * idx + 1);
        } else if (right <= mid) {
            return countInternal(left, right, 2 * idx);
        } else {
            return countInternal(left, mid, 2 * idx) + countInternal(mid + 1, right, 2 * idx + 1);
        }

    }

    public void insert(int data) {
        int left = 1;
        int right = m;
        int i = 1;
        while (left < right) {
            segments[i].count++;
            int mid = left + (right - left) / 2;
            if (data <= mid) {
                right = mid;
                i = 2 * i;
            } else {
                left = mid + 1;
                i = 2 * i + 1;
            }
        }
        segments[i].count++;
    }

    public void delete(int data) {
        int left = 1;
        int right = m;
        int i = 1;
        while (left < right) {
            segments[i].count--;
            int mid = left + (right - left) / 2;
            if (data <= mid) {
                right = mid;
                i = 2 * i;
            } else {
                left = mid + 1;
                i = 2 * i + 1;
            }
        }
        // left == right
        segments[i].count--;
    }

    private class Segment {
        private int left; // 区间左边界
        private int right; // 区间右边界
        private int count; // 统计值

        public Segment(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
