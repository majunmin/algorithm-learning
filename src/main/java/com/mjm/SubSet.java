package com.mjm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-01-28 21:58
 * @since
 */
public class SubSet {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3,4,5,6,7,8}));
    }


    public static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());

        Arrays.sort(S);
        for(int i : S) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<Integer>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }
}
