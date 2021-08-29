package top.colorfor.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class SymmetricTree {

    /**
     * 方法一：递归法
     */
    public boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }

        return compare(root.left,root.right);
    }
    private boolean compare(TreeNode left, TreeNode right) {

        //首先判断节点为空的情况
        if (left == null && right == null) return true;
        else if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        // 排除了空节点，再排除数值不相同的情况
        else if (left.val != right.val) return false;

        // 此时就是：左右节点都不为空，且数值相同的情况
        // 此时才做递归，做下一层的判断
        boolean outside = compare(left.left,right.right); // 比较左节点的左孩子 和 右节点的右孩子
        boolean inside = compare(left.right,right.left); // 比较左节点的右孩子 和 右节点的左孩子
        boolean isSame = outside && inside;   // 左子树：中、 右子树：中 （逻辑处理）
        return isSame;
    }


    /**
     * 方法二：迭代法(使用一个队列实现)
     */
    public boolean isSymmetric2(TreeNode root){
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left); // 将左子树头结点加入队列
        queue.offer(root.right); // 将右子树头结点加入队列

        while (!queue.isEmpty()){ // 接下来就要判断这这两个树是否相互翻转
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            if (leftNode == null && rightNode == null){ // 左节点为空、右节点为空，此时说明是对称的
                continue;
            }

            // 左右一个节点不为空，或者都不为空但数值不相同，返回false
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val){
                return false;
            }

            queue.offer(leftNode.left);   // 加入左节点左孩子
            queue.offer(rightNode.right); // 加入右节点右孩子
            queue.offer(leftNode.right);  // 加入左节点右孩子
            queue.offer(rightNode.left);  // 加入右节点左孩子
        }
        return true;
    }
}
