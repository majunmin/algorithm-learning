package com.majm;

import com.majm.common.ListNode;
import com.majm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/20 4:05 下午
 * @since
 */
public interface Solution {

    /**
     * 5. 最长回文子串
     * https://leetcode-cn.com/problems/longest-palindromic-substring/5. 最长回文子串
     *
     * @param s
     * @return
     */
    default String longestPalindrome(String s) {
        return "";
    }

    /**
     * 53. 最大子序和
     * https://leetcode-cn.com/problems/maximum-subarray/
     *
     * @param nums
     * @return
     */
    default int maxSubArray(int[] nums) {
        return 0;
    }


    /**
     * 62. 不同路径
     * https://leetcode-cn.com/problems/unique-paths/
     *
     * @param m
     * @param n
     * @return
     */
    default int uniquePaths(int m, int n) {
        return 0;
    }

    /**
     * 63. 不同路径 II
     * https://leetcode-cn.com/problems/unique-paths-ii/
     *
     * @param obstacleGrid
     * @return
     */
    default int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return 0;
    }

    /**
     * 64. 最小路径和
     * https://leetcode-cn.com/problems/minimum-path-sum/
     *
     * @param grid
     * @return
     */
    default int minPathSum(int[][] grid) {
        return 0;
    }


    /**
     * letcode 66
     * <p>
     * plus One
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * ```
     * 示例 1:
     * <p>
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     * <p>
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     *
     * @param digits
     */
    default int[] plusOne(int[] digits) {
        return null;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * <p>
     * 1. 必须在原数组上操作，不能拷贝额外的数组。
     * 2. 尽量减少操作次数。
     *
     * @param nums
     */
    default void moveZeroes(int[] nums) {
    }

    default int maxArea(int[] height) {
        return 0;
    }

    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     * @return
     */
    default int[] twoSum(int[] nums, int target) {
        return null;
    }

    /**
     * 15. 三数之和
     * <p>
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * 示例：
     * <p>
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     *
     * @param nums
     * @return
     */
    default List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    /**
     * 18. 四数之和
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * <p>
     * 注意：
     * 答案中不可以包含重复的四元组。
     * <p>
     * 示例：
     * <p>
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     * <p>
     * 满足要求的四元组集合为：
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     *
     * @param nums
     * @param target
     * @return
     */
    default List<List<Integer>> fourSum(int[] nums, int target) {
        return null;
    }

    /**
     * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     *
     * @param nums   sortArray
     * @param target
     * @return
     */
    default int[] searchRange(int[] nums, int target) {
        return null;
    }

    default String reverseStr(String s, int k) {
        return "";
    }

    /**
     * 36. 有效的数独
     * https://leetcode-cn.com/problems/valid-sudoku/
     *
     * @param board
     * @return
     */
    default boolean isValidSudoku(char[][] board) {
        return false;
    }

    /**
     * 45. 跳跃游戏 II
     * https://leetcode-cn.com/problems/jump-game-ii/
     *
     * @param nums
     * @return
     */
    default int jump(int[] nums) {
        return 0;
    }

    /**
     * @param nums
     * @return
     */
    default int maxSubarraySumCircular(int[] nums) {
        return 0;
    }


    /**
     * https://leetcode-cn.com/problems/merge-sorted-array/
     * 88. 合并两个有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    default void merge(int[] nums1, int m, int[] nums2, int n) {
    }

    /**
     * 39. 组合总和
     * https://leetcode-cn.com/problems/combination-sum/
     *
     * @param candidates
     * @param target
     * @return
     */
    default List<List<Integer>> combinationSum(int[] candidates, int target) {
        return null;
    }


    /**
     * 40. 组合总和 II
     * https://leetcode-cn.com/problems/combination-sum-ii/
     *
     * @param candidates
     * @param target
     * @return
     */
    default List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return null;
    }

    /**
     * 72. 编辑距离
     * https://leetcode-cn.com/problems/edit-distance/
     *
     * @param word1
     * @param word2
     * @return
     */
    default int minDistance(String word1, String word2) {
        return 0;
    }

    /**
     * 96. 不同的二叉搜索树
     * https://leetcode-cn.com/problems/unique-binary-search-trees/
     *
     * @param n
     * @return
     */
    default int numTrees(int n) {
        return 0;
    }

    /**
     * @param root
     * @return
     */
    default boolean isBalanced(TreeNode root) {
        return false;
    }


    /**
     * 118. 杨辉三角
     * Vhttps://leetcode-cn.com/problems/pascals-triangle/
     *
     * @param numRows
     * @return
     */
    default List<List<Integer>> generate(int numRows) {
        return null;
    }

    /**
     * 119. 杨辉三角 II
     * https://leetcode-cn.com/problems/pascals-triangle-ii/
     *
     * @param rowIndex
     * @return
     */
    default List<Integer> getRow(int rowIndex) {
        return null;
    }

    /**
     * 135. 分发糖果
     * https://leetcode-cn.com/problems/candy/
     *
     * @param ratings
     * @return
     */
    default int candy(int[] ratings) {
        return 0;
    }

    /**
     * 206. 反转链表
     * 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     * @param head
     * @return
     */
    default ListNode reverseList(ListNode head) {
        return null;
    }


    /**
     * 221. 最大正方形
     * https://leetcode-cn.com/problems/maximal-square/
     *
     * @param matrix
     * @return
     */
    default int maximalSquare(char[][] matrix) {
        return 0;
    }

    /**
     * 264. 丑数 II
     * https://leetcode-cn.com/problems/ugly-number-ii/
     *
     * @param n
     * @return
     */
    default int nthUglyNumber(int n) {
        return 0;
    }


    /**
     * 74. 搜索二维矩阵
     * https://leetcode-cn.com/problems/search-a-2d-matrix/
     *
     * @param matrix
     * @param target
     * @return
     */
    default boolean searchMatrix(int[][] matrix, int target) {
        return false;
    }


    /**
     * 91. 解码方法
     * https://leetcode-cn.com/problems/decode-ways/
     *
     * @param s
     * @return
     */
    default int numDecodings(String s) {
        return 0;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-linked-list-ii/
     * 92. 反转链表 II
     *
     * @param head  head
     * @param left
     * @param right
     * @return
     */
    default ListNode reverseBetween(ListNode head, int left, int right) {
        return null;
    }

    /**
     * 141. [环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)
     * 给定一个链表，判断链表中是否有环。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     * <p>
     * <p>
     * 进阶：
     * 你能用 O(1)（即，常量）内存解决此问题吗？
     *
     * @param head
     * @return
     */
    default boolean hasCycle(ListNode head) {
        return false;
    }


    default ListNode mergeKLists(ListNode[] lists) {
        return null;
    }

    /**
     * 152. 乘积最大子数组
     * https://leetcode-cn.com/problems/maximum-product-subarray/
     *
     * @param nums
     * @return
     */
    default int maxProduct(int[] nums) {
        return 0;
    }


    /**
     * 153. 寻找旋转排序数组中的最小值
     * 154. 寻找旋转排序数组中的最小值 II
     * <p>
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
     *
     * @param nums
     * @return
     */
    default int findMin(int[] nums) {
        return 0;
    }


    /**
     * 24. 两两交换链表中的节点
     * <p>
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 示例 2：
     * <p>
     * 输入：head = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [1]
     * 输出：[1]
     *
     * @param head
     * @return
     */
    default ListNode swapPairs(ListNode head) {
        return null;
    }

    /**
     * @param n
     * @return
     */
    default int firstBadVersion(int n) {
        return 0;
    }

    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->4, 1->3->4
     * 输出: 1->1->2->3->4->4
     *
     * @param l1
     * @param l2
     * @return
     */
    default ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return null;
    }

    /**
     * 139. 单词拆分
     * https://leetcode-cn.com/problems/word-break/
     *
     * @param s
     * @param wordDict
     * @return
     */
    default boolean wordBreak(String s, List<String> wordDict) {
        return true;
    }


    /**
     * 217. 存在重复元素
     * https://leetcode-cn.com/problems/contains-duplicate/
     *
     * @param nums
     * @return
     */
    default boolean containsDuplicate(int[] nums) {
        return false;
    }

    /**
     * LeetCode 0076
     * https://leetcode-cn.com/problems/minimum-window-substring/
     *
     * @param s
     * @param t
     * @return
     */
    default String minWindow(String s, String t) {
        return "";
    }

    /**
     * 299. 猜数字游戏
     * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
     * <p>
     * 你写出一个秘密_数字，并请朋友猜这个数字是多少。
     * 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
     * 朋友根据提示继续猜，直到猜出秘密数字。
     * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。
     * <p>
     * xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
     * yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
     * 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: secret = "1807", guess = "7810"
     * 输出: "1A3B"
     * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
     * 示例 2:
     * <p>
     * 输入: secret = "1123", guess = "0111"
     * 输出: "1A1B"
     * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
     * <p>
     * <p>
     * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
     *
     * @param secret
     * @param guess
     * @return
     */
    default String getHint(String secret, String guess) {
        return null;
    }

    /**
     * 376. 摆动序列
     * https://leetcode-cn.com/problems/wiggle-subsequence/
     *
     * @param nums
     * @return
     */
    default int wiggleMaxLength(int[] nums) {
        return 0;
    }


    /**
     * 413. 等差数列划分
     * https://leetcode-cn.com/problems/arithmetic-slices/
     *
     * @param nums
     * @return
     */
    default int numberOfArithmeticSlices(int[] nums) {
        return 0;
    }

    /**
     * 447. 回旋镖的数量
     * https://leetcode-cn.com/problems/number-of-boomerangs/
     *
     * @param points
     * @return
     */
    default int numberOfBoomerangs(int[][] points) {
        return 0;
    }

    default int longestPalindromeSubseq(String s) {
        return 0;
    }

    /**
     * 678. 有效的括号字符串
     * https://leetcode-cn.com/problems/valid-parenthesis-string/
     *
     * @param s
     * @return
     */
    default boolean checkValidString(String s) {
        return false;
    }


    /**
     * 797. 所有可能的路径
     * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
     *
     * @param graph
     * @return
     */
    default List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return new ArrayList<>();
    }


    /**
     * 931. 下降路径最小和
     * https://leetcode-cn.com/problems/minimum-falling-path-sum/
     *
     * @param matrix
     * @return
     */
    default int minFallingPathSum(int[][] matrix) {
        return 0;
    }

    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     * <p>
     * 输入: "{[]}"
     * 输出: true
     *
     * @param s
     * @return
     */
    default boolean isValid(String s) {
        return false;
    }


    /**
     * 120. 三角形最小路径和
     * https://leetcode-cn.com/problems/triangle/
     *
     * @param triangle
     * @return
     */
    default int minimumTotal(List<List<Integer>> triangle) {
        return 0;
    }


    /**
     * 121. 买卖股票的最佳时机
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     * <p>
     * 122. 买卖股票的最佳时机 II
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     * <p>
     * 123. 买卖股票的最佳时机 III
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
     * <p>
     * 309. 最佳买卖股票时机含冷冻期
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
     *
     * @param prices
     * @return
     */
    default int maxProfit(int[] prices) {
        return 0;
    }

    /**
     * 714. 买卖股票的最佳时机含手续费
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
     *
     * @param prices
     * @param fee
     * @return
     */
    default int maxProfit(int[] prices, int fee) {
        return 0;
    }

    /**
     * @param mat
     * @param r
     * @param c
     * @return
     */
    default int[][] matrixReshape(int[][] mat, int r, int c) {
        return null;
    }

    default int largestRectangleArea(int[] heights) {
        return 0;
    }


    /**
     * 349. 两个数组的交集
     * https://leetcode-cn.com/problems/intersection-of-two-arrays/
     *
     * @param nums1
     * @param nums2
     * @return
     */
    default int[] intersection(int[] nums1, int[] nums2) {
        return null;
    }

    /**
     * 350. 两个数组的交集 II
     *
     * @param nums1
     * @param nums2
     * @return
     */
    default int[] intersect(int[] nums1, int[] nums2) {
        return null;
    }

    /**
     * 438. 找到字符串中所有字母异位词
     * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
     *
     * @param s
     * @param p
     * @return
     */
    default List<Integer> findAnagrams(String s, String p) {
        return null;
    }


    /**
     * 443. 压缩字符串
     * <p>
     * https://leetcode-cn.com/problems/string-compression/
     *
     * @param chars
     * @return
     */
    default int compress(char[] chars) {
        return 0;
    }

    /**
     * 26. 删除排序数组中的重复项
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 给定数组 nums = [1,1,2],
     * <p>
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * <p>
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * <p>
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * <p>
     * 说明:
     * <p>
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * <p>
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * <p>
     * 你可以想象内部操作如下:
     * <p>
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     * <p>
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
     * for (int i = 0; i < len; i++) {
     * print(nums[i]);
     * }
     *
     * @param nums
     * @return
     */
    default int removeDuplicates(int[] nums) {
        return -1;
    }

    default int trap(int[] height) {
        return 0;
    }

    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     * <p>
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     *
     * @param s
     * @param t
     * @return
     */
    default boolean isAnagram(String s, String t) {
        return false;
    }

    /**
     * 198. 打家劫舍
     * https://leetcode-cn.com/problems/house-robber/
     *
     * @param nums
     * @return
     */
    default int rob(int[] nums) {
        return 0;
    }

    /**
     * 234. 回文链表
     * https://leetcode-cn.com/problems/palindrome-linked-list/
     *
     * @param head
     * @return
     */
    default boolean isPalindrome(ListNode head) {
        return false;
    }

    /**
     * 740. 删除并获得点数
     * https://leetcode-cn.com/problems/delete-and-earn/
     *
     * @param nums
     * @return
     */
    default int deleteAndEarn(int[] nums) {
        return 0;
    }

    /**
     * 789. 逃脱阻碍者
     * https://leetcode-cn.com/problems/escape-the-ghosts/
     *
     * @param ghosts
     * @param target
     * @return
     */
    default boolean escapeGhosts(int[][] ghosts, int[] target) {
        return false;
    }

    /**
     * 881. 救生艇
     * https://leetcode-cn.com/problems/boats-to-save-people/
     *
     * @param people
     * @param limit
     * @return
     */
    default int numRescueBoats(int[] people, int limit) {
        return 0;
    }

    /**
     * 1207. 独一无二的出现次数
     * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
     * <p>
     * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [1,2,2,1,1,3]
     * 输出：true
     * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
     * 示例 2：
     * <p>
     * 输入：arr = [1,2]
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
     * 输出：true
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= arr.length <= 1000
     * -1000 <= arr[i] <= 1000
     *
     * @param arr
     * @return
     */
    default boolean uniqueOccurrences(int[] arr) {
        return false;
    }


    /**
     * 509. 斐波那契数
     * https://leetcode-cn.com/problems/fibonacci-number/
     *
     * @param n
     * @return
     */
    default int fib(int n) {
        return 0;
    }

    /**
     * 567. 字符串的排列
     * https://leetcode-cn.com/problems/permutation-in-string/
     *
     * @param s1
     * @param s2
     * @return
     */
    default boolean checkInclusion(String s1, String s2) {
        return false;
    }

    default int tribonacci(int n) {
        return 0;
    }

    /**
     * 746. 使用最小花费爬楼梯
     * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
     *
     * @param cost
     * @return
     */
    default int minCostClimbingStairs(int[] cost) {
        return 0;
    }

    /**
     * 49. 字母异位词分组
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * <p>
     * 示例:
     * <p>
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * 说明：
     * <p>
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     *
     * @param strs
     * @return
     */
    default List<List<String>> groupAnagrams(String[] strs) {
        return null;
    }

    /**
     * 1021. 删除最外层的括号
     * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
     * <p>
     * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
     * <p>
     * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
     * <p>
     * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入："(()())(())"
     * 输出："()()()"
     * 解释：
     * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
     * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
     * 示例 2：
     * <p>
     * 输入："(()())(())(()(()))"
     * 输出："()()()()(())"
     * 解释：
     * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
     * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
     * 示例 3：
     * <p>
     * 输入："()()"
     * 输出：""
     * 解释：
     * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
     * 删除每个部分中的最外层括号后得到 "" + "" = ""。
     * <p>
     * <p>
     * 提示：
     * <p>
     * S.length <= 10000
     * S[i] 为 "(" 或 ")"
     * S 是一个有效括号字符串
     *
     * @param S
     * @return
     */
    default String removeOuterParentheses(String S) {
        return null;
    }

    /**
     * 94. 二叉树的中序遍历
     * 给定一个二叉树，返回它的中序 遍历。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * 输出: [1,3,2]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * @param root
     * @return
     */
    default List<Integer> inorderTraversal(TreeNode root) {
        return null;
    }

    /**
     * 412. Fizz Buzz
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     * <p>
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     * <p>
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     * <p>
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     * <p>
     * 示例：
     * <p>
     * n = 15,
     * <p>
     * 返回:
     * [
     * "1",
     * "2",
     * "Fizz",
     * "4",
     * "Buzz",
     * "Fizz",
     * "7",
     * "8",
     * "Fizz",
     * "Buzz",
     * "11",
     * "Fizz",
     * "13",
     * "14",
     * "FizzBuzz"
     * ]
     *
     * @param n
     * @return
     */
    default List<String> fizzBuzz(int n) {
        return null;
    }

    /**
     * 239. 滑动窗口最大值
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回滑动窗口中的最大值。
     * <p>
     * <p>
     * <p>
     * 进阶：
     * <p>
     * 你能在线性时间复杂度内解决此题吗？
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     * <p>
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     * 1 <= k <= nums.length
     *
     * @param nums
     * @param k
     * @return
     */
    default int[] maxSlidingWindow(int[] nums, int k) {
        return null;

    }


    /**
     * 300. 最长递增子序列
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/
     *
     * @param nums
     * @return
     */
    default int lengthOfLIS(int[] nums) {
        return 0;
    }

    /**
     * @param num
     * @return
     */
    default int addDigits(int num) {
        return 0;
    }

    /**
     * 347. 前 K 个高频元素
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     * <p>
     * 输入: nums = [1], k = 1
     * 输出: [1]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
     * 你可以按任意顺序返回答案。
     *
     * @param nums
     * @param k
     * @return
     */
    default int[] topKFrequent(int[] nums, int k) {
        return null;
    }

    /**
     * 144. 二叉树的前序遍历
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     * <p>
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     *
     * @param root
     * @return
     */
    default List<Integer> preorderTraversal(TreeNode root) {
        return null;
    }

    /**
     * 145. 二叉树的后序遍历
     * 给定一个二叉树，返回它的 后序 遍历。
     *
     * @param root
     * @return
     */
    default List<Integer> postorderTraversal(TreeNode root) {
        return null;
    }

    /**
     * 104. 二叉树的最大深度
     * 给定一个二叉树，找出其最大深度。
     * <p>
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     *
     * @param root
     * @return
     */
    default int maxDepth(TreeNode root) {
        return 0;
    }

    /**
     * 322. 零钱兑换
     * https://leetcode-cn.com/problems/coin-change/
     *
     * @param coins
     * @param amount
     * @return
     */
    default int coinChange(int[] coins, int amount) {
        return 0;
    }

    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     * <p>
     * 示例 1：
     * <p>
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     * <p>
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     *
     * @param n
     * @return
     */
    default int climbStairs(int n) {
        return 0;
    }

    /**
     * 22. 括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：n = 3
     * 输出：[
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     *
     * @param n
     * @return
     */
    default List<String> generateParenthesis(int n) {
        return null;
    }


    /**
     * 941. [有效的山脉数组](https://leetcode-cn.com/problems/valid-mountain-array/)
     * <p>
     * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
     * <p>
     * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
     * <p>
     * A.length >= 3
     * 在 0 < i < A.length - 1 条件下，存在 i 使得：
     * A[0] < A[1] < ... A[i-1] < A[i]
     * A[i] > A[i+1] > ... > A[A.length - 1]
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[2,1]
     * 输出：false
     * 示例 2：
     * <p>
     * 输入：[3,5,5]
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：[0,3,2,1]
     * 输出：true
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= A.length <= 10000
     * 0 <= A[i] <= 10000
     *
     * @param A
     * @return
     */
    default boolean validMountainArray(int[] A) {
        return false;
    }

    /**
     * 226. 翻转二叉树
     * 翻转一棵二叉树。
     * <p>
     * 示例：
     * <p>
     * 输入：
     * <p>
     * 4
     * /   \
     * 2     7
     * / \   / \
     * 1   3 6   9
     * 输出：
     * <p>
     * 4
     * /   \
     * 7     2
     * / \   / \
     * 9   6 3   1
     * 备注:
     * 这个问题是受到 Max Howell 的 原问题 启发的 ：
     * <p>
     * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
     *
     * @param root
     * @return
     */
    default TreeNode invertTree(TreeNode root) {
        return null;
    }

    /**
     * 98. 验证二叉搜索树
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 假设一个二叉搜索树具有如下特征：
     * <p>
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 示例 1:
     * <p>
     * 输入:
     * 2
     * / \
     * 1   3
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:
     * 5
     * / \
     * 1   4
     * / \
     * 3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     * 根节点的值为 5 ，但是其右子节点值为 4 。
     *
     * @param root
     * @return
     */
    default boolean isValidBST(TreeNode root) {
        return false;
    }

    /**
     * 111. [二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
     * 给定一个二叉树，找出其最小深度。
     * <p>
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * <p>
     * 说明：叶子节点是指没有子节点的节点。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * 3
     * / \
     * 9  20
     * / \
     * 15   7
     * <p>
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     * 示例 2:
     * <p>
     * 输入:root = [2,null,3,null,4,null,5,null,6]
     * 输出:5
     * <p>
     * <p>
     * 提示：
     * <p>
     * 树中节点数的范围在 [0, 105] 内
     * -1000 <= Node.val <= 1000
     *
     * @param root
     * @return
     */
    default int minDepth(TreeNode root) {
        return 0;
    }

    /**
     * 236. 二叉树的最近公共祖先
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为: "对于有根树 T 的两个结点 p、q, 最近公共祖先表示为一个结点 x
     * ,满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）."
     * <p>
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * 示例 2:
     * <p>
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     * <p>
     * <p>
     * 说明:
     * <p>
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉树中。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    default TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * <p>
     * 注意:
     * 你可以假设树中没有重复的元素。
     * <p>
     * 例如, 给出
     * <p>
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder  = [9,3,15,20,7]
     * 返回如下的二叉树：
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     *
     * @param preorder
     * @param inorder
     * @return
     */
    default TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    /**
     * 46. 全排列
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     *
     * @param nums
     * @return
     */
    default List<List<Integer>> permute(int[] nums) {
        return null;
    }


    /**
     * 51. [N 皇后](https://leetcode-cn.com/problems/n-queens/)
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * <p>
     * <p>
     * <p>
     * 上图为 8 皇后问题的一种解法。
     * <p>
     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
     * <p>
     * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：4
     * 输出：[
     * [".Q..",  // 解法 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * <p>
     * ["..Q.",  // 解法 2
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     * 解释: 4 皇后问题存在两个不同的解法。
     * <p>
     * <p>
     * 提示:
     * <p>
     * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
     *
     * @param n 棋盘边长
     * @return
     */
    default List<List<String>> solveNQueens(int n) {
        return null;
    }

    /**
     * 50. Pow(x, n)
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * 示例 2:
     * <p>
     * 输入: 2.10000, 3
     * 输出: 9.26100
     * 示例 3:
     * <p>
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2-2 = 1/22 = 1/4 = 0.25
     * 说明:
     * <p>
     * -100.0 < x < 100.0
     * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
     *
     * @param x
     * @param n
     * @return
     */
    default double myPow(double x, int n) {
        return 0.0;
    }


    /**
     * 77. 组合
     * https://leetcode-cn.com/problems/combinations/
     *
     * @param n
     * @param k
     * @return
     */
    default List<List<Integer>> combine(int n, int k) {
        return null;
    }

    /**
     * 78. 子集
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * <p>
     * 说明：解集不能包含重复的子集。
     * <p>
     * 示例:
     * <p>
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     * [3],
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     * ]
     *
     * @param nums
     * @return
     */
    default List<List<Integer>> subsets(int[] nums) {
        return null;
    }


    /**
     * 90. 子集 II
     * https://leetcode-cn.com/problems/subsets-ii/
     *
     * @param nums
     * @return
     */
    default List<List<Integer>> subsetsWithDup(int[] nums) {
        return null;
    }


    /**
     * 17. [电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     *
     * @param digits
     * @return
     */
    default List<String> letterCombinations(String digits) {
        return null;
    }

    /**
     * 47. [全排列 II](https://leetcode-cn.com/problems/permutations-ii/)
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     *
     * @param nums
     * @return
     */
    default List<List<Integer>> permuteUnique(int[] nums) {
        return null;
    }

    /**
     * 102. 二叉树的层序遍历
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     * <p>
     * <p>
     * <p>
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    default List<List<Integer>> levelOrder(TreeNode root) {
        return null;
    }


    /**
     * 392. 判断子序列
     * https://leetcode-cn.com/problems/is-subsequence/
     *
     * @param s
     * @param t
     * @return
     */
    default boolean isSubsequence(String s, String t) {
        return false;
    }

    /**
     * 433. [最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description)
     * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
     * <p>
     * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
     * <p>
     * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
     * <p>
     * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
     * <p>
     * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
     * <p>
     * 注意:
     * <p>
     * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
     * 所有的目标基因序列必须是合法的。
     * 假定起始基因序列与目标基因序列是不一样的。
     * 示例 1:
     * <p>
     * start: "AACCGGTT"
     * end:   "AACCGGTA"
     * bank: ["AACCGGTA"]
     * <p>
     * 返回值: 1
     * 示例 2:
     * <p>
     * start: "AACCGGTT"
     * end:   "AAACGGTA"
     * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
     * <p>
     * 返回值: 2
     * 示例 3:
     * <p>
     * start: "AAAAACCC"
     * end:   "AACCCCCC"
     * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
     * <p>
     * 返回值: 3
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    default int minMutation(String start, String end, String[] bank) {
        return 0;
    }

    /**
     * 515. 在每个树行中找最大值
     * 您需要在二叉树的每一行中找到最大的值。
     * <p>
     * 示例：
     * <p>
     * 输入:
     * <p>
     * 1
     * / \
     * 3   2
     * / \   \
     * 5   3   9
     * <p>
     * 输出: [1, 3, 9]
     *
     * @param root
     * @return
     */
    default List<Integer> largestValues(TreeNode root) {
        return new ArrayList<>();
    }

    /**
     * 200. 岛屿数量
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：grid = [
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：grid = [
     * ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     * ]
     * 输出：3
     * <p>
     * <p>
     * 提示：
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] 的值为 '0' 或 '1'
     *
     * @param grid
     * @return
     */
    default int numIslands(char[][] grid) {
        return -1;
    }

    /**
     * 127. [单词接龙](https://leetcode-cn.com/problems/word-ladder/description/)
     * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
     * <p>
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典中的单词。
     * 说明:
     * <p>
     * 如果不存在这样的转换序列，返回 0。
     * 所有单词具有相同的长度。
     * 所有单词只由小写字母组成。
     * 字典中不存在重复的单词。
     * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     * 示例 1:
     * <p>
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * <p>
     * 输出: 5
     * <p>
     * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * 返回它的长度 5。
     * 示例 2:
     * <p>
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * <p>
     * 输出: 0
     * <p>
     * 解释: endWord "cog" 不在字典中，所以无法进行转换。
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    default int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return 0;
    }


    /**
     * leetcode 209. 长度最小的子数组
     * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
     *
     * @param target
     * @param nums
     * @return
     */
    default int minSubArrayLen(int target, int[] nums) {
        return 0;
    }


    /**
     * 455. 分发饼干
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     * <p>
     * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: g = [1,2,3], s = [1,1]
     * 输出: 1
     * 解释:
     * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
     * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
     * 所以你应该输出1。
     * 示例 2:
     * <p>
     * 输入: g = [1,2], s = [1,2,3]
     * 输出: 2
     * 解释:
     * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
     * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
     * 所以你应该输出2.
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= g.length <= 3 * 104
     * 0 <= s.length <= 3 * 104
     * 1 <= g[i], s[j] <= 231 - 1
     *
     * @param g
     * @param s
     * @return
     */
    default int findContentChildren(int[] g, int[] s) {
        return 0;
    }


    /**
     * 518. 零钱兑换 II
     * https://leetcode-cn.com/problems/coin-change-2/
     *
     * @param amount
     * @param coins
     * @return
     */
    default int change(int amount, int[] coins) {
        return 0;
    }


    /**
     * 55. 跳跃游戏
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个位置。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     * 示例 2:
     * <p>
     * 输入: [3,2,1,0,4]
     * 输出: false
     * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     *
     * @param nums
     * @return
     */
    default boolean canJump(int[] nums) {
        return false;
    }

    /**
     * 69. x 的平方根
     * 实现 int sqrt(int x) 函数。
     * <p>
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     * 由于返回类型是整数，小数部分将被舍去。
     *
     * @param x
     * @return
     */
    default int mySqrt(int x) {
        return 0;
    }

    /**
     * 367. [有效的完全平方数](https://leetcode-cn.com/problems/valid-perfect-square/)
     * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
     * <p>
     * 说明：不要使用任何内置的库函数，如  sqrt。
     * <p>
     * 示例 1：
     * <p>
     * 输入：16
     * 输出：True
     * 示例 2：
     * <p>
     * 输入：14
     * 输出：False
     *
     * @param num
     * @return
     */
    default boolean isPerfectSquare(int num) {
        return false;
    }

    /**
     * 33. 搜索旋转排序数组
     * 给你一个整数数组 nums ，和一个整数 target 。
     * <p>
     * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
     * <p>
     * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * 示例 2：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：nums = [1], target = 0
     * 输出：-1
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 5000
     * -10^4 <= nums[i] <= 10^4
     * nums 中的每个值都 独一无二
     * nums 肯定会在某个点上旋转
     * -10^4 <= target <= 10^4
     *
     * @param nums
     * @param target
     * @return
     */
    default int search(int[] nums, int target) {
        return -1;
    }

    /**
     * @param arr
     * @return
     */
    default int[] nextGreaterElement(int[] arr) {
        return null;
    }


    /**
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * <p>
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     * <p>
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     * <p>
     * https://leetcode-cn.com/problems/daily-temperatures/
     *
     * @param temperatures
     * @return
     */
    default int[] dailyTemperatures(int[] temperatures) {
        return null;
    }

    /**
     * 457. 环形数组是否存在循环
     * https://leetcode-cn.com/problems/circular-array-loop/
     *
     * @param nums
     * @return
     */
    default boolean circularArrayLoop(int[] nums) {
        return false;
    }


    /**
     * 1143. 最长公共子序列
     * https://leetcode-cn.com/problems/longest-common-subsequence/
     *
     * @param text1
     * @param text2
     * @return
     */
    default int longestCommonSubsequence(String text1, String text2) {
        return 0;
    }


    /**
     * 1567. 乘积为正数的最长子数组长度
     * https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product/
     *
     * @param nums
     * @return
     */
    default int getMaxLen(int[] nums) {
        return 0;
    }


    /**
     * leetcode 1210
     * https://leetcode-cn.com/problems/minimum-moves-to-reach-target-with-rotations/
     *
     * @param grid
     * @return
     */
    default int minimumMoves(int[][] grid) {
        return 0;
    }


    /**
     * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
     *
     * @param s
     * @return
     */
    default String removeDuplicates(String s) {
        return "";
    }


    /**
     * 189. 旋转数组
     * https://leetcode-cn.com/problems/rotate-array/
     *
     * @param nums
     * @param k
     */
    default void rotate(int[] nums, int k) {

    }


    /**
     * https://leetcode-cn.com/problems/sum-of-subarray-minimums/
     * 907. 子数组的最小值之和
     *
     * @param arr
     * @return
     */
    default int sumSubarrayMins(int[] arr) {
        return 0;
    }


    default int countPairs(int[] deliciousness) {
        return 0;
    }

    /**
     * 1314. 矩阵区域和
     * https://leetcode-cn.com/problems/matrix-block-sum/
     *
     * @param mat
     * @param k
     * @return
     */
    default int[][] matrixBlockSum(int[][] mat, int k) {
        return null;
    }

}
