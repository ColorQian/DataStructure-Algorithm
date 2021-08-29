package top.colorfor.tree2bst;

/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 */
public class InsertIntoBST {

    /**方法一：迭代
     * 利用两个指针，当cur指针为空时，说明找到合适的位置，
     * 如果是val < cur.val 的条件使得cur 指向 cur.left，后为空，则让pre.left = new TreeNode(val);
     * 如果是val > cur.val 的条件使得cur 指向 cur.right，后为空，则让pre.right = new TreeNode(val);
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode pre = null;
        TreeNode cur = root;
        while (true) {

            pre = cur;

            if (val < cur.val) {
                cur = cur.left;
                if (cur == null) {
                    pre.left = new TreeNode(val);
                    break;
                }
            } else if (val > cur.val) {
                cur = cur.right;
                if (cur == null) {
                    pre.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    /**
     * 方法二：递归
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root,int val){
        //终止条件就是找到遍历的节点为null的时候，就是要插入节点的位置了，并把插入的节点返回。
        if (root == null) {
            return new TreeNode(val);
        }

        //到这里，大家应该能感受到，如何通过递归函数返回值完成了新加入节点的父子关系赋值操作了，
        // 下一层将加入节点返回，本层用root->left或者root->right将其接住。
        if (root.val < val) root.right = insertIntoBST(root.right,val);
        else if (root.val > val) root.left = insertIntoBST(root.left,val);

        return root;
    }
}
