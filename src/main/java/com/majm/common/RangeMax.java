package com.majm.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 区间覆盖 </br>
 * 假设有n个 区间, 分别是
 * [l1, r1],  [l2, r2],  [l3, r3],  [l4, r4]
 * <p>
 * 从 这n个区间选出  某些区间,要求 互不重叠,最多能选出 多少区间呢?
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-03 23:32
 * @since
 */
public class RangeMax {

    public List<Interval> findMaxNumInterval(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals);

        int prevIntervalRight = -1;
        for (Interval interval : intervals) {
            if (interval.left >= prevIntervalRight) {
                result.add(interval);
            }
        }

        return result;
    }


    public static class Interval implements Comparable<Interval> {

        private Integer left;
        private Integer right;

        public Interval(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Interval o) {
            return this.left - o.left;
        }
    }
}
