package com.majm;

import com.majm.common.ListNode;
import com.majm.common.TreeNode;
import com.majm.leetcode.LeetCode_0023;
import com.majm.leetcode.LeetCode_0034;
import com.majm.leetcode.LeetCode_0076;
import com.majm.leetcode.LeetCode_0078;
import com.majm.leetcode.LeetCode_0088;
import com.majm.leetcode.LeetCode_0145;
import com.majm.leetcode.LeetCode_0209;
import com.majm.leetcode.LeetCode_0239;
import com.majm.leetcode.LeetCode_0102;
import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author majunmin
 * @description
 * @datetime 2021/2/20 11:50 上午
 * @since
 */
public class AppTest {


    @Test
    public void Test1() {
        String s1 = new String("中") + new String("国");
        s1.intern();
        String s2 = "中国";

        System.out.println(s1 == s2);
    }


    @Test
    public void TestReference() {
        String s3 = new String("hello world");

        WeakReference<String> wref = new WeakReference<>(new String("hellow world"));

        System.gc();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (wref.get() == null) {
            System.out.println("weak referece has been collected after gc");
        }
    }

    @Test
    public void testLeetCode88() {
        Solution leetCode = new LeetCode_0088();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        leetCode.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1));
    }

    @Test
    public void testLeetCode34() {
        Solution leetCode = new LeetCode_0034();
        int[] num1 = new int[]{1, 2, 5, 6, 9};
        int[] result = leetCode.searchRange(num1, 8);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testLeetCode0078() {
        Solution leetCode = new LeetCode_0078();
        final List<List<Integer>> result = leetCode.subsets(new int[]{1, 2, 3});
        System.out.println(result);
    }

    @Test
    public void testLeetCode102() {
        Solution leetCode = new LeetCode_0102();
        final TreeNode root = new TreeNode(3);
        TreeNode leftNode = new TreeNode(9);
        TreeNode rightNode = new TreeNode(20);
        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        root.left = leftNode;
        root.right = rightNode;
        rightNode.left = rl;
        rightNode.right = rr;
        System.out.println(leetCode.levelOrder(root));
    }

    @Test
    public void testLeetCode0145() {
        Solution leetCode = new LeetCode_0145();
        final TreeNode root = new TreeNode(3);
        TreeNode leftNode = new TreeNode(9);
        TreeNode rightNode = new TreeNode(20);
        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        root.left = leftNode;
        root.right = rightNode;
//        rightNode.left = rl;
//        rightNode.right = rr;
        System.out.println(leetCode.postorderTraversal(root));
    }

    @Test
    public void testLeetCode0239() {
        final LeetCode_0239 leetCode = new LeetCode_0239();
        System.out.println(Arrays.toString(leetCode.maxSlidingWindow(new int[]{7,2,4}, 2)));

    }

    @Test
    public void testLeetCode0023(){
        ListNode l1 = null;
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode l3 = null;
        ListNode l4 = new ListNode(1, new ListNode(5, new ListNode(9)));

        ListNode[] nodes = {l1, l2, l3, l4};
        LeetCode_0023 leetCode = new LeetCode_0023();
        leetCode.mergeKLists(nodes);
    }


    @Test
    public void testLeetCode0209(){
        LeetCode_0209 leetCode0209 = new LeetCode_0209();
        System.out.println(leetCode0209.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(leetCode0209.minSubArrayLen(22, new int[]{2,3,1,2,4,3}));
    }

    @Test
    public void testLeetCode0076(){
        LeetCode_0076 leetCode = new LeetCode_0076();
        System.out.println(leetCode.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(leetCode.minWindow("ADOBECODEBANC", "ABCZ"));
        System.out.println(leetCode.minWindow("a", "a"));
    }
}
