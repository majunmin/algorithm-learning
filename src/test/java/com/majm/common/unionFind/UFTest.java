package com.majm.common.unionFind;

import org.junit.Before;
import org.junit.Test;


public class UFTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testUF() {
        UF uf = new QuickFindUF(20);
        System.out.println(uf.count());

        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(7, 8);
        uf.union(14, 13);
        System.out.println(uf.count());
        uf.union(12, 13);
        System.out.println(uf.count());

        uf = new UnionFindUF(20);
        System.out.println(uf.count());

        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(7, 8);
        uf.union(14, 13);
        System.out.println(uf.count());

        uf.union(12, 13);
        System.out.println(uf.count());


        uf = new WeightUnionFindUF(20);
        System.out.println(uf.count());

        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(7, 8);
        uf.union(14, 13);
        System.out.println(uf.count());

        uf.union(12, 13);
        System.out.println(uf.count());

    }
}