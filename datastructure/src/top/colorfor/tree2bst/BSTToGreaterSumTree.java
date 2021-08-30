package top.colorfor.tree2bst;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 *
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * */
public class BSTToGreaterSumTree {

    TreeNode pre;
    public TreeNode convertBST(TreeNode root) {

        if (root == null) return null;

        Uninfix(root);

        return root;
    }

    //按照右 中 左 的顺序 遍历 累加 ，然后得到一个累加树
    private void Uninfix(TreeNode cur) {
        if (cur == null) {
            return;
        }

        //右
        Uninfix(cur.right);

        //中
        if (pre != null) cur.val += pre.val;
        pre = cur;

        //左
        Uninfix(cur.left);

    }
}



