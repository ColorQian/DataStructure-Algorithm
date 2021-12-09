package com.programmercarl.binarytree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * 填充每个节点的下一个右侧节点指针
 */
public class PopulatingNextRightPointer {
    //使用双指针 来 填充每个节点的下一个右侧节点指针
    public Node1 connect(Node1 root) {
        if (root == null) return root;
        //初始化队列同时将根节点加入队列中
        Queue<Node1> queue = new LinkedList<>();
        queue.offer(root);

        //外层的while循环迭代的是层数
        while (!queue.isEmpty()) {
            //记录当前队列的大小
            int size = queue.size();

            //pre保存上一个节点，cur指向当前节点
            Node1 pre = new Node1(0);
            Node1 cur = null;

            //遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                cur = queue.poll();   //从队列中取出节点
                pre.next = cur;       //连接
                pre = cur;            //为下一次连接做准备(对于下一次 当前的cur就变成了pre)

                //拓展下一层节点
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        //返回根节点
        return root;
    }
}
