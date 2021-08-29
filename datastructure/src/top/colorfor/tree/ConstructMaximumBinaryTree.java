package top.colorfor.tree;

public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return traversal(nums,0,nums.length);
    }

    private TreeNode traversal(int[] nums, int left, int right) { //递归的参数和返回值

        //递归终止条件
        if (left >= right){
            return null;
        }

        //分割点下标,因为下面比较要用到，所以要赋初始值
        int maxValueIndex = left;
        //寻找分割点
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxValueIndex]) maxValueIndex = i;
        }

        TreeNode root = new TreeNode(nums[maxValueIndex]);

        // 左闭右开：[left, maxValueIndex)
        root.left = traversal(nums,left,maxValueIndex);
        // 左闭右开：[maxValueIndex + 1, right)
        root.right = traversal(nums,maxValueIndex+1,right);

        return root;

    }
}
