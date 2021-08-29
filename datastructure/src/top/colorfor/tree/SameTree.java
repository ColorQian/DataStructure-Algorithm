package top.colorfor.tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**leetcode 100.相同的树
 *
 * 方法一：迭代法
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class SameTree {

    public boolean isSameTree2(TreeNode p, TreeNode q){
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(q);
        queue.offer(p);

        while (!queue.isEmpty()){
            TreeNode root1 = queue.poll();
            TreeNode root2 = queue.poll();

            if (root1 == null && root2 ==null){
                continue;      //终止本次循环，进行下一次循环
            }

            //如果其中一个为空，或者节点的值不相等，直接返回false
            if (root1 == null || root2 == null || root1.val != root2.val){
                return false;
            }

            //如果root1.val == root2.val,继续进行后续 对应节点 的比较
            queue.offer(root1.left);
            queue.offer(root2.left);
            queue.offer(root1.right);
            queue.offer(root2.right);
        }
        return true;
    }

    //...................

    /**
     * 方法二：递归法
     */
    public boolean isSameTree(TreeNode p, TreeNode q){
        return compare(p,q);
    }

    private boolean compare(TreeNode p, TreeNode q) {

        //判断节点为空的一些情况
        if (p == null && q == null){
            return true;
        }else if (p == null && q != null){
            return false;
        }else if (p != null && q == null){
            return false;
        }else if (p.val != q.val){
            return false;
        }

        //程序走到这一步，说明p.val == q.val,则进行p、q左右两个子树的递归比较
        Boolean left = compare(p.left,q.left);
        Boolean right = compare(p.right,q.right);

        return left && right;
    }
}
