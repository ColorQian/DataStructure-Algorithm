package top.colorfor.tree.levelorder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 */
public class NextConnectRight {

    public Node connect(Node root){
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);  //将根节点加入队列
        while (!queue.isEmpty()){

            int size = queue.size(); //获取队列的大小

            Node cur = null;
            if (!queue.isEmpty()){
                cur = queue.poll();   //使用cur指针，指向本层的第一个节点

                //如果当前节点的左右子节点不为空，将左右子节点加入队列
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            Node next = null;
            for (int i = 1; i < size; i++) { //由于本层的第一个节点已经出队列，所以i从1开始
                next = queue.poll();     //让cur右边的节点出队列
                cur.next = next;      //cur的next域指向cur右边的节点

                //如果当前节点的左右子节点不为空，将左右子节点加入队列
                if (next.left != null) queue.offer(next.left);
                if (next.right != null) queue.offer(next.right);

                //让cur往右边移动一位，为下一次循环做准备
                cur = next;
            }
        }

        return root;
    }
}
