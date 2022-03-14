package cc.codetop;

public class ACMBinaryTree {
    public TreeNode constructBinaryTree(int[] nodes) {
        if (nodes.length == 0) return null;

        TreeNode[] tree = new TreeNode[nodes.length];
        TreeNode root = null;
        // 把输入数组，转为二叉树节点数组
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != -1) {
                tree[i] = new TreeNode(nodes[i]);
            }
        }
        root = tree[0];

        // 遍历一遍，根据规则给左右孩子赋值即可
        for (int i = 0; 2 * i + 2 < tree.length; i++) {
            if (tree[i] != null) {
                tree[i].left = tree[2* i + 1];
                tree[i].right = tree[2* i + 2];
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ACMBinaryTree bt = new ACMBinaryTree();
        int[] nodes = new int[]{1,2,3,4,5};
        TreeNode root = bt.constructBinaryTree(nodes);
        System.out.println(root.val);
    }
}
