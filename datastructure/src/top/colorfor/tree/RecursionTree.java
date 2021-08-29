package top.colorfor.tree;

public class RecursionTree {

    public void preOrderRecur(TreeNode root){
        System.out.println("前序遍历二叉树(递归)");

        if (root == null){
            return;
        }

        //中 左 右
        System.out.println(root.val);

        preOrderRecur(root.left);

        preOrderRecur(root.right);
    }

    //中序遍历二叉树，递归
    public void inOrderRecur(TreeNode root){
        if (root == null){
            return;
        }

        //前 中 右
        inOrderRecur(root.left);
        System.out.println(root.val);
        inOrderRecur(root.right);

    }

    //后序遍历二叉树，递归
    public void postOrderRecur(TreeNode root){
        if (root == null){
            return;
        }

        //左 右 中
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        System.out.println(root.val);
    }
}
