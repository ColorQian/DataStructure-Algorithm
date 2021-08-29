package top.colorfor.tree;

import java.util.LinkedList;
import java.util.List;

public class PathSum {

    public boolean hasPathSum(TreeNode root,int targetSum){
        if (root == null) return false;
        LinkedList<Integer> path = new LinkedList<>();

        List<Integer> result = new LinkedList<>();
        traversal(root,path,result,targetSum);

        return result.contains(targetSum);
    }

    private void traversal(TreeNode root, LinkedList<Integer> path, List<Integer> result,int targetSum) {
        path.add(root.val);

        if (root.left == null && root.right == null){
            int size = path.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum += path.get(i);
            }

            result.add(sum);
            if (sum == targetSum) {
                 return;
            }
        }

        if (root.left != null){
            traversal(root.left,path,result,targetSum);
            path.removeLast();
        }

        if (root.right != null){
            traversal(root.right,path,result,targetSum);
            path.removeLast();
        }
    }

    //-----------main----------------
    public static void main(String[] args) {
        PathSum tree = new PathSum();
        TreeNode root = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        node2.left = new TreeNode(4);

        boolean b = tree.hasPathSum(root, 4);
        System.out.println(b);
    }
}
