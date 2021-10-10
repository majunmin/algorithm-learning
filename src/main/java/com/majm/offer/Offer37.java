package com.majm.offer;

import com.majm.common.TreeNode;
import com.sun.tools.javac.util.Assert;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 37. 序列化二叉树 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-10 00:42
 * @since
 */
public class Offer37 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        TreeNode rl = new TreeNode(3);
        r.left = rl;
        root.right = r;

        Codec codec = new Codec();
        System.out.println(codec.serialize(root));
        codec.deserialize(codec.serialize(root));
        codec.deserialize(codec.serialize(null));

    }
}


class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                result.add(node == null ? null : node.val);
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return result.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 3){
            return null;
        }
        String[] split = data.substring(1, data.length() - 1).split(",");

        List<Integer> list = Arrays.stream(split).map(item -> {
            if (Objects.equals(item, "null")) {
                return null;
            }
            return Integer.valueOf(item);
        }).collect(Collectors.toList());

        // restore  tree

        if (list.size() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(list.get(0));
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (index == list.size()) {
                break;
            }
            Integer leftVal = list.get(index++);
            if (Objects.nonNull(leftVal)) {
                node.left = new TreeNode(leftVal);
                queue.add(node.left);
            }

            if (index == list.size()) {
                break;
            }
            Integer rightVal = list.get(index++);
            if (Objects.nonNull(rightVal)) {
                node.right = new TreeNode(rightVal);
                queue.add(node.right);
            }
        }

        return root;
    }
}
