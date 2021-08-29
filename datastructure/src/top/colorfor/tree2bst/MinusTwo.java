package top.colorfor.tree2bst;

import java.util.ArrayList;
import java.util.List;

public class MinusTwo {

    /**方法一：
     * 把二叉搜索树转换成有序数组，然后遍历一遍数组，就统计出来最小差值了。
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        infixOrder(root,result);
        
        int size = result.size();
        int min = Integer.MAX_VALUE;
        int temp;
        for (int i = 1; i < size; i++) {
            temp = result.get(i) - result.get(i-1);
            min = min < temp ? min : temp;
        }

        return min;

    }
    private void infixOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        infixOrder(root.left,result);
        result.add(root.val);
        infixOrder(root.right,result);
    }

    /**
     * 方法二：在中序遍历的过程中，利用pre指向cur的前一个，然后做差比较，取最小
     */
    TreeNode pre;
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference2(TreeNode root){
        traversal(root);
        return result;
    }

    private void traversal(TreeNode cur) {
        if (cur == null) return;

        traversal(cur.left);//左

        if (pre != null){ //中
            result = Math.min(result,cur.val - pre.val);
        }
        pre = cur;  // 记录前一个

        traversal(cur.right);  //右
    }
}
