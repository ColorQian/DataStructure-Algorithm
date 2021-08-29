package top.colorfor.tree.levelorder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestInTreeRow {

    public List<Integer> largestValues(TreeNode root){
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  //将根节点加入到队列中

        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode cur = null;
            int maxRow = Integer.MIN_VALUE;
            int temp = 0;

            //将遍历当前层的节点，找出最大值，保存在maxRow中
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                temp = cur.val;
                maxRow = temp > maxRow  ? temp : maxRow;

                //如果当前节点的左右子树不为空，则加入队列
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            result.add(maxRow);
        }
        return result;
    }
}
