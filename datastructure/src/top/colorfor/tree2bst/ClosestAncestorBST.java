package top.colorfor.tree2bst;

/**
 * 二叉搜索树的公共祖先
 */
public class ClosestAncestorBST {

    //方法一：迭代法
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        while (root != null){

            if (root.val > p.val && root.val > q.val) root = root.left;
            else if (root.val < p.val && root.val < q.val) root = root.right;
            else return root;
        }

        return null;
    }

    //方法二，递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

        if (root == null) return null;

        //root.val的值不在[p,q](假设p.val < q.val,其实不知道p、q谁大谁小),则递归查找
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right,p,q);
        }else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left,p,q);


        }else {

            //root.val的值在区间内，直接返回
            return root;
        }
    }
}
