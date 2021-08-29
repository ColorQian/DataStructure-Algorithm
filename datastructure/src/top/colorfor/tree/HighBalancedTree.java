package top.colorfor.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HighBalancedTree {

    /**方法一:迭代法，使用层序遍历
     *
     * 用栈来模拟前序遍历，遍历每一个节点的时候，
     * 再去判断左右孩子的高度是否符合，代码如下
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root){
        if (root == null){
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode cur = null;
        while (!stack.isEmpty()){
            cur = stack.pop();

            if (Math.abs(levelOrder(cur.left) - levelOrder(cur.right)) > 1){
                return false;
            }

            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }

        return true;
    }
    //此方法可以获取当前root节点距离叶子节点的高度
    private int levelOrder(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int high = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode cur;
            high++;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return high;
    }
}
