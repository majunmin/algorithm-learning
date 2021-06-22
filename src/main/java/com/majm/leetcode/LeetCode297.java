package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * @author majunmin
 * @description
 * @datetime 2020/11/4 11:28 上午
 * @since
 */
public class LeetCode297 implements Solution {


}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sBuilder = new StringBuilder("[");

        if (root == null) {
            return sBuilder.append("]").toString();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        sBuilder.append(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    continue;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    sBuilder.append(",");
                    sBuilder.append(node.left.val);
                } else {
                    sBuilder.append(",null");
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    sBuilder.append(",");
                    sBuilder.append(node.right.val);
                } else {
                    sBuilder.append(",null");
                }
            }
        }
        return sBuilder.append("]").toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() < 3) {
            return null;
        }
        String[] rawDataStr = data.substring(1, data.length() - 1).split(",");
        if (rawDataStr.length == 1) {
            return parseTreeNode(rawDataStr[0]);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode root = parseTreeNode(rawDataStr[index++]);
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = queue.poll();
            while (size > 0) {
                size--;
                TreeNode leftNode = parseTreeNode(rawDataStr[index++]);
                TreeNode rightNode = parseTreeNode(rawDataStr[index++]);
                node.left = leftNode;
                node.right = rightNode;
                if (leftNode != null) {
                    queue.offer(leftNode);
                }
                if (rightNode != null) {
                    queue.offer(rightNode);
                }
            }
        }
        return root;
    }

    public TreeNode parseTreeNode(String data) {
        if ("null".equals(data)) {
            return null;
        }
        return new TreeNode(Integer.valueOf(data));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
