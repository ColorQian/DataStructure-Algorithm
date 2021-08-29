package top.colorfor.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodes {

    /**方法一
     * 利用层序遍历的模板，统计二叉树的节点个数
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //LinkedList可以作为Queue的实现类
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);   //将根节点加入队列

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(); //取出当前队列的大小

            TreeNode cur = null;

            //将队列中的元素依次取出，然后让其左右子树(如果不为空的话)入队列
            for (int i = 0; i < size; i++) {
                count++;   //记录当前二叉树的节点个数
                cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return count;
    }

    /**方法二
     * 利用递归统计二叉树的节点个数
     */
    public int countNode(TreeNode root){
        return getNodesNum(root);
    }
    private int getNodesNum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftNum = getNodesNum(root.left);  //左
        int rightNum = getNodesNum(root.right);  //右
        int treeNum = leftNum + rightNum + 1;  //中
        return treeNum;
    }
}
