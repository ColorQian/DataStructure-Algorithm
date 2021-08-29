package top.colorfor.tree2bst;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

    /**
     * 方法一：利用中序遍历将二叉搜索树变为一个序列，判断这个序列 是否是升序的 <=> 是否是二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        //中序遍历得到一个序列
        infixOrder(root,result);

        //正常的BST按照中序遍历可以得到一个升序序列，所以可以以此来判断是不是一个BST
        int size = result.size();
        for (int i = 1; i < size; i++) {
            if (result.get(i) <= result.get(i-1)) return false;
        }

        return true;
    }
    //中序遍历
    private void infixOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        infixOrder(root.left,result);
        result.add(root.val);
        infixOrder(root.right,result);
    }

    //----------------------

    /**方法二：
     *利用双指针判断中序遍历时二叉搜索树 是否是严格递增的
     */
    TreeNode pre;
    boolean flag;
    public boolean isValidBST2(TreeNode root){
        if (root == null) return false;

        flag = true;
        infixOrder2(root);

        return flag;
    }
    private void infixOrder2(TreeNode root) {

        if (root == null) return;
        infixOrder2(root.left);  //左

        if (pre != null) {       //中
            if (root.val <= pre.val){
                flag = false;
                return;
            }
        }

        pre = root;
        infixOrder2(root.right);   //右
    }
}
