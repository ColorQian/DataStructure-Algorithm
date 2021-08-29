package top.colorfor.tree.levelorder;

import top.colorfor.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 */
public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root){
        List<Double> result = new LinkedList<>();
        if (root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  //根节点入队列
        while (!queue.isEmpty()){
            
            int size = queue.size(); // 获取队列的大小
            double average = 0.0;
            double sum = 0.0;
            TreeNode cur = null;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                sum = sum + cur.val; // sum累加，把每层的节点值相加

                if (i == size-1){ // 遇到每层的最后一个节点，求该层的平均值
                    average = sum / size;
                }

                //让左右子树(如果不为空的话)入队列
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);

            }

            result.add(average);

        }

        return result;

    }
}
