package top.colorfor.tree2bst;

import java.util.Stack;

public class SearchBST {

    /**
     * 方法一：利用栈迭代
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root,int val){
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            root = stack.pop();

            if (root.val == val) { break;}
            else if (val < root.val) {
                if (root.left != null){
                    stack.push(root.left);
                }
            }else if (val > root.val){
                if (root.right != null) {
                    stack.push(root.right);
                }
            }
        }

        if (stack.isEmpty() && root.val != val){
            return null;
        }
        return root;
    }

    /**
     * 方法二：递归
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST2(TreeNode root,int val){
        if (root == null || root.val == val) return root;

        if (val < root.val) return searchBST2(root.left,val);
        if (val > root.val) return searchBST2(root.right,val);

        return null;
    }

    /**
     * 方法三：迭代，利用二叉搜索树的特性
     */
    public TreeNode searchBST3(TreeNode root,int val){
        if (root == null) return root;

        while (root != null){

            if (val < root.val) root = root.left;
            else if (val > root.val) root = root.right;
            else return root;
        }

        return null;
    }

    //---------------------------

    public static void main(String[] args) {
        SearchBST search = new SearchBST();

        TreeNode root = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        root.left = node3;
        root.right = node7;
        node7.right = node8;

        TreeNode result = search.searchBST2(root,8);
        System.out.println(result.val);
    }

}
