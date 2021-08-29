package top.colorfor.tree.levelorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 */
public class NTreeLevelOrder {

    public List<List<Integer>> levelOrder(Node root){

        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);  //将根节点加入队列
        while (!queue.isEmpty()){

            int size = queue.size();
            Node cur = null;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                //队列的头节点出队列，并将节点的值加入该层list集合
                cur = queue.poll();
                list.add(cur.val);

                //如果该节点的子节点不为空，则全部加入队列中
                if (cur.children != null){
                    List<Node> children = cur.children;
                    int len = children.size();
                    int index = 0;
                    while (index < len){
                        queue.offer(children.get(index++));
                    }
                }

            }

            //将当前层的节点值集合list加入到result集合中
            result.add(list);
        }



        return result;

    }
}
