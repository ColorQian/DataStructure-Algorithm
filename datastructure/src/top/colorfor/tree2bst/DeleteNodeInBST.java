package top.colorfor.tree2bst;

public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int val) {

        if (root == null) return null; //没找到要删除的节点，直接返回null

        if (root.val == val){
            //第一种情况，root节点的左右孩子都为空，说明要删除的是叶子节点，直接返回null
            if (root.left == null && root.right == null) {
                return null;

            //第二种情况，左孩子为空，返回右孩子
            } else if (root.left == null) {
                return root.right;

            //第三种情况，右孩子为空，返回左孩子
            }else if (root.right == null){
                return root.left;

            //第四种情况，左右孩子都不为空，把，左孩子添加到以右孩子为头节点的树的最左边
            }else {
                TreeNode cur = root.right;
                while (cur.left != null){ //一直往左遍历，找到root节点的右孩子的最左边
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }

        //这里相当于把新的节点返回给上一层，上一层就要用 root->left 或者 root->right接住
        if (val < root.val) root.left = deleteNode(root.left,val);
        if (val > root.val) root.right = deleteNode(root.right,val);

        return root;
    }

}
