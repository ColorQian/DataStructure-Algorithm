package top.colorfor.tree;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        int a = 40;
        printA(a);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(null);
        System.out.println(queue.size());


    }

    public static void printA(int a){
        if (a == 1){
            System.out.println("a="+a);
        }else if (a == 3){
            System.out.println("a == 3");
        }else if (a == 4){
            System.out.println("a = "+a);
        }else if (a == 2){
            System.out.println("a == 2");
        }else {
            System.out.println("a为其它值");
        }
    }

    //二叉树的前序遍历，非递归的方式
    public List<Integer> preOrder(TreeNode root){

        List<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = null;
        while (!stack.isEmpty()){
            cur = stack.pop();
            result.add(cur.val);

            //放入栈中的时候，先放右孩子，再放左孩子，这样弹栈的时候才是中 左 右
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }

        return result;
    }

    //中序遍历非递归
    public List<Integer> infixOrder(TreeNode root){
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){   //如果cur不为空，就层层访问，直到到达树左面的底部
                stack.push(cur);
                cur = cur.left;
            }else {  // 如果cur == null ，说明已经遍历到了树左边的底部

                cur = stack.pop();   //左 中
                result.add(cur.val);

                cur = cur.right;  //右
            }
        }
        return result;
    }

    public List<Integer> postOrder(TreeNode root){
        List<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = null;
        while (!stack.isEmpty()){
            cur = stack.pop();
            result.add(cur.val);

            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }

        Collections.reverse(result);
        return result;
    }


}
