package top.colorfor.tree;

import java.util.*;

/**
 * 采用非递归的方式遍历一颗二叉树
 *
 */
public class UnRecursionTree {

    /**前序遍历，非递归
     *  * 思路分析:
     *  * 1.申请一个新的栈，即为stack,然后将root节点压入栈中
     *  *
     *  * 2.从stack中弹出栈顶节点，记为root,然后将root节点的值放入result集合，
     *  *     再将root节点的右子节点(不为空的话)先压入栈中，
     *  *      最后将root节点的左子节点(不为空的话)压入栈中
     *  *
     *  * 3.不断重复步骤2,直到stack为空，全部过程结束
     *
     * @param root
     */
    public List<Integer> preOrderUnRecur(TreeNode root){
        List<Integer> result = new LinkedList<>();
        if (root != null){
            //如果根节点不为空，将其压入栈中
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()){
                //从栈中弹出栈顶元素，并打印其节点的值
                root = stack.pop();
                result.add(root.val);

                //放入栈中的时候，先放右孩子，再放左孩子，这样弹栈的时候才是中 左 右
                if (root.right != null) stack.push(root.right);
                if (root.left != null) stack.push(root.left);

            }
        }
        return result;
    }


    /**中序遍历二叉树(非递归)
     *
     * 思路分析：
     * 1.中序遍历是左中右，先访问的是二叉树顶部的节点，然后一层一层向下访问，
     * 直到到达树左面的最底部，再开始处理节点（也就是在把节点的数值放进result集合中），
     * 这就造成了处理顺序和访问顺序是不一致的。
     * 2.在使用迭代法写中序遍历，就需要借用指针的遍历来帮助访问节点，栈则用来处理节点上的元素。
     *
     * @param root 二叉树的根节点
     * @return 返回一个list集合，保存中序遍历的结果
     */
    public List<Integer> inOrderUnRecur(TreeNode root){

        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){   //如果cur不为空，就层层访问，直到到达树左面的底部
                stack.push(cur);
                cur = cur.left;  //左
            }else {  // 如果cur == null ，说明已经遍历到了树左边的底部

                cur = stack.pop();   //先弹出 左 中 再弹出右
                result.add(cur.val);

                cur = cur.right;  //右
            }
        }
        return result;
    }


    /**后序遍历二叉树(非递归)
     *
     * 思路分析:
     * 先序遍历是中左右，后续遍历是左右中，那么我们只需要调整一下先序遍历的代码顺序，
     * 就变成中右左的遍历顺序，然后在反转result集合，输出的结果顺序就是左右中了
     *
     * @param root 二叉树的根节点
     * @return 返回一个list集合，保存中序遍历的结果
     */
    public List<Integer> postOrderUnRecur(TreeNode root){

        List<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            root = stack.pop();
            result.add(root.val);

            if (root.left != null){
                stack.push(root.left);
            }

            if (root.right != null){
                stack.push(root.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
