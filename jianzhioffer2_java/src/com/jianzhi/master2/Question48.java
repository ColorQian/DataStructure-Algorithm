package com.jianzhi.master2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/h54YBf/
 * 剑指 Offer II 048. 序列化与反序列化二叉树
 */
public class Question48 {

    String SEP = ",";
    String NULL = "#";

    // 利用层序遍历, 将二叉树序列化为字符串
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            if (cur == null) {
                sb.append(NULL).append(SEP);
                continue;
            }

            sb.append(cur.val).append(SEP);

            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return sb.toString();
    }

    // 利用层序遍历, 将字符串反序列化成二叉树
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        String[] nodes = data.split(SEP);
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        queue.offer(root);
        TreeNode parent = null;
        for (int i = 1; i < nodes.length;) {      //用来记录当前遍历到了哪个节点
            parent = queue.poll();                // 队列中保存的是父节点

            String left = nodes[i];
            i++;
            if (left.equals(NULL)) {
                parent.left = null;
            } else {
                parent.left = new TreeNode(Integer.valueOf(left));
                queue.offer(parent.left);
            }

            String right = nodes[i];
            i++;
            if (right.equals(NULL)) {
                parent.right = null;
            } else {
                parent.right = new TreeNode(Integer.valueOf(right));
                queue.offer(parent.right);
            }
        }
        return root;
    }
}
