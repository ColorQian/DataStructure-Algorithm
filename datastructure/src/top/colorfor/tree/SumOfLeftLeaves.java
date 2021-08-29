package top.colorfor.tree;

import java.util.Stack;

/**
 * 计算给定二叉树的所有左叶子之和。
 */
public class SumOfLeftLeaves {

    /**
     * 递归法求二叉树的所有左叶子节点之和
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root){

        if (root == null) return 0;  //递归终止条件

        int mid = 0;
        //左叶子节点的条件
        if (root.left != null && root.left.left == null && root.left.right == null){
            mid = root.left.val;
        }

        //递归root节点的左子树和右子树
        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);

        //把所有找到的左叶子节点求和
        int sum = mid + left + right;
        return sum;
    }

    //--------------------------------

    //迭代法，使用栈
    public int sumOfLeftLeaves2(TreeNode root){
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;

        while (!stack.isEmpty()){
            root = stack.pop();
            //左叶子节点的条件
            if (root.left != null && root.left.left == null && root.left.right == null){
                sum += root.left.val;
            }

            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);

        }
        return sum;
    }
}
