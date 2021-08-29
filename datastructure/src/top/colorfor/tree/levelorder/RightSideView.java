package top.colorfor.tree.levelorder;


import top.colorfor.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，
 * 按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class RightSideView {

    /**
     *
     * @param root 二叉树的根节点
     * @return  返回层序遍历的结果
     */
    public List<Integer> levelOrder(TreeNode root){
        List<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }

        //LinkedList可以作为Queue的实现类
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);   //将根节点加入队列

        while (!queue.isEmpty()){
            int size = queue.size(); //取出当前队列的大小
            LinkedList<Integer> list = new LinkedList<>();
            TreeNode cur = null;

            //将队列中的头元素取出，然后让其左右子树(如果不为空的话)入队列
            for (int i = 0; i < size; i++) {
                cur = queue.poll();

                //如果是最后一个，就加入result集合
                if (i == size-1) result.add(cur.val);

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

        }

        return result;


    }
}
