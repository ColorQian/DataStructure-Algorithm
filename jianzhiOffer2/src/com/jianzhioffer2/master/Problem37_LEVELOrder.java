package com.jianzhioffer2.master;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * 297. 二叉树的序列化与反序列化
 *
 * 参考：https://mp.weixin.qq.com/s/qGqIWM2hmL1xewygPnb3Og
 */
public class Problem37_LEVELOrder {
    String SEP = ",";
    String NULL = "#";

    // 利用层序遍历，将二叉树序列化为String
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

    // 还是利用层序遍历的思想，将序列化的String，反序列化为树
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] nodes = data.split(SEP);

        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < nodes.length;) {  // 用来记录遍历到了哪一个 节点字符
            TreeNode parent = queue.poll();   // 队列中保存的都是父节点

            String left = nodes[i++];
            if (!left.equals(NULL)) {
                parent.left = new TreeNode(Integer.valueOf(left));
                queue.offer(parent.left);
            } else {
                parent.left = null;
            }

            String right = nodes[i++];
            if (!right.equals(NULL)) {
                parent.right = new TreeNode(Integer.valueOf(right));
                queue.offer(parent.right);
            } else {
                parent.right = null;
            }
        }
        return root;
    }
}
