package com.jianzhioffer2.master;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/submissions/
 * 剑指 Offer 37. 序列化二叉树
 *
 * 参考：https://mp.weixin.qq.com/s/qGqIWM2hmL1xewygPnb3Og
 *
 */
public class Problem37_INORDER {
    String SEP = ",";
    String NULL = "#";

    // 通过前序遍历，将二叉树序列化成String
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);

        return sb.toString();
    }

    public void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);  // 中

        serializeHelper(root.left, sb);  // 左

        serializeHelper(root.right, sb); //右
    }

    // 还是利用前序遍历，将String反序列化成一棵树
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(SEP);
        LinkedList<String> list = new LinkedList<>();
        for (String node : nodes) {
            list.add(node);
        }

        return deserializeHelper(list);
    }

    public TreeNode deserializeHelper(LinkedList<String> list) {
        if (list.isEmpty()) return null;

        String rootValue = list.removeFirst();
        TreeNode root = null;
        if (rootValue.equals(NULL)) {  // 遇到"#",直接返回null
            return root;
        }

        root = new TreeNode(Integer.valueOf(rootValue));  // 中
        root.left = deserializeHelper(list);  //左
        root.right = deserializeHelper(list); // 右

        return root;
    }
}
