package top.colorfor.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    /**DFS递归
     *
     * 这道题目使用前序遍历和后序遍历都可以，唯独中序遍历不行，
     * 因为中序遍历会把某些节点的左右孩子翻转了两次！建议拿纸画一画，就理解了
     */
    public TreeNode invertTree(TreeNode root){
        if (root == null){
            return root;
        }

        invert(root);

        return root;
    }
    private void invert(TreeNode root) {

        if (root == null){
            return;
        }

        TreeNode temp = null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
    }

    //------------------------------------

    /**BFS层序遍历
     *利用层序遍历，交换当前节点的左右孩子
     */
    public TreeNode invertTreeBFS(TreeNode root){
        if (root == null){
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();

            //交换当前层的节点的左右孩子
            TreeNode cur = null;
            TreeNode temp = null;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return root;
    }
}
