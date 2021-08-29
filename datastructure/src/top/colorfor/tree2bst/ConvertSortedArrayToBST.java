package top.colorfor.tree2bst;

/**题目：
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 *
 * 本题可以不用考虑是不是高度平衡的
 * 另外，此题和 最大二叉树 有点类似
 *
 * 最大二叉树题目：
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * 题目地址：https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0) return null;

        TreeNode root = traversal(nums,0,nums.length - 1);

        return root;
    }

    private TreeNode traversal(int[] nums, int left, int right) {

        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        //左闭右闭
        root.left = traversal(nums,left,mid-1);
        root.right = traversal(nums,mid+1,right);

        return root;

    }
}
