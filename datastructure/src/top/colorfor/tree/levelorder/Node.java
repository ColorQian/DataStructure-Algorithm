package top.colorfor.tree.levelorder;

import java.util.List;

public class Node {

    public int val;
    public List<Node> children;

    //做题需要，临时添加
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}
