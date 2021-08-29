package top.colorfor.tree;

import java.util.LinkedList;
import java.util.List;

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<Integer> path = new LinkedList<>();

        traversal(root, path, result, targetSum);

        return result;

    }

    private void traversal(TreeNode root, LinkedList<Integer> path, List<List<Integer>> result, int targetSum) {

        path.add(root.val);

        //已经到了叶子节点，判断是否是符合的路径，若是则开始记录路径
        if (root.left == null && root.right == null) {
            int size = path.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum += path.get(i);
            }

            //不能 result.add(path),因为回溯过程path会变化，
            // 所以要新建一个pathList保存路径的集合
            if (sum == targetSum) {
                LinkedList<Integer> pathList = new LinkedList<>();
                pathList.addAll(path);
                result.add(pathList);
            }

        }

        if (root.left != null) {
            traversal(root.left, path, result, targetSum); //递归
            path.removeLast();  //回溯


            if (root.right != null) {
                traversal(root.right, path, result, targetSum); //递归
                path.removeLast();  //回溯
            }

        }
    }


    //-----------main----------------
    public static void main(String[] args) {
        PathSum2 tree = new PathSum2();
        TreeNode root = new TreeNode(-1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(-3);
        root.left = node2;
        root.right = node3;
        node2.left = new TreeNode(4);

        List<List<Integer>> lists = tree.pathSum(root, -4);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }

}
