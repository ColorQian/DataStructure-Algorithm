package com.programmercarl.binarytree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 反转二叉树
 */
public class InvertBT {
    //方法一:递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        traversal(root);

        return root;
    }
    //使用了后序遍历：左 右 中
    void traversal(TreeNode cur) {  //1.确定递归的返回值和参数
        if (cur == null) return;    //2.递归的终止条件

        //3.递归的单层逻辑
        traversal(cur.left);   //左
        traversal(cur.right); //右

        TreeNode temp = cur.left;       //中(交换节点的左右孩子)
        cur.left = cur.right;
        cur.right = temp;
    }

    //方法二：使用栈迭代
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            TreeNode temp = cur.left;  //中(交换节点的左右孩子)
            cur.left = cur.right;
            cur.right = temp;

            //先压右 再压左，这样弹出时，先弹左再弹右(满足中左右的顺序，即为前序遍历)
            if (cur.right != null) stack.push(cur.right);  //右
            if (cur.left != null) stack.push(cur.left);  //左
        }
        return root;
    }

    //方法三：使用队列进行层序遍历
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                TreeNode temp = cur.left;  //中
                cur.left = cur.right;
                cur.right = temp;

                if (cur.left != null) queue.offer(cur.left); //左
                if (cur.right != null) queue.offer(cur.right); //右
            }
        }
        return root;
    }
}
