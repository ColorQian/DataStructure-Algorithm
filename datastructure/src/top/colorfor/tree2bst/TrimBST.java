package top.colorfor.tree2bst;

/**这题不太好理解，最好是背住代码！！！
 *
 * 题目：
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，
 * 使得所有节点的值在[low, high]中。修剪树不应该改变保留在树中的元素的相对结构
 * （即，如果没有被移除，原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案。
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 *
 * 链接：https://leetcode-cn.com/problems/trim-a-binary-search-tree
 */
public class TrimBST {

    public TreeNode trimBST(TreeNode root,int low,int high){
        if (root == null) {
            return null;
        }

        if (root.val < low){ // 寻找符合区间[low, high]的节点
            return trimBST(root.right,low,high);
        }

        if (root.val > high){  // 寻找符合区间[low, high]的节点
            return trimBST(root.left,low,high);
        }

        //代码走到这里，说明root.val的值，在[low,high]区间内
        root.left = trimBST(root.left,low,high);  // root->left接入符合条件的左孩子
        root.right = trimBST(root.right,low,high);  // root->right接入符合条件的右孩子

        return root;

    }

    //---------------

    public static void main(String[] args) {

        TrimBST bst = new TrimBST();

        TreeNode root = new TreeNode(3);

        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);

        root.left = node0;
        root.right = node4;
        node0.right = node2;
        node2.left = node1;

        TreeNode treeNode = bst.trimBST(root, 1, 3);

    }
}