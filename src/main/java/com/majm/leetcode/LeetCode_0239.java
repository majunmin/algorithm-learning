package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/29 5:38 下午
 * @since
 */
public class LeetCode_0239 implements Solution {

    @Override
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] result = new int[len - k + 1];
        // store index 单调递减栈
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            offerEle(stack, i, nums);
        }
        result[0] = nums[stack.getLast()];
        for (int i = k; i < len; i++) {
            offerEle(stack, i, nums);
            if (stack.getLast() < i - k +1) {
                stack.removeLast();
            }
            result[i - k + 1] = nums[stack.getLast()];
        }
        return result;
    }

    private void offerEle(Deque<Integer> stack, int i, int[] nums) {
        while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
            stack.pop();
        }
        stack.push(i);
    }


    /**
     * 单调栈解决
     *
     * @param nums
     * @param k
     * @return
     */
    private int[] stackSolution(int[] nums, int k) {
        final LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            offerElement(nums, deque, i);
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = nums[deque.getFirst()];
        for (int i = k; i < nums.length; i++) {
            if (deque.getFirst() <= i - k) {
                deque.removeFirst();
            }
            deque.remove(i - k);
            offerElement(nums, deque, i);
            result[i - k + 1] = nums[deque.getFirst()];
        }
        return result;
    }

    private void offerElement(int[] nums, Deque<Integer> deque, int i) {
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
            deque.removeLast();
        }
        deque.addLast(i);
    }

    /**
     * 利用大顶堆
     * heap 寻找最大值
     *
     * @param nums
     * @param k
     * @return
     */
    private int[] solution6(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        Queue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            int start = i - k;
            if (start >= 0) {
                maxHeap.remove(nums[start]);
            }
            maxHeap.offer(nums[i]);
            if (maxHeap.size() == k) {
                result[i - k + 1] = maxHeap.peek();
            }

        }
        return result;
    }

    /**
     * 动态规划
     * 牛逼但看不懂 我自己肯定能写不出来  😄
     * 时间复杂度:
     * 空间复杂度:
     *
     * @param nums
     * @param k
     * @return
     */
    private int[] solution5(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;


        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) left[i] = nums[i];  // block_start
            else left[i] = Math.max(left[i - 1], nums[i]);

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
            else right[j] = Math.max(right[j + 1], nums[j]);
        }

        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);

        return output;

    }

    private int[] solution4(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[]{};
        }
        if (k == 1) {
            return nums;
        }
        int[] output = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 移除队尾 小于当前元素
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            // 把当前元素加入队列
            deque.addLast(i);

            //移除 窗口外的元素
            if (deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                output[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return output;
    }


    /**
     * 时间复杂度: O(N)
     * 空间复杂度: O(N) -> O(N-k+1) (输出数组) + O(K) (双向队列)
     * 队列中放数组下标
     * 1. 保证队列头部是最大值
     * 2. 遍历数组剩余的(每次滑动一格)
     * - 移除窗口外的 (下标 i - k)
     * - (小于当前值的 从 队列中移除)
     *
     * @param nums
     * @param k
     * @return
     */
    private int[] solution3(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[]{};
        }
        if (k == 1) {
            return nums;
        }

        int[] output = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        // 先确定第窗口最大值
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        output[0] = nums[deque.getFirst()];

        for (int i = k; i < n; i++) {
            if (!deque.isEmpty() && deque.getFirst() == i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            output[i - k + 1] = nums[deque.getFirst()];
        }
        return output;
    }


    // 存储索引
    Deque<Integer> deque = new ArrayDeque<>();
    int[] nums;

    /**
     * 官方的解答
     * 双端队列 (固定长度为 窗口长度 k)
     *
     * @param nums
     * @param k
     * @return
     */
    private int[] solution2(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[]{};
        }
        if (k == 1) {
            return nums;
        }
        this.nums = nums;

        // init deque and output
        int maxIdx = 0;
        for (int i = 0; i < k; i++) {
            cleanDeque(i, k);
            deque.addLast(nums[i]);
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        int[] output = new int[]{};
        output[0] = nums[maxIdx];

        // build output
        for (int i = k; i < n; i++) {
            cleanDeque(i, k);
            deque.addLast(i);
            output[i - k + 1] = nums[deque.getFirst()];
        }


        return output;
    }

    private void cleanDeque(int i, int k) {
        // 移除不在 窗口里面的元素
        if (!deque.isEmpty() && deque.getFirst() == i - k) {
            deque.removeFirst();
        }
        // 移除双端队列中所有小于当前元素nums[i] 的 element
        while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
            deque.removeLast();
        }
    }

    /**
     * 暴力解法 遍历
     * <p>
     * 时间复杂度: O(Nk)  (超时)
     * 空间复杂度: O(N-K+1)
     *
     * @param nums
     * @param k
     * @return
     */
    private int[] solution1(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[]{};
        }
        if (k == 1) {
            return nums;
        }


        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < k + i; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }


    public static void main(String[] args) {
        final LeetCode_0239 leetCode = new LeetCode_0239();
        System.out.println(Arrays.toString(leetCode.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(leetCode.maxSlidingWindow(new int[]{9, 11}, 2)));
    }
}
