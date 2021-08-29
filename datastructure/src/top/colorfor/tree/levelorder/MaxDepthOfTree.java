package top.colorfor.tree.levelorder;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfTree {

    public int maxDepth(TreeNode root){
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()){
            int size = queue.size();

            TreeNode cur = null;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            depth++;
        }

        return depth;
    }
}
