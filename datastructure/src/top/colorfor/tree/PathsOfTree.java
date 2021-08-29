package top.colorfor.tree;

import java.util.LinkedList;
import java.util.List;

public class PathsOfTree {

    public List<String> treePaths(TreeNode root) {
        List<String> result = new LinkedList<>();  //result集合作为最后的结果
        if (root == null) return result;

        LinkedList<Integer> path = new LinkedList<>();  //path集合保存递归过程中的节点的值
        traversal(root,path,result);
        return result;

    }

    private void traversal(TreeNode root, LinkedList<Integer> path, List<String> result) {
        path.add(root.val);  //将当前节点值加入到path集合中

        //遍历到了叶子节点
        //将path保存的节点值，全部转为字符串sPath,这样就得到了路径，最后放入result集合中
        if (root.left == null && root.right == null){
            int size = path.size();
            String sPath = "";
            for (int i = 0; i < size - 1; i++) {
                sPath += path.get(i);
                sPath += "->";
            }
            sPath += path.get(size - 1);
            result.add(sPath);
        }

        if (root.left != null){
            traversal(root.left,path,result); //递归
            path.removeLast();  //回溯
        }

        if (root.right != null){
            traversal(root.right,path,result); //递归
            path.removeLast();  //回溯
        }
    }

    //-----------main----------------
   /* public static void main(String[] args) {
        PathsOfTree tree = new PathsOfTree();
        TreeNode root = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        node2.left = new TreeNode(4);

        List<String> strings = tree.treePaths(root);

        for (String string : strings) {
            System.out.println(string);
        }
    }*/
}
