package top.colorfor.tree2bst;

/**找二叉树的公共祖先，这题不太好理解，最好是背一下
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class ClosestAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == p || root == q || root == null) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left != null && right != null) return root;
        if (left == null && right == null) return null;

        return left != null ? left : right;
    }
}