package top.colorfor.tree.levelorder;


import top.colorfor.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树的层序遍历
public class LevelOrder {

    /**
     *
     * @param root 二叉树的根节点
     * @return  返回层序遍历的结果
     */
    public List<List<Integer>> levelOrder(TreeNode root){

        List<List<Integer>> result = new LinkedList<>();
        if (root == null){
            return result;
        }

        //LinkedList可以作为Queue的实现类
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);   //将根节点加入队列

        while (!queue.isEmpty()){
            int size = queue.size(); //取出当前队列的大小
            List<Integer> list = new ArrayList<>();
            TreeNode cur = null;

            //将队列中的元素依次取出，然后让其左右子树(如果不为空的话)入队列
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                list.add(cur.val);

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            //将每层遍历的结果放入result集合中
            result.add(list);
        }

        return result;

    }
}
